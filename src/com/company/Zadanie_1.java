package com.company;
import java.util.Random;

public class Zadanie_1 {

    public static void main(String args[]){

        //generating random string
        char[] arrayOfRand = new char[10];
        Random generator = new Random();

        for(int i=0; i<10; i++) {
            arrayOfRand[i] = (char)(generator.nextInt(93)+33); //fill array with random values of char in range of 33-126
        }
        String str = "";
        for(int i=0;i<10;i++){
            str += arrayOfRand[i];
            }

        System.out.print(str);
    }
}
