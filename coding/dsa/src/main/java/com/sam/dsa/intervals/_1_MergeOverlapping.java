package com.sam.dsa.intervals;

import com.sam.dsa.intervals.base.Interval;
import com.sam.dsa.intervals.base.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// Utilize a sweep line algorithm to merge a given number of intervals
public class _1_MergeOverlapping {

  public static List<Interval> mergeOverlappingIntervals(int[][] intervals) {
    List<Timestamp> timestamps =
        Arrays.stream(intervals)
            .<Timestamp>mapMulti(
                (interval, consumer) -> {
                  consumer.accept(new Timestamp(interval[0], 0));
                  consumer.accept(new Timestamp(interval[1], 1));
                })
            .sorted(Comparator.comparing(Timestamp::getTime).thenComparing(Timestamp::getType))
            .toList();

    List<Interval> merged = new ArrayList<>();
    int count = 0;

    int start = 0;
    for (Timestamp timestamp : timestamps) {
      if (timestamp.getType() == 0) {
        count = count + 1;
        if (count == 1) {
          start = timestamp.getTime();
        }
      } else {
        count = count - 1;
        if (count == 0) {
          merged.add(new Interval(start, timestamp.getTime()));
        }
      }
    }

    return merged;
  }
}
