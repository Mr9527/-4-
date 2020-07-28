package Leetcode;

import java.util.*;

public class OpenLock {

    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet();
        Collections.addAll(dead, deadends);

        Queue<String> q1 = new LinkedList();
        q1.offer("0000");
        Queue<String> q2 = new LinkedList<>();
        q2.offer("0000");

        Set<String> seen = new HashSet();
        seen.add(target);

        int step = 0;
        while (!q1.isEmpty()) {
            int sz = q1.size();
            for (int i = 0; i < sz; i++) {
                String cur = q1.poll();
                if (dead.contains(cur)) continue;
                if (cur.equals(target)) return step;

                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!seen.contains(up)) {
                        seen.add(up);
                        q1.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (!seen.contains(down)) {
                        seen.add(down);
                        q1.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private String plusOne(String str, int j) {
        char[] arr = str.toCharArray();
        if (arr[j] == '9') {
            arr[j] = '0';
        } else {
            arr[j] += 1;
        }
        return new String(arr);
    }

    private String minusOne(String str, int j) {
        char[] arr = str.toCharArray();
        if (arr[j] == '0') {
            arr[j] = '9';
        } else {
            arr[j] -= 1;
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        OpenLock openLock = new OpenLock();
        int i = openLock.openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202");
        System.out.println(i);
    }
}
