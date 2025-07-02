package com.sam.dsa.greedy;

import java.util.Arrays;

public class MinimumRailwayPlatform {

    static int minPlatforms(double[] arrival, double[] departure) {
        if (arrival.length == 0 || departure.length == 0)
            return 0;

        Arrays.sort(arrival);
        Arrays.sort(departure);

        int max = 1, countTrain = 1, i = 1, j = 0;
        while (i < arrival.length) {
            if (arrival[i] < departure[j]) {
                countTrain++;
                max = Math.max(max, countTrain);
                i++;
            } else {
                countTrain--;
                j++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        double[] arrival = {2.0, 2.1, 3.0, 3.2, 3.5, 5.0};
        double[] departure = {2.3, 3.4, 3.2, 4.3, 4.0, 5.2};
        System.out.println(minPlatforms(arrival, departure));
    }
}
