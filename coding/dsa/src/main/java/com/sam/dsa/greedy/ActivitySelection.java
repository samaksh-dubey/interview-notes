package com.sam.dsa.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ActivitySelection {

    static class Activity {
        int start, end;

        private Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        static Activity of(int start, int end) {
            return new Activity(start, end);
        }

        @Override
        public String toString() {
            return "{"  + start + "," + end + "}";
        }
    }

    static List<Activity> maxActivities(Activity[] activities) {
        List<Activity> result = new ArrayList<>();
        Arrays.sort(activities, Comparator.comparingInt(a -> a.end));
        result.add(activities[0]);
        Activity curr_activity = activities[0];
        for(int i = 1; i < activities.length; i++) {
            if (curr_activity.end < activities[i].start) {
                result.add(activities[i]);
                curr_activity = activities[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Activity[] activities = new Activity[] {
                Activity.of(1, 4), Activity.of(3, 5), Activity.of(0, 6), Activity.of(5, 7),
                Activity.of(3, 8), Activity.of(5, 9), Activity.of(6, 10), Activity.of(8, 11),
                Activity.of(8, 12), Activity.of(2, 13), Activity.of(12, 14)};

        System.out.println(maxActivities(activities));
    }
}
