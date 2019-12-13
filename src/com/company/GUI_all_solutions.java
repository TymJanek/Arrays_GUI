//SIMPLE GUI INTERFACE TO SELECT GIVEN EXERCISE AND DISPLAY RESULT
//SOLUTIONS SLIGHTLY CHANGED TO WORK IN SWING AND AWT


package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class GUI_all_solutions {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Exercises: Java Arrays");

        JButton button1 = new JButton("Exercise 1");
        button1.setBounds(50,30,200,40);
        frame.add(button1);

        JButton button2 = new JButton("Exercise 2");
        button2.setBounds(250,30,200,40);
        frame.add(button2);

        JButton button3 = new JButton("Exercise 3");
        button3.setBounds(450,30,200,40);
        frame.add(button3);

        JButton button4 = new JButton("Exercise 4");
        button4.setBounds(650,30,200,40);
        frame.add(button4);

        JButton button5 = new JButton("Exercise 5");
        button5.setBounds(850,30,200,40);
        frame.add(button5);

        JButton button6 = new JButton("Exercise 6");
        button6.setBounds(1050,30,200,40);
        frame.add(button6);

        JButton button7 = new JButton("Exercise 7");
        button7.setBounds(1250,30,200,40);
        frame.add(button7);

        JButton button8 = new JButton("Exercise 8");
        button8.setBounds(1450,30,200,40);
        frame.add(button8);

        JButton buttonColor = new JButton("Recolor");
        buttonColor.setBounds(100,800,150,50);
        frame.add(buttonColor);

        JLabel labelResult = new JLabel("Results will be shown here", SwingConstants.CENTER);
        labelResult.setBounds(100, 100, 1500, 700);
        labelResult.setFont(new Font("Arial", Font.PLAIN, 18));
        Border borderResult = BorderFactory.createLineBorder(Color.BLACK, 2, false);
        labelResult.setBorder(borderResult);
        frame.add(labelResult);

        JButton reset = new JButton("Remove unnecessary buttons");
        reset.setBounds(1350, 800, 250, 50);
        frame.add(reset);

        frame.setSize(1700,900);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonColor.addActionListener(e -> {
            Random generator = new Random();
            int color1 = generator.nextInt(255);
            int color2 = generator.nextInt(255);
            int color3 = generator.nextInt(255);
            Color color = new Color(color1,color2,color3);
            frame.getContentPane().setBackground(color);
        });

        reset.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.getContentPane().validate();
            frame.getContentPane().repaint();
            frame.add(labelResult);
            frame.add(button1);
            frame.add(button2);
            frame.add(button3);
            frame.add(button4);
            frame.add(button5);
            frame.add(button6);
            frame.add(button7);
            frame.add(reset);
        });

        button1.addActionListener(e -> {
            labelResult.setText(exercise_1());
        });

        button2.addActionListener(e -> {
            labelResult.setText(exercise_2());
        });

        button3.addActionListener(e -> {
            labelResult.setText(exercise_3());
        });

        final int[] count = {0};
        button4.addActionListener(e -> {
            count[0]++;
            JTextField textField = new JTextField();
            textField.setBounds(1325,750,120,30);
            frame.add(textField);
            labelResult.setText(exercise_4());
            textField.setText("Simple counter: " + String.valueOf(count[0]));  //to count how many times there is no mode in array
            //least amount of repetitions needed to generate mode was 23, most 536
            //avg amount of repetitions is 222 until mode shows

        });

        //button 5
        final JToolBar toolBar = new JToolBar();
        final JPopupMenu popup = new JPopupMenu();

        popup.add(new JMenuItem(new AbstractAction("Variant 1") {
            public void actionPerformed(ActionEvent e) {
                labelResult.setText(multiplicationTable());
            }
        }));

        popup.add(new JMenuItem(new AbstractAction("Variant 2") {
            public void actionPerformed(ActionEvent e) {
                labelResult.setText(multidimensionalArray());
            }
        }));

        popup.add(new JMenuItem(new AbstractAction("Variant 3") {
            public void actionPerformed(ActionEvent e) {
                labelResult.setText(randomArrayMethod(toReturnArray()));

                JButton calc1 = new JButton("Reset +");
                calc1.setBounds(600, 700, 150, 60);
                frame.add(calc1);

                JButton calc2 = new JButton("Reset -");
                calc2.setBounds(850, 700, 150, 60);
                frame.add(calc2);

                calc1.addActionListener(f -> {
                    labelResult.setText(resetPositives(toReturnArray()));
                });

                calc2.addActionListener(f -> {
                    labelResult.setText(resetNegatives(toReturnArray()));
                });
            }
        }));

        popup.add(new JMenuItem(new AbstractAction("Variant 4") {
            public void actionPerformed(ActionEvent e) {
                labelResult.setText(result(array1(), 4));
            }
        }));

        button5.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                popup.show(e.getComponent(), e.getX(), e.getY());
            }
        });

        //button 6
        button6.addActionListener(e -> {
            labelResult.setText(exercise_6());
        });

        //button 7
        final JToolBar toolBar2 = new JToolBar();
        final JPopupMenu popup2 = new JPopupMenu();

        popup2.add(new JMenuItem(new AbstractAction("Variant 1") {
            public void actionPerformed(ActionEvent e) {
                labelResult.setText(exercise_7_1(1,9,1,9));
            }
        }));

        popup2.add(new JMenuItem(new AbstractAction("Variant 2") {
            public void actionPerformed(ActionEvent e) {
                labelResult.setText(exercise_7_2(4));
            }
        }));

        popup2.add(new JMenuItem(new AbstractAction("Variant 3") {
            public void actionPerformed(ActionEvent e) {
                labelResult.setText(exercise_7_3("Exercise_7_testing", 3));
            }
        }));

        popup2.add(new JMenuItem(new AbstractAction("Variant 4") {
            public void actionPerformed(ActionEvent e) {
                labelResult.setText(exercise_7_4());
            }
        }));


        button7.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                popup2.show(e.getComponent(), e.getX(), e.getY());
            }
        });

        button8.addActionListener(e -> {
            labelResult.setText(exercise_8());
        });

    }

    //method for exercise 1
    public static String exercise_1(){
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
        return str;
    }

    //method for exercise 2
    public static String exercise_2(){
        //fill array with some kind of pattern, ex. i=2*i

        int[] arrayOfPattern = new int[10];
        for(int i=0;i<arrayOfPattern.length;i++){
            arrayOfPattern[i] = (i*2)+1;
        }

        return Arrays.toString(arrayOfPattern);
    }

    //method for exercise 3
    public static String exercise_3(){
        //create array of 100 elements and fill it with Fibonacci's sequence numbers
        int[] arrayFibonacci = new int[100];
        arrayFibonacci[0] = 1;
        arrayFibonacci[1] = 1;

        for(int i=2;i<arrayFibonacci.length;i++){
            arrayFibonacci[i] = arrayFibonacci[i-1]+arrayFibonacci[i-2];
        }

        return Arrays.toString(arrayFibonacci);
    }

    //method for exercise 4
    public static String exercise_4(){
        int n = 10;
        double[] arrayOfMath = new double[n];
        Random generator = new Random();

        for (int i = 0; i < n; i++) {
            arrayOfMath[i] = ((generator.nextDouble() * 10) - 5);
        }

        //rounding to 2 decimal places
        for (int i = 0; i < n; i++) {
            arrayOfMath[i] = arrayOfMath[i] * 100;
            arrayOfMath[i] = Math.round(arrayOfMath[i]);
            arrayOfMath[i] = arrayOfMath[i] / 100;
        }

        //sort array
        Arrays.sort(arrayOfMath);

        //avg
        double avg = 0;
        for (int i = 0; i < n; i++) {
            avg += arrayOfMath[i];
        }
        avg = avg / n;

        avg *= 100;
        avg = Math.round(avg);
        avg /= 100;

        //median
        double median = 0;
        if (n % 2 == 0) {
            median = (arrayOfMath[(n / 2) - 1] + arrayOfMath[(n / 2)]) / 2;
        } else {
            median = arrayOfMath[(n / 2)];
        }

        median *= 100;
        median = Math.round(median);
        median /= 100;

        double mode = 0;
        int temp = 0;
        while(temp<n){
            if(arrayOfMath[temp] == arrayOfMath[temp+1]){
                mode = arrayOfMath[temp];
                temp++;
            }
            break;
        }

        //min and max, array is already sorted so min is first value in array and max is the last
        double min=0, max=0;
        min = arrayOfMath[0];
        max = arrayOfMath[n-1];

        int count=0;
        double avgEven = 0;
        for(int i=2;i<n;i=i+2){
            count++;
            avgEven += arrayOfMath[i];
        }

        double result = avgEven/count;
        result *= 100;
        result = Math.round(result);
        result /= 100;


        if(mode==0.0){
            return "<html>" + Arrays.toString(arrayOfMath) +
                    "<br />Avg value is: " + Double.toString(avg) +
                    "<br />Median value is: " + Double.toString(median) +
                    "<br />There is no mode in this array." +
                    "<br />Min value is: " + Double.toString(min) + ", max value is: " + Double.toString(max) +
                    "<br />Avg of all even elements is: " + Double.toString(result) +
                    "</html>";
        }
        else{
            return "<html>" + Arrays.toString(arrayOfMath) +
                    "<br />Avg value is: " + Double.toString(avg) +
                    "<br />Median value is: " + Double.toString(median) + "" +
                    "<br />Mode value is " + mode +
                    "<br />Min value is: " + Double.toString(min) + ", max value is: " + Double.toString(max) +
                    "<br />Avg of all even elements is: " + Double.toString(result) +
                    "</html>";
        }

    }

    //methods for exercise 5
    public static String multiplicationTable() {
        int[][] arrayMultiply = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                arrayMultiply[i][j] = (i + 1) * (j + 1);
            }
        }
        return "<html><table>" + Arrays.deepToString(arrayMultiply).replace("[", "<tr>").replace("]", "</tr>").replace(",", "<td>") + "</table></html>";
    }

    public static String multidimensionalArray(){
        int[][] multiArray = new int[10][6];
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
                sum += multiArray[i][j];
                multiArray[i][5] = sum;
            }

            if(max<sum){
                max = sum;
            }

            sum=0;

        }
        return "<html><table>" + Arrays.deepToString(multiArray).replace("[", "<tr>").replace("]", "</tr>").replace(",", "<td>") + "</table><br />" + String.valueOf(max) + "</html>";
    }

    public static double[][] toReturnArray(){
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
        return randomArray;
    }

    public static String randomArrayMethod(double[][] randomArray){
        //display array
        return "<html><table>" + Arrays.deepToString(randomArray).replace("[", "<tr>").replace("]", "</tr>").replace(",", "<td>") + "</table></html>";
    }

    public static String resetPositives(double[][] array){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(array[i][j] > 0){
                    array[i][j] = 0;
                }
            }
        }
        return "<html><table>" + Arrays.deepToString(array).replace("[", "<tr>").replace("]", "</tr>").replace(",", "<td>") + "</table></html>";
    }

    public static String resetNegatives(double[][] array){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(array[i][j] < 0){
                    array[i][j] = 0;
                }
            }
        }
        return "<html><table>" + Arrays.deepToString(array).replace("[", "<tr>").replace("]", "</tr>").replace(",", "<td>") + "</table></html>";
    }

    public static int[][] array1() {
        Random generator = new Random();
        int n = 4;
        int[][] Array = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Array[i][j] = (generator.nextInt(9) + 1);
            }
        }
        return Array;
    }

    public static String result(int[][] Array, int n){
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp += Array[i][j];
            }
        }
        double avg = ((double) temp / (n * n));


        //calculating sum of elements on diagonal of the array
        int diagonalSum = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                diagonalSum += Array[i][j];
                i++;
            }
            i--;
        }
        return "<html><table>" + Arrays.deepToString(Array).replace("[", "<tr>").replace("]", "</tr>").replace(",", "<td>") + "</table>" +
                "Avg of all elements is: " + String.valueOf(avg) + " " +
                "<br />Sum on diagonal is: " + String.valueOf(diagonalSum) + "</html>";
    }

    //method for exercise 6
    public static String exercise_6(){
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

        int[] tabMax = new int[irregularArray.length];
        int[] tabMin = new int[irregularArray.length];

        //displaying all Maxes
        for(int k=0;k<maxList.size();k++){
            tabMax[k] = maxList.get(k);
        }

        //displaying all Mins
        for(int k=0;k<minList.size();k++){
            tabMin[k] = minList.get(k);
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
        return "<html><table>" + Arrays.deepToString(irregularArray).replace("[", "<tr>").replace("]", "</tr>").replace(",", "<td>") + "</table>"
                + "<br />Maximums: " + Arrays.toString(tabMax)
                + "<br />Minimums:  " + Arrays.toString(tabMin)
                + "<br /> Result:   " + Arrays.toString(lastArray) + "</html>";
    }

    //methods for exercise 7
    public static String exercise_7_1(int r1, int r2, int r3, int r4){
        int[][] array1 = new int[4][4];
        int[][] array2 = new int[4][4];
        Random generator = new Random();

        for(int i = 0;i<4;i++){
            for(int j=0;j<4;j++){
                array1[i][j] = generator.nextInt(r2)+r1;
                array2[i][j] = generator.nextInt(r4)+r3;
            }
        }

        int[][] array3 = new int[4][4];
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                array3[i][j] = array1[i][j] + array2[i][j];
            }
        }

        return "<html><table>" +    Arrays.deepToString(array1).replace("[", "<tr>").replace("]", "</tr>").replace(",", "<td>") + "</table>"
                +"<table>" +        Arrays.deepToString(array1).replace("[", "<tr>").replace("]", "</tr>").replace(",", "<td>") + "</table>"
                +"<table>" +        Arrays.deepToString(array1).replace("[", "<tr>").replace("]", "</tr>").replace(",", "<td>") + "</table>";
    }

    public static String exercise_7_2(int n){
        Random generator = new Random();
        int[][] randomArray = new int[n][n];
        char[][] charArray = new char[n][n];

        //fill array with random Integers in range 61-122
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                //range from 97 to 122
                randomArray[i][j] = generator.nextInt(25)+97;
                charArray[i][j] = (char)randomArray[i][j];
            }
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

        return "<html><table>" +  String.valueOf(Arrays.deepToString(charArray)).replace("[", "<tr>").replace("]", "</tr>").replace(",", "<td>") + "</table>"
                + "<br />Vowels: " + vowel
                + "<br />Consonants: " + consonant;
    }

    public static String exercise_7_3(String str, int n){
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
        return "<html><table>" + Arrays.deepToString(array).replace("[", "<tr>").replace("]", "</tr>").replace(",", "<td>") + "</table></html>";
    }

    public static String exercise_7_4(){
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

        return "<html><table>" +    Arrays.deepToString(array1).replace("[", "<tr>").replace("]", "</tr>").replace(",", "<td>") + "</table>"
                + "<br /><table>" + Arrays.deepToString(array2).replace("[", "<tr>").replace("]", "</tr>").replace(",", "<td>") + "</table>"
                + "<br /><table>" + Arrays.deepToString(array3).replace("[", "<tr>").replace("]", "</tr>").replace(",", "<td>") + "</table></html>";
    }

    public static String exercise_8(){
        int rows = 5;
        int columns = 5;
        double[][] array = new double[rows][columns];
        Random generator = new Random();

        array[0][0] = 123456.78;
        array[0][1] = 654321.87;
        array[0][2] = 123654.87;
        array[0][3] = 654132.78;
        array[0][4] = 642531.87;

        array[1][0] = 987654.32;
        array[2][0] = 456789.23;
        array[3][0] = 987456.32;
        array[4][0] = 789654.23;

        for(int i=1;i<rows-2;i++){
            for(int j=1;j<columns;j++){
                array[i][j] = generator.nextDouble();
                array[i][j] *= 100;
                array[i][j] = Math.round(array[i][j]);
                array[i][j] /= 100;
            }
        }

        for(int j=1;j<columns;j++){
            array[3][j] = generator.nextDouble()*10+40;
            array[3][j] *= 100;
            array[3][j] = Math.round(array[3][j]);
            array[3][j] /= 100;
        }

        for(int j=1;j<columns;j++){
            array[4][j] = generator.nextDouble()*10+60;
            array[4][j] *= 100;
            array[4][j] = Math.round(array[4][j]);
            array[4][j] /= 100;
        }


        return "<html><table border=0>" + Arrays.deepToString(array).replace("[", "<tr>").replace("]", "</tr>").replace(",", "<td>").
                replace("123456.78", "<center>Name</center>").replace("654321.87", "<center>T1</center>").replace("123654.87", "<center>T2</center>").replace("654132.78","<center>T3</center>").
                replace("642531.87","<center>T4</center>").replace("987654.32","<center>Oen</center>").replace("456789.23","<center>Close</center>").replace("987456.32","<center>Minimum</center>").
                replace("789654.23","<center>Maximum</center>")
                + "</table></html>";
    }
}

