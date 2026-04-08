import java.util.List;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String removeDuplicates(String s) {

        List<Character> chars = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
           
            if (chars.size() > 0 && c == chars.getLast()) {
                chars.remove(chars.size() - 1);
            } else {
                chars.add(c);
            }
        }

        return chars.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining());
    }
}