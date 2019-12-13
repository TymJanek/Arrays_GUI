package com.company;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

public class Zadanie_4 {

    public static void main(String[] args){

        // create array of doubles, fill with random numbers in range(-5;5), calculate average value, median, mode, min, max
        // and avg of all even elements except element 0

        int n = 10;
        double[] arrayOfMath = new double[n];
        Random generator = new Random();

        for(int i=0;i<n;i++){
            arrayOfMath[i] = ((generator.nextDouble()*10)-5);
        }

        //rounding to 2 decimal places
        for(int i=0;i<n;i++){
            arrayOfMath[i] = arrayOfMath[i]*100;
            arrayOfMath[i] = Math.round(arrayOfMath[i]);
            arrayOfMath[i] = arrayOfMath[i]/100;
        }

        //sort array
        Arrays.sort(arrayOfMath);

        for(int i=0;i<n;i++){
            System.out.print(arrayOfMath[i] + " , ");
        }

        //calculating avg value
        double avg = 0;
        for(int i=0;i<n;i++){
            avg += arrayOfMath[i];
        }
        avg = avg/n;
        System.out.print("\nAverage value is " + (new DecimalFormat("##.##").format(avg)));

        //calculating median
        double median=0;
        if(n%2==0){
            median = (arrayOfMath[(n/2)-1] + arrayOfMath[(n/2)])/2;
        }
        else{
            median = arrayOfMath[(n/2)];
        }
        System.out.print("\nMedian value is " + (new DecimalFormat("##.##").format(median)));

        //calculating mode
        double mode = 0;
        int temp = 0;
        while(temp<n){
            if(arrayOfMath[temp] == arrayOfMath[temp+1]){
                mode = arrayOfMath[temp];
                temp++;
            }
            break;
        }
        if(mode==0.0){
            System.out.print("\nThere is no mode in this array.");
        }
        else{
            System.out.print("\nMode value is " + mode);
        }

        //min and max, array is already sorted so min is first value in array and max is the last
        double min=0, max=0;
        min = arrayOfMath[0];
        max = arrayOfMath[n-1];
        System.out.print("\nMin value is " + min + "\nMax value is " + max);

        int count=0;
        double avgEven = 0;
        for(int i=2;i<n;i=i+2){
                count++;
                avgEven += arrayOfMath[i];
        }

        double result = avgEven/count;
        System.out.print("\nAverage value of all even elements in the array is " + (new DecimalFormat("##.##").format(result)));

    }
}
