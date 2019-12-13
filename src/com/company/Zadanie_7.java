package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Zadanie_7 {

    public static void main(String[] args){
        //Exercise7_1(1,9,1,9);
        //Exercise7_2(4);
        //Exercise7_3("Testing array in exercise 7", 3);
        //Exercise7_4();
    }

    public static int Exercise7_1(int r1, int r2, int r3, int r4){
        int[][] array1 = new int[4][4];
        int[][] array2 = new int[4][4];
        Random generator = new Random();

        for(int i = 0;i<4;i++){
            for(int j=0;j<4;j++){
                array1[i][j] = generator.nextInt(r2)+r1;
                array2[i][j] = generator.nextInt(r4)+r3;
            }
        }

        //display array Nr 1
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print(array1[i][j] + " ");
            }
            System.out.print("\n");
        }

        System.out.print("\n");
        //display array Nr 2
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print(array2[i][j] + " ");
            }
            System.out.print("\n");
        }

        //array3
        int[][] array3 = new int[4][4];
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                array3[i][j] = array1[i][j] + array2[i][j];
            }
        }

        System.out.print("\n");
        //display array3
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print(array3[i][j] + " ");
            }
            System.out.print("\n");
        }

        return 0;
    }

    public static int Exercise7_2(int n){
        Random generator = new Random();
        int[][] randomArray = new int[n][n];

        //fill array with random Integers in range 61-122
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                //range from 97 to 122
                randomArray[i][j] = generator.nextInt(25)+97;
            }
        }

        char temp;
        String s1 = "";
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                temp = (char)randomArray[i][j];
                s1 = String.valueOf(temp);
                System.out.print(s1 + " ");
            }
            System.out.print("\n");
        }

        String vowel = "";          //vowel - a,e,i,o,u,y
        String consonant = "";      //consonant - b,c,d,f,g,h,j,k,l,m,n,p,q,r,s,t,w,x,z
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(randomArray[i][j] == 97 || randomArray[i][j] == 101 || randomArray[i][j] == 105 || randomArray[i][j] == 111 || randomArray[i][j] == 117 || randomArray[i][j] == 121){
                    vowel += String.valueOf((char)randomArray[i][j]);
                }
                else{
                    consonant += String.valueOf((char)randomArray[i][j]);
                }
            }
        }

        System.out.print("Vowels: " + vowel);
        System.out.print("\nConsonants: " + consonant);

        return 0;
    }

    public static void Exercise7_3(String str, int n){
        char[][] array = new char[n][10];
        int temp = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<10;j++){
                if(temp >= str.length()){
                    array[i][j] = '0';
                    temp++;
                }
                else{
                    array[i][j] = str.charAt(temp);
                    temp++;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<10;j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void Exercise7_4(){
        double array1[][] = new double[4][4];
        double array2[][] = new double[4][4];
        Random generator = new Random();

        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                array1[i][j] = ((generator.nextDouble()*10)-5);
                array2[i][j] = ((generator.nextDouble()*10)-5);
            }
        }

        //rounding values
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                array1[i][j] *=100;
                array1[i][j] = Math.round(array1[i][j]);
                array1[i][j] /= 100;
                array2[i][j] *=100;
                array2[i][j] = Math.round(array2[i][j]);
                array2[i][j] /= 100;
            }
        }

        //display array1
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print(array1[i][j] + " ");
            }
            System.out.print("\n");
        }

        System.out.print("\n");
        //display array2
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print(array2[i][j] + " ");
            }
            System.out.print("\n");
        }

        double[][] array3 = new double[4][4];
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(array2[i][j] != 0){
                    array3[i][j] = array1[i][j]/array2[i][j];
                }
                else{
                    array3[i][j] = array1[i][j]/(array2[i][j]+0.01);  //to make sure to not divide by 0
                }
            }
        }

        //rounding values
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                array3[i][j] *= 100;
                array3[i][j] = Math.round(array3[i][j]);
                array3[i][j] /= 100;
            }
        }

        System.out.print("\n");
        //display array3
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print(array3[i][j] + " ");
            }
            System.out.print("\n");
        }


    }
}
