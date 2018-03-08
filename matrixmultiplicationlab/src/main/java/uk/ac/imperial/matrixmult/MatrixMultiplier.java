package uk.ac.imperial.matrixmult;

import java.util.ArrayList;
import java.util.List;

public class MatrixMultiplier {

  // basic implementation using trivial algorithm
  public static Matrix multiply(Matrix a, Matrix b) throws Exception {
    assert (a != null || b != null) :
        "The coefficients matrix shouldn't be null";
    if (a.getNumColumns() != b.getNumRows()) {
      throw new RuntimeException("Illegal matrix dimensions.");
    }
    List<Thread> threadList = new ArrayList<>();

    Matrix c = new ArrayBasedMatrix(a.getNumRows(), b.getNumColumns());

    for (int i = 0; i < c.getNumRows(); i++) {
      threadList.add(new Thread(new MultiplyRows(a, b, c, i)));
    }
    for (Thread thread : threadList) {
      thread.start();
    }
    for (Thread thread : threadList) {
      thread.join();
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

class MultiplyRows implements Runnable {

  Matrix a;
  Matrix b;
  Matrix c;
  int rowToCalc;

  public MultiplyRows(Matrix a, Matrix b, Matrix c, int row) {
    this.a = a;
    this.b = b;
    this.c = c;
    this.rowToCalc = row;
  }

  @Override
  public void run() {

    for (int j = 0; j < c.getNumColumns(); j++) {
      double entryValue = 0;
      for (int k = 0; k < a.getNumColumns(); k++) {
        entryValue += (a.get(rowToCalc,k) * b.get(k,j));
      }
      c.set(rowToCalc,j,entryValue);
    }
  }
}
