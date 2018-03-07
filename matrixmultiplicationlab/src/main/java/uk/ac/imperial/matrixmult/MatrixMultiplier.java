package uk.ac.imperial.matrixmult;

public class MatrixMultiplier {

  // basic implementation using trivial algorithm
  public static Matrix multiply(Matrix a, Matrix b) throws Exception {
    if (a.getNumColumns() != b.getNumRows()) {
      throw new RuntimeException("Illegal matrix dimensions.");
    }

    Matrix c = new ArrayBasedMatrix(a.getNumRows(), b.getNumColumns());
    for (int i = 0; i < c.getNumRows(); i++) {
      for (int j = 0; j < c.getNumColumns(); j++) {
        double entryValue = 0;
        for (int k = 0; k < a.getNumColumns(); k++) {
          entryValue += (a.get(i,k) * b.get(k,j));
        }
        c.set(i,j,entryValue);
      }
    }
    return c;
  }

  // uses strassens algorithm, remember to take into account the need to add
  // dummy rows/columns
  public static Matrix multiply2(Matrix a, Matrix b) throws Exception {
    //TODO;
    return null;
  }

}
