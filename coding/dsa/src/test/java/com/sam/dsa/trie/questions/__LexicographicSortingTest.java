package com.sam.dsa.trie.questions;

import com.sam.dsa.ds.trie.questions.LexicographicSorting;
import java.util.Arrays;
import java.util.List;
import junit.framework.Assert;
import junit.framework.TestCase;

public class __LexicographicSortingTest extends TestCase {

  public void test_lexicographic_sorting() {
    String para =
        "lexicographic sorting of a set of keys can be accomplished with "
            + "a simple trie based algorithm we insert all keys in a trie output "
            + "all keys in the trie by means of preorder traversal which results "
            + "in output that is in lexicographically increasing order preorder "
            + "traversal is a kind of depth first traversal";

    List<String> expected =
        Arrays.asList(
            "a",
            "accomplished",
            "algorithm",
            "all",
            "based",
            "be",
            "by",
            "can",
            "depth",
            "first",
            "in",
            "increasing",
            "insert",
            "is",
            "keys",
            "kind",
            "lexicographic",
            "lexicographically",
            "means",
            "of",
            "order",
            "output",
            "preorder",
            "results",
            "set",
            "simple",
            "sorting",
            "that",
            "the",
            "traversal",
            "trie",
            "we",
            "which",
            "with");

    String[] words = para.split(" ");
    List<String> result = LexicographicSorting.lexicographicSort(words);
    System.out.println(String.join("\",\"", result));
    Assert.assertEquals(expected, result);
  }
}
