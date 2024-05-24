package isp.lab2.Exercise4StringSearch;

import java.util.Scanner;

public class Exercise4StringSearch {
    /**
     * This method should return an array of strings that contain the substring.
     * @param input
     * @param substring what to search for
     * @return
     */
    public static String[] searchSubstrings(String input, String substring) {
        String[] splitInput = input.split(",");
        int count = 0;

        for (String str : splitInput) {
            if (str.contains(substring)) {
                count++;
            }
        }



        String[] result = new String[count];
        int index = 0;
        for (String str : splitInput) {
            if (str.contains(substring)) {
                result[index] = str;
                index++;
            }
        }

        return result;
    }



    public static String readFromConsole(String suffix) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter " + suffix);
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        String input  = readFromConsole("words");
        String substring  = readFromConsole("substring");
        String[] result = searchSubstrings(input, substring);
        for (String string : result) {
            System.out.println(string);
        }
    }
}
