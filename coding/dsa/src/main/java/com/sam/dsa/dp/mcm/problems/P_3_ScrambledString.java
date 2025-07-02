package com.sam.dsa.dp.mcm.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P_3_ScrambledString {
    static class Recursion {
        static boolean isScramble(String S1, String S2) {
            if (S1.length() != S2.length())
                return false;

            int n = S1.length();

            if (n == 0)
                return true;

            if (S1.equals(S2))
                return true;

            if (!isAnagram(S1, S2))
                return false;

            for(int i = 1; i < n; i++) {

                if (isScramble(S1.substring(0, i), S2.substring(0, i)) && isScramble(S1.substring(i, n), S2.substring(i, n)))
                    return true;

                if (isScramble(S1.substring(n - i, n), S2.substring(0, i)) && isScramble(S1.substring(0, n - i), S2.substring(i, n)))
                    return true;
            }
            return false;
        }

        static boolean isAnagram(String S1, String S2) {
            char[] tempArray1 = S1.toCharArray();
            char[] tempArray2 = S2.toCharArray();

            Arrays.sort(tempArray1);
            Arrays.sort(tempArray2);

            String copy_S1 = new String(tempArray1);
            String copy_S2 = new String(tempArray2);

            return copy_S1.equals(copy_S2);
        }
    }

    static class DP {
        static boolean isScramble(String S1, String S2, Map<String, Map<String, Boolean>> map) {
            if (S1.length() != S2.length())
                return false;

            int n = S1.length();

            if (n == 0)
                return true;

            if (S1.equals(S2))
                return true;

            if (!isAnagram(S1, S2))
                return false;

            for(int i = 1; i < n; i++) {

                if (calculate(S1.substring(0, i), S2.substring(0, i), map) && calculate(S1.substring(i, n), S2.substring(i, n), map))
                    return true;

                if (calculate(S1.substring(n - i, n), S2.substring(0, i), map) && calculate(S1.substring(0, n - i), S2.substring(i, n), map))
                    return true;
            }
            return false;
        }

        static boolean calculate(String S1, String S2, Map<String, Map<String, Boolean>> map) {
            if (map.containsKey(S1) && map.get(S1).containsKey(S2))
                return map.get(S1).get(S2);
            Boolean result = isScramble(S1, S2, map);

            Map<String, Boolean> submap = new HashMap<>();
            if(map.containsKey(S1)) {
                submap = map.get(S1);
            }
            Boolean mapVal = result;
            if(submap.containsKey(S2)) {
                mapVal = submap.get(S2);
            }
            submap.put(S2, mapVal);
            map.put(S1, submap);
            return map.get(S1).get(S2);
        }

        static boolean isAnagram(String S1, String S2) {
            char[] tempArray1 = S1.toCharArray();
            char[] tempArray2 = S2.toCharArray();

            Arrays.sort(tempArray1);
            Arrays.sort(tempArray2);

            String copy_S1 = new String(tempArray1);
            String copy_S2 = new String(tempArray2);

            return copy_S1.equals(copy_S2);
        }
    }
}
