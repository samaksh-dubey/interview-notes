package com.sam.dsa.ds.hashing;

import java.util.ArrayList;
import java.util.List;

/*
 *  Given Size of Hash Table is 10
 *
 * | 01 | = list
 * | 02 | = list
 * | 03 | = list
 * | 04 | = list
 * | 05 | = list
 * | 06 | = list
 * | 06 | = list
 * | 07 | = list
 * | 08 | = list
 * | 09 | = list
 * | 10 | = list
 *
 * Loading Factor = Number of Keys / Size of Hash Table
 *
 * Time for Searching in Chained Hash = 1/2 of Loading Factor
 * Average Search Delete etc. are Same as Linked List of size Loading Factor
 * Worst Search Delete etc. are Same as Linked List of size Number of Keys
 */
public class Chaining {

  private final List<List<Integer>> hash_table;
  private final int table_size;

  public Chaining(int table_size) {
    this.table_size = table_size;
    this.hash_table = new ArrayList<>();
    for (int i = 0; i < table_size; i++) {
      hash_table.add(new ArrayList<>());
    }
  }

  private int hash(int x) {
    return x % table_size;
  }

  public void put(int x) {
    int hash = hash(x);
    List<Integer> chain = hash_table.get(hash);
    int i;
    for (i = 0; i < chain.size(); i++) {
      if (chain.get(i) > x) break;
    }
    chain.add(i, x);
  }

  public void remove(int x) {
    int hash = hash(x);
    List<Integer> chain = hash_table.get(hash);
    int i;
    for (i = 0; i < chain.size(); i++) {
      if (chain.get(i) == x) break;
    }
    if (chain.size() > i) {
      chain.remove(i);
    }
  }

  public static void main(String[] args) {
    Chaining chainedHash = new Chaining(10);
    chainedHash.put(5);
    chainedHash.put(35);
    chainedHash.put(25);
    chainedHash.put(55);
    chainedHash.remove(35);
    chainedHash.remove(55);
    chainedHash.remove(105);
  }
}
