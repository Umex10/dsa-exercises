class Solution {
    public int numberOfSpecialChars(String word) {

        int[] lowercaseLetters = new int[26];
        int[] uppercaseLetters = new int[26];

        for (int i = 0; i < word.length(); i++) {

            char c = word.charAt(i);

            if (Character.isUpperCase(c)) {
                uppercaseLetters[c - 'A']++;
            } else {
                lowercaseLetters[c - 'a']++;
            }
        }

        int res = 0;

        for (int i = 0; i < lowercaseLetters.length; i++) {

             if (lowercaseLetters[i] > 0 && uppercaseLetters[i] > 0) {
                res++;
            }
        }

        return res;
    }
}