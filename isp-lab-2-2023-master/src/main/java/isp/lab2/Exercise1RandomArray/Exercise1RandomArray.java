package isp.lab2.Exercise1RandomArray;

import java.util.Random;

public class Exercise1RandomArray {

    public static int[] getArrayOfRandomNumbers(int n) {
        int[] array = new int[n];
        //TODO: implement the logic to fill the array with random numbers
        for (int i=0; i<n; i++){
            Random random = new Random();
            array[i] = random.nextInt(91) + 10;
        }
        return array;
    }

    public static int[] findMinAndMax(int[] array)
    {
        int arr[] = new int[2]; /// arr[0] is min and arr[1] is max
        int min = array[0];
        int max = array[0];
        for(int i=0; i<array.length; i++){
            if(min > array[i]){
                min = array[i];
            }if(max < array[i]){
                max = array[i];
            }
        }arr[0] = min;
        arr[1] = max;
        return arr;
    }

    public static void main(String[] args) {

        Random random = new Random();
        //genereaza numar random intre 10 si 100
        int size = random.nextInt(91) + 10;
        int[] a = getArrayOfRandomNumbers(size);
        int[] mm = findMinAndMax(a);
        System.out.println("Min is:"+mm[0]+" Max is:"+mm[1] );
    }
}
