class Solution {
    public int firstUniqChar(String s) {
        
        int[] letters = new int[26];
        int index = -1;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            letters[c - 'a']++;
        }
        
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            
            if (letters[c - 'a'] == 1) {
                index = i;
                break;
            }
        }

        return index;
    }
}