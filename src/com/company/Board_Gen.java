package com.company;
import java.util.Random;
import java.util.Scanner;

import static com.company.Main.numUnopenedCells;

public class Board_Gen
{
    protected int rows, columns, bombs;
    protected char[][] matrix;
    protected char[][] bomb_matrix;
    protected static boolean bomb_clicked;

    public Board_Gen(int rows, int columns, int bombs, char[][] matrix, char[][] bomb_matrix, boolean bomb_clicked)
    {
        this.rows = rows;
        this.columns = columns;
        this.bombs = bombs;
        this.matrix = matrix;
        this.bomb_matrix = bomb_matrix;
        this.bomb_clicked = bomb_clicked;

    }

    public void MatrixGen()
    {
        for (int i = 0; i <= columns + 1; i++)
        {
            matrix[0][i] = 'x';
            matrix[rows + 1][i] = 'x';
        }
        for (int i = 0; i <= rows + 1; i++)
        {
            matrix[i][0] = 'x';
            matrix[i][columns + 1] = 'x';
        }
        for (int i = 1; i <= rows; i++)
        {
            for (int j = 1; j <= columns; j++)
                matrix[i][j] = 'D';
        }

    }

    public void GetMatrix()
    {
        System.out.println("Board matrix:");

        for (int i = 1; i <= rows; i++)
        {
            for (int j = 1; j <= columns; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void BombMatrixGen()
    {
        for (int i = 0; i <= columns + 1; i++)
        {
            bomb_matrix[0][i] = 'x';
            bomb_matrix[rows + 1][i] = 'x';
        }
        for (int i = 0; i <= rows + 1; i++)
        {
            bomb_matrix[i][0] = 'x';
            bomb_matrix[i][columns + 1] = 'x';
        }
        for (int i = 1; i <= rows; i++)
        {
            for (int j = 1; j <= columns; j++)
            {
                bomb_matrix[i][j] = 'D';
            }
        }

        Random rand = new Random();
        int bomb=bombs;
        while (bomb != 0)
        {
            int coord_x = rand.nextInt(rows) + 1;
            int coord_y = rand.nextInt(columns) + 1;
            if (bomb_matrix[coord_x][coord_y] != '*')
            {
                bomb_matrix[coord_x][coord_y] = '*';
                bomb--;
            }
        }
    }

    public void GetBombMatrix()
    {
        System.out.println("Bomb matrix:");
        for (int i = 1; i <= rows; i++)
        {
            for (int j = 1; j <= columns; j++)
            {
                System.out.print(bomb_matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    public void Verification()
    {
        Scanner sc1 = new Scanner(System.in);
        while (bomb_clicked == false)
        {
            if(GetNumUnopenedCells() == bombs)
            {
                System.out.println("!YOU WON!");
                GetMatrix();
                break;
            }
            System.out.print("Select coordinate x: ");
            int coord_x = sc1.nextInt();
            System.out.print("Select coordinate y: ");
            int coord_y = sc1.nextInt();
            boolean verif = false;

            for (int i = coord_x - 1; i <= coord_x + 1; i++)
                for (int j = coord_y - 1; j <= coord_y + 1; j++)
                {
                    if (bomb_matrix[i][j] == '*')
                    {
                        verif = true;
                        break;
                    }
                }

            System.out.println();

            if (bomb_matrix[coord_x][coord_y] == '*')
            {
                Generic_Tile Obj1 = new Bomb_Tile(rows, columns, bombs, matrix, bomb_matrix, bomb_clicked, coord_x, coord_y);

                Obj1.Click(coord_x, coord_y);
            }

            else if (bomb_matrix[coord_x][coord_y] != '*' && verif == true)
            {
                Generic_Tile Obj2 = new Number_Tile(rows, columns, bombs, matrix, bomb_matrix, bomb_clicked, coord_x, coord_y);

                            Obj2.Click(coord_x, coord_y);
            }
            else if (bomb_matrix[coord_x][coord_y] != '*' && verif == false)
            {
                Generic_Tile Obj3 = new Empty_Tile(rows, columns, bombs, matrix, bomb_matrix, bomb_clicked, coord_x, coord_y);

                Obj3.Click(coord_x, coord_y);
            }
        }
    }

    public void SetNumUnopenedCells()
    {
        numUnopenedCells--;
    }
    public int GetNumUnopenedCells()
    {
        System.out.println();
        return numUnopenedCells;
    }


}
