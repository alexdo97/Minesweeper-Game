package com.company;
import java.util.Scanner;

public class Main {

    static int rows,columns,bombs,numUnopenedCells;
    public static void main(String[] args)
    {
        System.out.println("\n");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("|                                                               |");
        System.out.println("|                       MINESWEEPER GAME                        |");
        System.out.println("|                                                               |");
        System.out.println("|---------------------------------------------------------------|");
        System.out.println("| Press 1 for: Beginner board: 10 mines on an 8-by-8 board      |");
        System.out.println("| Press 2 for: Intermediate board: 40 mines on a 16-by-16 board |");
        System.out.println("| Press 3 for: Expert board: 99 mines on a 16-by-30 board       |");
        System.out.println("-----------------------------------------------------------------\n");
        System.out.print("Insert key: ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        System.out.println();
        char[][] matrix;
        char[][] bomb_matrix;
        switch(number)
        {
            case 1:
            {
                rows=8;
                columns=8;
                bombs=10;
                matrix = new char [rows+2][columns+2];
                bomb_matrix = new char [rows+2][columns+2];
                boolean bomb_clicked = false;
                numUnopenedCells = rows * columns;
                Board_Gen board = new Board_Gen(rows,columns,bombs,matrix,bomb_matrix,bomb_clicked);
                board.MatrixGen();
                board.BombMatrixGen();

                board.GetMatrix();

                board.GetBombMatrix();
                board.Verification();

            }break;
            case 2:
            {
                rows=16;
                columns=16;
                bombs=40;
                matrix = new char [rows+2][columns+2];
                bomb_matrix = new char [rows+2][columns+2];
                boolean bomb_clicked=false;
                Board_Gen board = new Board_Gen(rows,columns,bombs,matrix,bomb_matrix,bomb_clicked);
                board.MatrixGen();
                board.BombMatrixGen();
                board.GetMatrix();
                System.out.println();
                board.GetBombMatrix();
                board.Verification();
            }break;
            case 3:
            {
                rows=16;
                columns=30;
                bombs=99;
                matrix = new char [rows+2][columns+2];
                bomb_matrix = new char [rows+2][columns+2];
                boolean bomb_clicked=false;
                Board_Gen board = new Board_Gen(rows,columns,bombs,matrix,bomb_matrix,bomb_clicked);
                board.MatrixGen();
                board.BombMatrixGen();
                board.GetMatrix();
                System.out.println();
                board.Verification();
            }break;
            default:
            {
                System.out.println("Invalid Choise :(");
            }

        }


    }


}




