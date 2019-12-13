package com.company;

public class Zadanie_2 {

    public static void main(String[] args){
        //fill array with some kind of pattern, ex. i=2*i

        int[] arrayOfPattern = new int[10];
        for(int i=0;i<arrayOfPattern.length;i++){
            arrayOfPattern[i] = (i*2)+1;
        }

        for(int i=0;i<arrayOfPattern.length;i++){
            System.out.print(arrayOfPattern[i] + ", ");
        }
    }
}
