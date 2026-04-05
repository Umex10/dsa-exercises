package anagram;

class MySolution {
    public boolean isAnagram(String s, String t) {
        int[] letters = new int[26];

        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            letters[c - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);

            letters[c - 'a']--;

            if (letters[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}