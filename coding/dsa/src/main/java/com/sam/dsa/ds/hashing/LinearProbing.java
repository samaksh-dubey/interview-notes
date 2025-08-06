package com.sam.dsa.ds.hashing;

import java.util.Arrays;

/*
 * Whenever there is a collision try to store key at the next available location
 *
 * h'(x) = (x  % size + f(i)) % 10 s.t.
 * f(i) = i for all i = 0, 1, 2, 3...
 *
 * Loading factor should be less than 0.5
 * */
public class LinearProbing {
  private int size;
  private Integer[] hash_table;

  LinearProbing(int size) {
    this.size = size;
    this.hash_table = new Integer[size];
    Arrays.fill(this.hash_table, null);
  }

  private int hash(int x) {
    return x % size;
  }

  private int f(int i) {
    return i;
  }

  public void insert(int x) {
    int i, idx = 0;
    for (i = 0; i < size; i++) {
      idx = (hash(x) + f(i)) % this.size;
      if (hash_table[idx] == null) break;
    }

    if (i < size) {
      hash_table[idx] = x;
    }
  }

  public void remove(int x) {
    int i, idx = 0;
    for (i = 0; i < size; i++) {
      idx = (hash(x) + f(i)) % this.size;
      if (hash_table[idx] == x) break;
    }

    if (i < size) {
      hash_table[idx] = null;
    }

    rehash();
  }

  private void rehash() {
    // Remove all keys and re-insert in the hash
    // Thus it is recommended to not delete the key
  }

  public boolean contains(int x) {
    int i, idx;
    for (i = 0; i < size; i++) {
      idx = (hash(x) + f(i)) % this.size;

      if (hash_table[idx] == null) return false;

      if (hash_table[idx] == x) return true;
    }
    return false;
  }
}
