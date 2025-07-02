package com.sam.dsa.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    static class Item {
        final int weight, value;
        final double rate;

        private Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
            this.rate = ((double) this.value) / ((double) this.weight);
        }

        static Item of(int weight, int value) {
            return new Item(weight, value);
        }
    }

    static double knapsack(int[] weight, int[] value, int cap) {
        Item[] items = new Item[weight.length];

        for (int i = 0; i < weight.length; i++)
            items[i] = Item.of(weight[i], value[i]);

        Arrays.sort(items, Comparator.comparingDouble(a -> -a.rate));

        double values = 0, weights = 0;
        for (int i = 0; i < items.length; i++) {
            if (weights + items[i].weight < cap) {
                weights = weights + items[i].weight;
                values = values + items[i].value;
            } else {
                double fraction = ((double) cap / (double) items[i].weight - 1);
                values = values + items[i].value * fraction;
            }
        }

        return values;
    }

    public static void main(String[] args) {
        int[] value = {60, 100, 120};
        int[] weight = {10, 20, 30};
        System.out.println(knapsack(weight, value, 50));
    }
}
