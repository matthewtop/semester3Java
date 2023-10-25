public class Model {
    private int[][] matrix;

    public Model(int rows, int columns){
        matrix = new int[rows][columns];
    }

    public int getRows(){
        return matrix.length;
    }
    public int getColumns(){
        return matrix[0].length;
    }

    public int getValue(int rows, int columns){
        return matrix[rows][columns];
    }

    public void setValue(int rows, int columns, int value){
        matrix[rows][columns]=value;
    }
    public int[][] getMatrix(){
        return matrix;
    }


}
