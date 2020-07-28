package com.markby.offer.Balance_of_time_efficiency_and_space_efficiency;

// 面试题50（二）：字符流中第一个只出现一次的字符
// 题目：请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从
// 字符流中只读出前两个字符"go"时，第一个只出现一次的字符是'g'。当从该字
// 符流中读出前六个字符"google"时，第一个只出现一次的字符是'l'。
public class FirstCharacterInStream {

    CharStatistics charStatistics = new CharStatistics();

    public class CharStatistics {

        public CharStatistics() {
            for (int i = 0; i < 256; ++i)
                occurrence[i] = -1;
        }

        void insert(char ch) {
            if (occurrence[ch] == -1)
                occurrence[ch] = index;
            else if (occurrence[ch] >= 0)
                occurrence[ch] = -2;

            index++;
        }

        char firstAppearingOnce() {
            char ch = '\0';
            int minIndex = Integer.MAX_VALUE;
            for (int i = 0; i < 256; ++i) {
                if (occurrence[i] >= 0 && occurrence[i] < minIndex) {
                    ch = (char) i;
                    minIndex = occurrence[i];
                }
            }

            return ch;
        }

        // occurrence[i]: A character with ASCII value i;
        // occurrence[i] = -1: The character has not found;
        // occurrence[i] = -2: The character has been found for mutlple times
        // occurrence[i] >= 0: The character has been found only once
        int[] occurrence = new int[256];
        int index;
    }

    // ====================测试代码====================
    void test(String testName, CharStatistics chars, char expected) {
        if (testName != null)
            System.out.println(testName + " begins: ");

        if (chars.firstAppearingOnce() == expected)
            System.out.println("Passed.");
        else
            System.out.println("FAILED.");
    }

    public static void main(String[] args) {
        FirstCharacterInStream characterInStream = new FirstCharacterInStream();
        CharStatistics chars = characterInStream.charStatistics;

        characterInStream.test("Test1", chars, '\0');

        chars.insert('g');
        characterInStream.test("Test2", chars, 'g');

        chars.insert('o');
        characterInStream.test("Test3", chars, 'g');

        chars.insert('o');
        characterInStream.test("Test4", chars, 'g');

        chars.insert('g');
        characterInStream.test("Test5", chars, '\0');

        chars.insert('l');
        characterInStream.test("Test6", chars, 'l');

        chars.insert('e');
        characterInStream.test("Test7", chars, 'l');
    }


}
