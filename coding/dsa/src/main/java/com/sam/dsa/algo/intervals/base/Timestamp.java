package com.sam.dsa.algo.intervals.base;

import lombok.Getter;

public class Timestamp {
  @Getter private final int time;
  @Getter private final int type; // 0 for startTime and 1 for endTime

  public Timestamp(int time, int type) {
    this.time = time;
    this.type = type;
  }
}
