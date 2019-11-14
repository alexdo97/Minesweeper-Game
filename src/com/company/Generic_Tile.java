package com.company;

public abstract class Generic_Tile extends Board_Gen
{
    protected int coord_x,coord_y;

    public Generic_Tile(int rows, int columns, int bombs, char[][] matrix, char[][] bomb_matrix, boolean bomb_clicked, int coord_x, int coord_y)
    {
        super(rows,columns,bombs,matrix,bomb_matrix,bomb_clicked);
        this.coord_x = coord_x;
        this.coord_y = coord_y;

    }
    protected abstract void Click(int coord_x,int coord_y);

}
