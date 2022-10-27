package it.unipr.informatica.exam.luglio5.matrix;

public class SparseMatrix implements Matrix {
    private int[][] sparsematrix;
        
    public SparseMatrix(int[][] matrix) {
        this.sparsematrix = matrix;
    }
    public SparseMatrix(){}
    
    @Override
    public int getRows() {
        return sparsematrix.length;
    }
    @Override
    public int getColumns() {
        return sparsematrix[0].length;
    }
    @Override
    public int getValue(int r, int c) {
        return sparsematrix[r][c];
    }
    
    public void setValue(int r, int c, int value) {
        sparsematrix[r][c] = value;
    }
    
    //populate the matrix with mostly 0s 
    public void populateSparse() {
        for (int i = 0; i < sparsematrix.length; i++) {
            for (int j = 0; j < sparsematrix[0].length; j++) {
                if (Math.random() < 0.7) {
                    sparsematrix[i][j] = 0;
                } else {
                    sparsematrix[i][j] = (int) (Math.random() * 10);
                }
            }
        }
    } 

    public void print() {
        for (int i = 0; i < sparsematrix.length; i++) {
            for (int j = 0; j < sparsematrix[0].length; j++) {
                System.out.print(sparsematrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
