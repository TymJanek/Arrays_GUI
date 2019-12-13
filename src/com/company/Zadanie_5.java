package com.company;

import java.util.Random;
import java.util.Scanner;

public class Zadanie_5 {

    public static void main(String[] args){
        // Create 10x10 multiplication table

        //multiplicationTable();      //Exercise 1 - multiplication table

        multidimensionalArray();    //Exercise 2 - multidimensional array filled with random integer values between 0 and 20

        //randomArrayMethod();        //Exercise 3 - multidimensional array filled with random double values between -0.5 and 0.5
                                      //with user choice whether to change positive or negative values to 0

        //avgAndSum();                //Exercise 4 - calculate average of all elements in the array
                                      //calculate sum on the diagonal of the array


    }

    public static void multiplicationTable() {
        int[][] arrayMultiply = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                arrayMultiply[i][j] = (i + 1) * (j + 1);
            }
        }

        //display multiplication table
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(arrayMultiply[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public static void multidimensionalArray(){
        int[][] multiArray = new int[10][5];
        Random generator = new Random();
        for(int i=0;i<10;i++){
            for(int j=0;j<5;j++){
                multiArray[i][j] = generator.nextInt(20);
            }
        }
        int sum=0;
        int max=multiArray[0][0]+multiArray[0][1]+multiArray[0][2]+multiArray[0][3]+multiArray[0][4];
        for(int i=0;i<10;i++){
            for(int j=0;j<5;j++){
                System.out.print(multiArray[i][j] + " ");
                sum += multiArray[i][j];
            }

            if(max<sum){
                max = sum;
            }

            System.out.print("   " + sum);
            System.out.print("\n");
            sum=0;
        }
        System.out.print("\nMax sum is " + max);
    }

    public static void randomArrayMethod(){
        Random generator = new Random();
        double[][] randomArray = new double[10][10];
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                randomArray[i][j] = ((generator.nextDouble()*10)-5);
            }
        }

        //rounding to 2 after decimal places
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                randomArray[i][j] *= 100;
                randomArray[i][j] = Math.round(randomArray[i][j]);
                randomArray[i][j] /= 100;
            }
        }

        //display array
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                System.out.print(randomArray[i][j] + " ");
            }
            System.out.print("\n");
        }

        //let user to choose whether he/she wants to change all positive/negative values to 0
        Scanner scan1 = new Scanner(System.in);
        System.out.print("This method changes all positive or negative values in the array to 0. Please type '1' to change positive or '2' to change negative.");
        int choice = scan1.nextInt();
        if(choice == 1){
            for(int i=0;i<10;i++){
                for(int j=0;j<10;j++){
                    if(randomArray[i][j] > 0){
                        randomArray[i][j] = 0;
                    }
                }
            }
        }
        else if(choice == 2){
            for(int i=0;i<10;i++){
                for(int j=0;j<10;j++){
                    if(randomArray[i][j] < 0){
                        randomArray[i][j] = 0;
                    }
                }
            }
        }
        else{
            System.out.print("You've typed wrong letter. Please re-open the program and try again.");
        }

        if(choice == 1 || choice == 2){
            for(int i=0;i<10;i++){
                for(int j=0;j<10;j++){
                    System.out.print(randomArray[i][j] + " ");
                }
                System.out.print("\n");
            }
        }

    }

    public static void avgAndSum(){
        Random generator = new Random();
        int n = 4;
        int[][] Array = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                Array[i][j] = (generator.nextInt(9)+1);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(Array[i][j] + " ");
            }
            System.out.print("\n");
        }

        //calculating average value of all elements in the array
        int temp = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                temp += Array[i][j];
            }
        }
        double avg = ((double)temp/(n*n));
        System.out.print("Average value of all elements of this array is " + avg);

        //calculating sum of elements on diagonal of the array
        int diagonalSum = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                diagonalSum += Array[i][j];
                i++;
            }
            i--;
        }
        System.out.print("\nDiagonal sum in this array is " + diagonalSum);
    }

}
