package com.sam.dsa._4_stack.questions;

import junit.framework.Assert;
import junit.framework.TestCase;

public class _3_LongestBalancedParenthesisTest extends TestCase {

  public void test_balanced_parenthesis() {
    Assert.assertEquals(4, _3_LongestBalancedParenthesis.longestBalancedParenthesis("((()()"));
    Assert.assertEquals(2, _3_LongestBalancedParenthesis.longestBalancedParenthesis("(((()"));
    Assert.assertEquals(0, _3_LongestBalancedParenthesis.longestBalancedParenthesis("(((("));
    Assert.assertEquals(4, _3_LongestBalancedParenthesis.longestBalancedParenthesis("()()"));
    Assert.assertEquals(6, _3_LongestBalancedParenthesis.longestBalancedParenthesis("(()())(()"));
  }
}
