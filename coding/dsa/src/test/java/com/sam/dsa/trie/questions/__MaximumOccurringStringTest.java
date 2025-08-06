package com.sam.dsa.trie.questions;

import com.sam.dsa.ds.trie.questions.MaximumOccurringString;
import junit.framework.Assert;
import junit.framework.TestCase;

public class __MaximumOccurringStringTest extends TestCase {

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

    Assert.assertEquals("codec", MaximumOccurringString.maxOccurring(words));
  }
}
