package com.company;

public class Number_Tile extends Generic_Tile
{
    public Number_Tile(int rows, int columns, int bombs, char[][] matrix, char[][] bomb_matrix, boolean bomb_clicked, int coord_x,int coord_y)
    {
        super(rows,columns,bombs,matrix,bomb_matrix,bomb_clicked,coord_x,coord_y);
    }

    protected void Click(int coord_x,int coord_y)
    {
        SetNumUnopenedCells();

        int counter=0;
        for(int i=coord_x-1;i<=coord_x+1;i++)
            for(int j=coord_y-1;j<=coord_y+1;j++)
            {
                if(bomb_matrix[i][j]=='*') counter++;

            }

        matrix[coord_x][coord_y]=(char)(counter + '0');
        GetMatrix();

    }
}
