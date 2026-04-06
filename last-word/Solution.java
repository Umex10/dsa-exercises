class Solution {

    public static int lengthOfLastWord(String s) {

        boolean isAChar = false;
        int t = 0;
        for (int i = s.length() - 1; i >= 0; i--) {

            char c = s.charAt(i);

            if (c == ' ' && isAChar) {
                break;
            }

            if (c != ' ') {
                isAChar = true;
                t++;
            }
        }

        return t;
    }
}
