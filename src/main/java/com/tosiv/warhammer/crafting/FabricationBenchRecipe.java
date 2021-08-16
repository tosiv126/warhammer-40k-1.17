package com.tosiv.warhammer.crafting;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.tosiv.warhammer.util.registry.ModBlocks;
import com.tosiv.warhammer.util.registry.ModRecipes;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.StringNbtReader;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FabricationBenchRecipe implements Recipe<PlayerInventory> {

    private static final int MAX_ALLOWED_ITEMS = 5;

    private final Identifier id;
    private final ItemStack result;
    private final DefaultedList<ItemStack> inputs;

    public FabricationBenchRecipe(Identifier id, ItemStack result, DefaultedList<ItemStack> inputs) {
        this.id = id;
        this.result = result;
        this.inputs = inputs;
    }

    @Override
    public boolean matches(PlayerInventory inventory, World world) {
        return countMissingItems(inventory, false) == 0;
    }

    private int countMissingItems(PlayerInventory inventory, boolean consumeItems) {
        // make a deep copy of the inputs that we can subsequently modify
        List<ItemStack> missingItems = new ArrayList<>(inputs.size());
        for (ItemStack input : inputs) {
            missingItems.add(input.copy());
        }

        inv:
        for (int i = 0; i < inventory.size(); i++) {
            ItemStack invStack = inventory.getStack(i);
            if (!invStack.isEmpty()) {
                ItemStack stack = invStack.copy();
                int amount = stack.getCount();
                for (Iterator<ItemStack> iterator = missingItems.iterator(); iterator.hasNext(); ) {
                    ItemStack toSearch = iterator.next();
                    if (ItemStack.areItemsEqual(toSearch, stack)) {
                        int toConsume = Math.min(amount, toSearch.getCount());
                        if (consumeItems) {
                            inventory.removeStack(i, toConsume);
                        }
                        toSearch.decrement(toConsume);
                        if (toSearch.isEmpty()) {
                            iterator.remove();
                        }
                        if (stack.isEmpty()) {
                            continue inv;
                        }
                    }
                }
            }
        }
        return missingItems.stream().filter(stack -> !stack.isEmpty()).mapToInt(ItemStack::getCount).sum();
    }

    @Override
    public ItemStack craft(PlayerInventory inventory) {
        countMissingItems(inventory, true);
        return getOutput().copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getOutput() {
        return result;
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ModBlocks.IMPERIAL_FABRICATION_BENCH);
    }

    @Override
    public Identifier getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.FABRICATION_BENCH_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.FABRICATION_BENCH;
    }

    public DefaultedList<ItemStack> getInputs() {
        return inputs;
    }

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> value = DefaultedList.ofSize(inputs.size(), Ingredient.EMPTY);
        for (int i = 0; i < inputs.size(); i++) {
            value.set(i, Ingredient.ofStacks(inputs.get(i)));
        }
        return value;
    }

    public static class Serializer implements RecipeSerializer<FabricationBenchRecipe> {

        private static ItemStack getStack(JsonObject json) {
            Item item = ShapedRecipe.getItem(json);
            int count = JsonHelper.getInt(json, "count", 1);
            if (count < 1) {
                throw new JsonSyntaxException("Invalid output count: " + count);
            }
            ItemStack value = new ItemStack(item, count);
            if (json.has("data")) {
                try {
                    String snbt = JsonHelper.getString(json, "data");
                    NbtCompound nbt = new StringNbtReader(new StringReader(snbt)).parseCompound();
                    value.setTag(nbt);
                } catch (CommandSyntaxException e) {
                    throw new JsonSyntaxException("unable to parse data tag", e);
                }
            }
            return value;
        }

        @Override
        public FabricationBenchRecipe read(Identifier id, JsonObject json) {
            JsonArray ingredients = JsonHelper.getArray(json, "ingredients");
            DefaultedList<ItemStack> inputs = DefaultedList.of();

            for (int i = 0; i < ingredients.size(); i++) {
                JsonObject element = JsonHelper.asObject(ingredients.get(i), "ingredients[" + i + "]");
                ItemStack stack = getStack(element);
                if(!stack.isEmpty()) {
                    inputs.add(stack);
                }
            }
            if (inputs.isEmpty()) {
                throw new JsonParseException("No ingredients for recipe");
            } else if (inputs.size() > MAX_ALLOWED_ITEMS) {
                throw new JsonParseException("Too many ingredients for recipe");
            } else {
                ItemStack result = ShapedRecipe.outputFromJson(JsonHelper.getObject(json, "result"));
                return new FabricationBenchRecipe(id, result, inputs);
            }
        }

        @Override
        public FabricationBenchRecipe read(Identifier id, PacketByteBuf buf) {
            int size = buf.readVarInt();
            DefaultedList<ItemStack> inputs = DefaultedList.ofSize(size, ItemStack.EMPTY);
            for (int i = 0; i < inputs.size(); i++) {
                ItemStack stack = buf.readItemStack();
                inputs.set(i, stack);
            }
            ItemStack result = buf.readItemStack();
            return new FabricationBenchRecipe(id, result, inputs);
        }

        @Override
        public void write(PacketByteBuf buf, FabricationBenchRecipe recipe) {
            buf.writeVarInt(recipe.getInputs().size());
            for (ItemStack stack : recipe.getInputs()) {
                buf.writeItemStack(stack);
            }
            buf.writeItemStack(recipe.result);
        }
    }
}
