package brackets;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public static boolean areBracketsBalanced(String s) {

    List<Character> brackets = new ArrayList<>();

    for (int i = 0; i < s.length(); i++) {

      char c = s.charAt(i);
      if (c == '(' || c == '{' || c == '[') {
        brackets.addLast(c);
      } else {
        if (brackets.size() == 0)
          return false;

        char last = brackets.getLast();
        brackets.removeLast();

        if (last == '(' && c != ')')
          return false;
        if (last == '{' && c != '}')
          return false;
        if (last == '[' && c != ']')
          return false;
      }
    }
    return brackets.size() == 0;
  }

}
