package it.unipr.informatica.exam.luglio5.matrix;

public class Driver {

    public void go(){

        int[][] matrix1 = {{0,0,0},{0,0,0},{0,0,0},{0,0,0}};
        int[][] matrix2 = {{0,0,0},{0,0,0},{0,0,0},{0,0,0}};
        int[][] matrix3 = {{0,0,0},{0,0,0},{0,0,0},{0,0,0}};
        int[][] matrix4 = {{0,0,0},{0,0,0},{0,0,0},{0,0,0}};
       
        DenseMatrix dm = new DenseMatrix(matrix1);
        SparseMatrix sm = new SparseMatrix(matrix2);

        dm.populateDense();
        sm.populateSparse();
       
        System.out.println("--------Dense Matrix Testing--------");
        dm.print();
        System.out.println("Test metodi per dense"); 
        System.out.println(dm.getRows()); 
        System.out.println(dm.getColumns()); 
        System.out.println(dm.getValue(0, 0)); 
        
        
        System.out.println("--------Sparse Matrix Testing--------"); 
        sm.print();
        System.out.println("Test metodi per sparse"); 
        System.out.println(sm.getRows()); 
        System.out.println(sm.getColumns()); 
        System.out.println(sm.getValue(0, 0)); 

        System.out.println("--------MATRIX IMPL TESTING--------"); 
        MatrixImpl miD = new MatrixImpl(dm, false);
        MatrixImpl miS = new MatrixImpl(sm, true); 
        System.out.println("Test metodi per matrix impl"); 
        System.out.println(miD.getRows());
        System.out.println(miD.getColumns());
        System.out.println(miD.getValue(0, 0));
        System.out.println(miD.isSparse());
        System.out.println(miS.getRows());
        System.out.println(miS.getColumns());
        System.out.println(miS.getValue(0, 0));
        System.out.println(miS.isSparse());
        

        System.out.println("--------BRIDGE TESTING--------");
        MatrixImpl mimi = new MatrixImpl(new DenseMatrix(matrix3), false);
        mimi.populate();
        mimi.print(); 
        System.out.println("Test metodi per bridge matrice densa"); 
        System.out.println(mimi.getRows());
        System.out.println(mimi.getColumns());
        System.out.println(mimi.getValue(0, 0)); 
        System.out.println(mimi.isSparse());
            System.out.println(" ");
        MatrixImpl mimi2 = new MatrixImpl(new SparseMatrix(matrix4), true);
        mimi2.populate();
        mimi2.print(); 
        System.out.println("Test metodi per bridge matrice sparsa"); 
        System.out.println(mimi2.getRows());
        System.out.println(mimi2.getColumns());
        System.out.println(mimi2.getValue(0, 0)); 
        System.out.println(mimi2.isSparse());

        
    }
    public static void main(String[] args){
        new Driver().go();
    }
}

