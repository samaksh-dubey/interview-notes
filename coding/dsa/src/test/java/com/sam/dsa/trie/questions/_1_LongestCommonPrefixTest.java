package com.sam.dsa.trie.questions;

import com.sam.dsa.ds._9_trie.questions._1_LongestCommonPrefix;
import junit.framework.Assert;
import junit.framework.TestCase;

public class _1_LongestCommonPrefixTest extends TestCase {

  public void test() {
    String[] words =
        new String[] {
          "code",
          "coder",
          "coding",
          "codable",
          "codec",
          "codecs",
          "coded",
          "codeless",
          "codependence",
          "codependency",
          "codependent",
          "codependents",
          "codes",
          "codesign",
          "codesigned",
          "codeveloped",
          "codeveloper",
          "codex",
          "codify",
          "codiscovered",
          "codrive"
        };

    Assert.assertEquals("cod", _1_LongestCommonPrefix.longestCommonPrefix(words));
  }

  public void test_no_lcp() {
    String[] words = new String[] {"code", "encode", "codec"};
    Assert.assertEquals("", _1_LongestCommonPrefix.longestCommonPrefix(words));
  }
}
