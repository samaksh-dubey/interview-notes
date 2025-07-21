package com.sam.dsa.trie.questions;

import junit.framework.Assert;
import junit.framework.TestCase;

public class _3_MaximumOccurringStringTest extends TestCase {

  public void test_maxOccuringString() {
    String[] words = {
      "code",
      "coder",
      "coding",
      "codable",
      "codec",
      "codecs",
      "coded",
      "codeless",
      "codec",
      "codecs",
      "codependence",
      "codex",
      "codify",
      "codependents",
      "codes",
      "code",
      "coder",
      "codesign",
      "codec",
      "codeveloper",
      "codrive",
      "codec",
      "codecs",
      "codiscovered"
    };

    Assert.assertEquals("codec", _3_MaximumOccurringString.maxOccurring(words));
  }
}
