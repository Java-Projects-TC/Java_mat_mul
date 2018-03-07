package uk.ac.imperial.matrixmult;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ConcurrentArrayList<T> {

  //use this to lock for write operations like add/remove
  private final Lock readLock;

  //use this to lock for read operations like get/contains.
  private final Lock writeLock;

  //the underlying list
  private final List<T> list = new ArrayList();

  {
    ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    readLock = readWriteLock.readLock();
    writeLock = readWriteLock.writeLock();
  }

  public void add(T e) {
    writeLock.lock();
    try {
      list.add(e);
    } finally {
      writeLock.unlock();
    }
  }

  public T get(int index) {
    readLock.lock();
    try {
      return list.get(index);
    } finally {
      readLock.unlock();
    }
  }

  public int size(){
    readLock.lock();
    try {
      return list.size();
    } finally {
      readLock.unlock();
    }
  }

}
