package com.sam.dsa.ds.stack.questions;

import java.util.Stack;

// Duplicate parenthesis is the expressions in which the parenthesis is redundant
// e.g. (x+y) + z = valid
// e.g. ((x+y)) + z = invalid -> has redundant parenthesis
public class DuplicateParenthesis {

  public boolean hasDuplicate(String expression) {
    Stack<Character> stack = new Stack<>();
    for (Character character : expression.toCharArray()) {
      if (character != ')') {
        stack.push(character);
      } else {
        // If first expression before '(' if found to be ')' then this is a duplicate parenthesis
        if (stack.peek() == '(') {
          return true;
        }

        while (stack.peek() != '(') stack.pop();
        stack.pop();
      }
    }
    return false;
  }
}
