package com.sam.ds.algo.practise.hashing;

/*
* Uses two hash function.
*
* h1(x) = x % size
* h2(x) = R - x % R     |   R is prime number less than size of hash table
*
* h'(x) = (h1(x) + i * h2(x)) % size
*
* h2 is used only in case of collision
* */
public class DoubleHashing {
}
