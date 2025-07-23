package com.sam.dsa._3_queue.questions;

import java.util.*;

public class _1_GenerateBinaryNumber {

  private static final String ZERO = "0";
  private static final String ONE = "1";

  public static List<String> generate(int n) {
    List<String> generated = new ArrayList<>();

    Queue<String> queue = new LinkedList<>();
    queue.add(ONE);

    while (!queue.isEmpty() && n-- > 0) {
      String num = queue.poll();
      generated.add(num);
      queue.add(num + ZERO);
      queue.add(num + ONE);
    }

    return generated;
  }
}
