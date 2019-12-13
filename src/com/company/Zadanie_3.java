package com.company;

public class Zadanie_3 {

    public static void main(String[] args){

        //create array of 100 elements and fill it with Fibonacci's sequence numbers
        int[] arrayFibonacci = new int[100];
        arrayFibonacci[0] = 1;
        arrayFibonacci[1] = 1;

        for(int i=2;i<arrayFibonacci.length;i++){
            arrayFibonacci[i] = arrayFibonacci[i-1]+arrayFibonacci[i-2];
        }

        for(int i=0;i<arrayFibonacci.length;i++){
            System.out.print(arrayFibonacci[i] + ",");
        }
    }
}
