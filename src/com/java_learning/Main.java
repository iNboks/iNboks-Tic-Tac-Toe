package com.java_learning;

import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static int SIZE=3;
    public static char EMPTY_FIELD = '*';
    public static char X_FIELD = 'X';
    public static char O_FIELD = 'O';

    public static void InitializationMatrix(char[][] matrix){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                matrix[i][j]=EMPTY_FIELD;
            }
        }
    }

    public static void InputMatrix (char[][] matrix){
        int count = 0;
        int CountOfInput = 0;
        int[] position = new int[2];
        while (CountOfInput!=9){
            if(count%2==0){
                System.out.println("Хід X: ");
                position[0] = scan.nextInt() - 1;
                position[1] = scan.nextInt() - 1;
                if(CheckPosition(matrix,position[0],position[1])){
                    matrix[position[0]][position[1]] = X_FIELD;
                    count++;
                    CountOfInput++;
                    System.out.println(CountOfInput);
                    OutputMatrix(matrix);
                };
                if (WhoWillWin(matrix,X_FIELD)){
                    break;
                }
            }else {
                System.out.println("Хід O: ");
                position[0] = scan.nextInt() - 1;
                position[1] = scan.nextInt() - 1;
                if(CheckPosition(matrix,position[0],position[1])){
                    matrix[position[0]][position[1]] = O_FIELD;
                    count++;
                    CountOfInput++;
                    System.out.println(CountOfInput);
                    OutputMatrix(matrix);
                };
                if (WhoWillWin(matrix,O_FIELD)){
                    break;
                }
            };
        }
        if (CountOfInput==9){
            System.out.println("Нічія");
        };
    }

    public static boolean CheckPosition(char[][] matrix,int a, int b){
        boolean IsEmpty = true;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++){
                if(matrix[a][b]!=EMPTY_FIELD){
                    if (matrix[a][b]==X_FIELD || matrix[a][b]==O_FIELD){
                        IsEmpty = false;
                    }
                }
            }
        }
        if(IsEmpty == false){
            System.out.println("Ячейка занята");
        }
        return IsEmpty;
    }

    public static boolean WhoWillWin(char[][] matrix, char InputChar) {
        boolean Winner = false;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (matrix[0][0] == InputChar && matrix[0][1] == InputChar && matrix[0][2] == InputChar || matrix[1][0] == InputChar && matrix[1][1] == InputChar && matrix[1][2] == InputChar || matrix[2][0] == InputChar && matrix[2][1] == InputChar && matrix[2][2] == InputChar || matrix[0][0] == InputChar && matrix[1][0] == InputChar && matrix[2][0] == InputChar || matrix[0][1] == InputChar && matrix[1][1] == InputChar && matrix[2][1] == InputChar || matrix[0][2] == InputChar && matrix[1][2] == InputChar && matrix[2][2] == InputChar || matrix[0][0] == InputChar && matrix[1][1] == InputChar && matrix[2][2] == InputChar || matrix[0][2] == InputChar && matrix[1][1] == InputChar && matrix[2][0] == InputChar ) {
                    Winner = true;
                }
            }
        }
        if (Winner) {
            System.out.println("Переміг: " + InputChar);
        }
        return Winner;
    }

    public static void OutputMatrix(char[][] matrix){
        System.out.println("Матрица: ");
        for (int i=0;i<=SIZE;i++){
            System.out.print(i+" ");
        }
        System.out.println();
        for (int i=0;i< SIZE;i++){
            System.out.print((i+1)+" ");
            for (int j = 0; j <SIZE; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char [][] GameField = new char[SIZE][SIZE];
        InitializationMatrix(GameField);
        OutputMatrix(GameField);
        InputMatrix(GameField);
    }

}
