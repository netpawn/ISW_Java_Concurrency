package it.unipr.informatica.exam.luglio5.matrix;

public class DenseMatrix implements Matrix{
    private int[][] densematrix;
    
    public DenseMatrix(int[][] matrix) {
        this.densematrix = matrix;
    }
    public DenseMatrix(){}
    
    @Override
    public int getRows() {
        return densematrix.length;
    }
    @Override
    public int getColumns() {
        return densematrix[0].length;
    }
    @Override
    public int getValue(int r, int c) {
        return densematrix[r][c];
    }
    
    public void setValue(int r, int c, int value) {
        densematrix[r][c] = value;
    }
    
    //populate the matrix
    public void populateDense() {
        for (int i = 0; i < densematrix.length; i++) {
            for (int j = 0; j < densematrix[0].length; j++) {
                densematrix[i][j] = (int) (Math.random() * 10);
            }
        }
    }

    public void print() {
        for (int i = 0; i < densematrix.length; i++) {
            for (int j = 0; j < densematrix[0].length; j++) {
                System.out.print(densematrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
