class Solution {
    public String reverseVowels(String s) {

        int left = 0;
        int right = s.length() - 1;

        char[] chars = s.toCharArray();

           while (left < right) {
            if (!isVowel(chars[left])) {
                left++;
            } else if (!isVowel(chars[right])) {
                right--;
            } else {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }

    boolean isVowel(char c) {
        char cleanC = Character.toLowerCase(c);

        if (cleanC == 'a' || cleanC == 'e' || cleanC == 'i' || cleanC == 'o' || cleanC == 'u') {
            return true;
        } else {
            return false;
        }
    }
}
