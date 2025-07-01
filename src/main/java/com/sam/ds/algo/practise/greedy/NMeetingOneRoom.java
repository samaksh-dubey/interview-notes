package com.sam.ds.algo.practise.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NMeetingOneRoom {

    static class Meeting {
        int start, end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "{" + start + "," + end + "}";
        }
    }

    static List<Meeting> maxMeetings(int[] start, int[] end) {
        Meeting[] meetings = new Meeting[start.length];

        for(int i = 0; i < start.length; i++)
            meetings[i] = new Meeting(start[i], end[i]);

        Arrays.sort(meetings, Comparator.comparingInt(a -> a.end));

        List<Meeting> result = new ArrayList<>();
        Meeting current = meetings[0];
        result.add(current);
        for (int i = 1; i < meetings.length; i++) {
            if (current.end < meetings[i].start) {
                current = meetings[i];
                result.add(current);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] s = { 1, 3, 0, 5, 8, 5 };
        int[] f = { 2, 4, 6, 7, 9, 9 };
        List<Meeting> meetings = maxMeetings(s, f);
        System.out.println(meetings);
    }

}
