package com.sam.dsa.intervals.base;

import lombok.Getter;

public class Interval {
  @Getter private final int start, end;

  public Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }
}
