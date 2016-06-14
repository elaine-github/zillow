package com.zillow;
public class Solution {
    public long stringToLong(String s) {
        if (s == null) throw new NumberFormatException("null");
        if ("".equals(s)) throw new NumberFormatException("empty string");

        int sign = 1;
        long val = 0;
        char[] chars = s.toCharArray();
        for (int i=0; i<chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                long newVal = 10 * val + sign * Character.digit(chars[i], 10);
                if ((sign == 1 && newVal < val) || (sign == -1 && newVal > val))
                    throw new NumberFormatException("For input string: " + s);
                val = newVal;
            } else {
                if (i != 0 || (chars[i] != '-' && chars[i] != '+'))
                    throw new NumberFormatException("For input string: " + s);
                if (chars[i] == '-') sign = -1;
            }
        }

        return val;
    }
    public static void  main(String[] args){

    }
}