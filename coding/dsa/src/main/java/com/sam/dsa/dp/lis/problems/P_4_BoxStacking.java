package com.sam.dsa.dp.lis.problems;

import java.util.Arrays;
import java.util.stream.IntStream;

public class P_4_BoxStacking {

    static class Box implements Comparable<Box> {
        int h, w, d, area;

        private Box(int h, int w, int d) {
            this.h = h;
            this.d = d;
            this.w = w;
            this.area = this.w * this.d;
        }

        public static Box of(int h, int w, int d) {
            return new Box(h, w, d);
        }

        @Override
        public int compareTo(Box o) {
            return o.area - this.area;
        }
    }

    static Box[] generateRotations(Box[] boxes) {
        Box[] rotations = new Box[3 * boxes.length];
        for(int i = 0; i < boxes.length; i++) {
            rotations[3 * i] = Box.of(boxes[i].h, Math.max(boxes[i].w, boxes[i].d), Math.min(boxes[i].w, boxes[i].d));
            rotations[3 * i + 1] = Box.of(boxes[i].w, Math.max(boxes[i].h, boxes[i].d), Math.min(boxes[i].h, boxes[i].d));
            rotations[3 * i + 2] = Box.of(boxes[i].d, Math.max(boxes[i].w, boxes[i].h), Math.min(boxes[i].w, boxes[i].h));
        }
        return rotations;
    }

    static int maxHeight(Box[] boxes) {
        if(boxes == null || boxes.length == 0)
            return 0;
        boxes = generateRotations(boxes);
        if(boxes.length == 0)
            return 0;
        Arrays.sort(boxes);

        int N = boxes.length;
        int[] dp = new int[N];
        int[] heights = Arrays.stream(boxes).mapToInt(box -> box.h).toArray();
        int[] width = Arrays.stream(boxes).mapToInt(box -> box.w).toArray();
        int[] depth = Arrays.stream(boxes).mapToInt(box -> box.d).toArray();
        int[] area = Arrays.stream(boxes).mapToInt(box -> box.area).toArray();
        for (int n = 1; n <= N; n++) {
            dp[n-1] = boxes[n-1].h;
            for (int i = 1; i <= n; i++) {
                if (boxes[n-1].w < boxes[i-1].w && boxes[n-1].d < boxes[i-1].d && dp[i-1] + boxes[n-1].h > dp[n-1])
                    dp[n-1] = dp[i-1] + boxes[n-1].h;
            }
        }
        return IntStream.of(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        Box[] boxes = new Box[] { Box.of(4, 6, 7),
                Box.of(1, 2, 3),
                Box.of(4, 5, 6),
                Box.of(10, 12, 32)};
        System.out.println(maxHeight(boxes));
    }
}
