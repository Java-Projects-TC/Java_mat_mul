package uk.ac.imperial.matrixmult;

public class ArrayBasedMatrix implements Matrix{

private ConcurrentArrayList<Double[]> matrix;

  public ArrayBasedMatrix(int numRows, int numCols) {
    ConcurrentArrayList matrix = new ConcurrentArrayList<>();
    for (int i = 0; i < numRows; i++) {
      matrix.add(new Double[numCols]);
    }
    this.matrix = matrix;
  }

  @Override
  public double get(int row, int column) {
    return matrix.get(row)[column];
  }

  @Override
  public void set(int row, int column, double value) {
    matrix.get(row)[column] = value;
  }

  @Override
  public int getNumRows() {
    return matrix.size();
  }

  @Override
  public int getNumColumns() {
    return matrix.get(0).length;
  }
}
