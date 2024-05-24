package isp.lab2.Exercise5EvenOddSearch;

public class Exercise5EvenOddSearch {

    public static int[] findEvenOdd(String input) {
        String[] strNumbers = input.split(",");
        int largestEven = Integer.MIN_VALUE;
        int smallestOdd = Integer.MAX_VALUE;
        int evenPosition = -1;
        int oddPosition = -1;

        for (int i = 0; i < strNumbers.length; i++) {
            int num = Integer.parseInt(strNumbers[i]);

            if (num % 2 == 0 && num > largestEven) {
                largestEven = num;
                evenPosition = i;
            } else if (num % 2 != 0 && num < smallestOdd) {
                smallestOdd = num;
                oddPosition = i;
            }
        }

        int[] result = new int[4];

        result[0] = largestEven;
        result[1] = evenPosition;

        result[2] = smallestOdd;
        result[3] = oddPosition;

        return result;
    }


        public static void main(String[] args) {
        String input = "1,2,3,4,5,6,7,8,9,10";
        int[] result = findEvenOdd(input);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
