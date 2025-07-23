package com.sam.dsa._4_stack.questions;

import java.util.Map;
import java.util.Set;
import java.util.Stack;

// Duplicate parenthesis is the expressions in which the parenthesis is redundant
// e.g. (x+y) + z = valid
// e.g. ((x+y)) + z = invalid -> has redundant parenthesis
public class _2_BalancedParenthesis {

  private static final Set<Character> openParens = Set.of('(', '{', '[');
  private static final Map<Character, Character> closeToOpen = Map.of(')', '(', '}', '{', ']', '[');

  public boolean isDuplicate(String expression) {
    Stack<Character> stack = new Stack<>();
    for (Character character : expression.toCharArray()) {
      if (openParens.contains(character)) {
        stack.push(character);
      } else {
        if (stack.isEmpty()) return false;

        if (closeToOpen.get(character) != stack.pop()) return false;
      }
    }
    return stack.isEmpty();
  }
}
