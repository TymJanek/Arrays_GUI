package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Zadanie_6 {

    public static void main(String[] args) {
        //create irregular multidimensional array
        irregularMultiArray();

    }

    public static void irregularMultiArray() {
        int[][] irregularArray = new int[4][];
        irregularArray[0] = new int[5];
        irregularArray[1] = new int[3];
        irregularArray[2] = new int[6];
        irregularArray[3] = new int[2];

        Random generator = new Random();
        int count = 0;
        for(int i =0;i<irregularArray.length;i++){
            for(int j=0;j<irregularArray[i].length;j++){
                irregularArray[i][j] = generator.nextInt(9)+1;
            }
            count++;
        }

        //display array
        for(int i =0;i<irregularArray.length;i++){
            for(int j=0;j<irregularArray[i].length;j++){
                System.out.print(irregularArray[i][j] + " ");
            }
            System.out.print("\n");
        }

        int max = 0;
        int min=10;
        int i=0;
        int j=0;
        ArrayList<Integer> minList = new ArrayList<Integer>();   //list for Min elements
        ArrayList<Integer> maxList = new ArrayList<Integer>();   //list for Max elements

        //calculating Maxes using List
        while(i < count){
            for(int loopCountMax=0;loopCountMax<irregularArray[i].length;loopCountMax++){
                if(irregularArray[i][loopCountMax] > max){
                    max = irregularArray[i][loopCountMax];
                }
            }
            maxList.add(max);
            max = 0;
            i++;
        }

        //calculating Mins using List
        while(j<count){
            for(int loopCountMin=0;loopCountMin<irregularArray[j].length;loopCountMin++){
                if(irregularArray[j][loopCountMin] < min){
                    min = irregularArray[j][loopCountMin];
                }
            }
            minList.add(min);
            min=10;
            j++;
        }

        //displaying all Maxes
        System.out.print("Max: ");
        for(int k=0;k<maxList.size();k++){
            System.out.print(maxList.get(k) + " ");
        }

        //displaying all Mins
        System.out.print("\nMin: ");
        for(int l=0;l<minList.size();l++){
            System.out.print(minList.get(l) + " ");
        }

        //creating and filling array with Maxes and Mins
        int[] lastArray = new int[count];
        for(int loop=0;loop<lastArray.length;loop++){
            if(loop%2==0){
                lastArray[loop] = maxList.get(loop);
            }
            else{
                lastArray[loop] = minList.get(loop);
            }
        }

        //display array with results: Maxes on even elements and Mins on odd elements
        System.out.print("\n");
        for(int loop=0;loop<lastArray.length;loop++){
            System.out.print(lastArray[loop] + " ");
        }

    }
}


