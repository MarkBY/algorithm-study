package com.markby.offer.string;

public class ReplaceSpace {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("We Are Happy.");
        //String resultStr = str.toString().replace(" ","%20");

        String resultStr = replaceSpace(str);

        System.out.println(resultStr);
    }

    /**
     * 用str本身
     * <p>
     * 运行时间：15ms
     * 占用内存：9524k
     *
     * @param str
     * @return
     */
    public static String replaceSpace(StringBuilder str) {
        if (str == null)
            return null;

        int spaceNum = 0;
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) == ' ')
                spaceNum++;
        int oldLength = str.length();
        int newLength = oldLength + spaceNum * 2;
        str.setLength(newLength);

        while (newLength > 0 && oldLength > 0) {
            oldLength--;
            if (str.charAt(oldLength) == ' ') {
                str.setCharAt(--newLength, '0');
                str.setCharAt(--newLength, '2');
                str.setCharAt(--newLength, '%');
            } else {
                str.setCharAt(--newLength, str.charAt(oldLength));
            }
        }
        return str.toString();
    }

    /**
     * 用char数组
     * <p>
     * 运行时间：16ms
     * 占用内存：9400k
     *
     * @param str
     * @return
     */
    public static String replaceSpace1(StringBuilder str) {
        if (str == null)
            return null;
        char[] chars = new char[str.length()];
        str.getChars(0, str.length(), chars, 0);

        int spaceNum = 0;
        int oldLength = 0;
        for (char ch : chars) {
            if (ch == ' ')
                spaceNum++;

            oldLength++;
        }

        int newLength = oldLength + spaceNum * 2;
        chars = new char[newLength];
        str.getChars(0, str.length(), chars, 0);

        while (newLength > 0 && oldLength > 0) {
            oldLength--;
            if (chars[oldLength] == ' ') {
                chars[--newLength] = '0';
                chars[--newLength] = '2';
                chars[--newLength] = '%';
            } else {
                chars[--newLength] = chars[oldLength];
            }
        }
        str = new StringBuilder(String.valueOf(chars));
        return str.toString();
    }

}
