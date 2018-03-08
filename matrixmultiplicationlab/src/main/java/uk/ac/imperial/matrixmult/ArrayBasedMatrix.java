package uk.ac.imperial.matrixmult;

public class ArrayBasedMatrix implements Matrix {

  private double[][] matrix;

  public ArrayBasedMatrix(int rows, int cols) {
    this.matrix = new double[rows][cols];
  }

  @Override
  public double get(int row, int column) {
    return matrix[row][column];
  }

  @Override
  public void set(int row, int column, double value) {
    matrix[row][column] = value;
  }

  @Override
  public int getNumRows() {
    return matrix.length;
  }

  @Override
  public int getNumColumns() {
    return matrix[0].length;
  }
}

