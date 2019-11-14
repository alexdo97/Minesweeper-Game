package com.company;

public class Empty_Tile extends Generic_Tile
{
    public Empty_Tile(int rows, int columns, int bombs, char[][] matrix, char[][] bomb_matrix, boolean bomb_clicked, int coord_x,int coord_y)
    {
        super(rows,columns,bombs,matrix,bomb_matrix,bomb_clicked,coord_x,coord_y);
    }

    private char[][] visit_matrix =  new char [rows+2][columns+2];

    private void VisitMatrixGen()
    {
        for (int i = 0; i <= columns + 1; i++)
        {
            visit_matrix[0][i] = 'x';
            visit_matrix[rows + 1][i] = 'x';
        }
        for (int i = 0; i <= rows + 1; i++)
        {
            visit_matrix[i][0] = 'x';
            visit_matrix[i][columns + 1] = 'x';
        }
    }

    private int GetNeighbours(int coord_x, int coord_y)
    {
        int counter = 0;
        for(int i=coord_x-1;i<=coord_x+1;i++)
            for(int j=coord_y-1;j<=coord_y+1;j++)
            {
                if(bomb_matrix[i][j]=='*')
                {
                    counter++;
                }
            }
            return counter;
    }
    private void Spread(int coord_x,int coord_y)
    {
        int counter;

        if(bomb_matrix[coord_x][coord_y]!='*')
        {
            if(visit_matrix[coord_x][coord_y]!='x')
            {
                visit_matrix[coord_x][coord_y]='x';
                counter = GetNeighbours(coord_x,coord_y);
                SetNumUnopenedCells();
                if (counter>0) matrix[coord_x][coord_y] =(char) (counter + '0');
                else if (counter == 0)
                {
                    matrix[coord_x][coord_y] =(char) (counter + '0');
                    Spread(coord_x,coord_y-1);
                    Spread(coord_x-1,coord_y-1);
                    Spread(coord_x-1,coord_y);
                    Spread(coord_x-1,coord_y+1);
                    Spread(coord_x,coord_y+1);
                    Spread(coord_x+1,coord_y+1);
                    Spread(coord_x+1,coord_y);
                    Spread(coord_x+1,coord_y-1);
                }
            }
        }
    }

    protected void Click(int coord_x,int coord_y)
    {
        VisitMatrixGen();
        Spread(coord_x,coord_y);
        GetMatrix();
        GetBombMatrix();
    }
}
