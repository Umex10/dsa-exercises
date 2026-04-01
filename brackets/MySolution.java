package brackets;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

  public static void main(String[] args) {
    
    boolean result = areBracketsBalanced("()[]{}");

    System.out.println(result);

  }

  public static boolean areBracketsBalanced(String s) {

    Deque<Character> stack = new ArrayDeque<>();

    for (char c : s.toCharArray()) {
      if (c == '(' || c == '[' || c == '{') {
        stack.push(c);
      } else {
        if (stack.isEmpty())
          return false;

        char last = stack.pop();

        if (c == ')' && last != '(')
          return false;
        if (c == ']' && last != '[')
          return false;
        if (c == '}' && last != '{')
          return false;
      }
    }

    return stack.isEmpty();
  }
}