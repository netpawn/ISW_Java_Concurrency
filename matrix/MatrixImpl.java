package it.unipr.informatica.exam.luglio5.matrix;

public class MatrixImpl {

    protected DenseMatrix denseMatrix;
    protected SparseMatrix sparseMatrix; 
    protected Matrix matrix; 
    private boolean isSparse; 

    public MatrixImpl(Matrix matrix, boolean isSparse){
        this.matrix = matrix; 
        this.isSparse = isSparse; 
    }

    public int getRows() {
        return matrix.getRows();
    }
    public int getColumns(){
        return matrix.getColumns();
    }
    public int getValue(int r, int c){
        return matrix.getValue(0, 0);
    }
    public boolean isSparse(){
        if(isSparse==true) return true; 
        else return false; 
    }
    public void populate(){
        if(isSparse==true){
           ((SparseMatrix) matrix).populateSparse();
        }
        else ((DenseMatrix)matrix).populateDense();
    }
    public void print() {
        if(isSparse==true){
            ((SparseMatrix)matrix).print();
        }
        else ((DenseMatrix)matrix).print();
    }
}