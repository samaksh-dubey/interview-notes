package com.sam.dsa._4_stack.questions;

import com.sam.dsa.ds.stack.questions.LongestBalancedParenthesis;
import junit.framework.Assert;
import junit.framework.TestCase;

public class __LongestBalancedParenthesisTest extends TestCase {

  public void test_balanced_parenthesis() {
    Assert.assertEquals(4, LongestBalancedParenthesis.longestBalancedParenthesis("((()()"));
    Assert.assertEquals(2, LongestBalancedParenthesis.longestBalancedParenthesis("(((()"));
    Assert.assertEquals(0, LongestBalancedParenthesis.longestBalancedParenthesis("(((("));
    Assert.assertEquals(4, LongestBalancedParenthesis.longestBalancedParenthesis("()()"));
    Assert.assertEquals(6, LongestBalancedParenthesis.longestBalancedParenthesis("(()())(()"));
  }
}
