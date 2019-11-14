package com.company;

public class Bomb_Tile extends Generic_Tile
{
    public Bomb_Tile(int rows, int columns, int bombs, char[][] matrix, char[][] bomb_matrix, boolean bomb_clicked, int coord_x, int coord_y)
    {
        super(rows,columns,bombs,matrix,bomb_matrix,bomb_clicked,coord_x,coord_y);
    }

    protected void Click(int coord_x,int coord_y)
    {
        this.bomb_clicked=true;
        System.out.println("!YOU LOST!");
        for(int i=1;i<=rows;i++)
        {
            for(int j=1;j<=columns;j++)
                if(bomb_matrix[i][j]=='*')
                {
                    matrix[i][j]='*';
                }

        }


        GetMatrix();

    }
}
