package uk.ac.imperial.matrixmult;

import java.io.BufferedReader;
import java.io.FileReader;

public class MatrixBuilder {

  //builds a matrix from the source
  public static Matrix build(double[][] source) {
    Matrix matrix = new ArrayBasedMatrix(source.length, source[0].length);
    for (int i = 0; i < source.length; i++) {
      for (int j = 0; j < source[0].length; j++) {
        matrix.set(i, j, source[i][j]);
      }
    }
    return matrix;
  }

  // builds a matrix of all zero values
  public static Matrix build(int nRows, int nCols) {
    return new ArrayBasedMatrix(nRows,nCols);
  }

}
