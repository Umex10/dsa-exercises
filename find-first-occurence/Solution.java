class Solution {
    public int strStr(String haystack, String needle) {

        // sadbutsad
        int hLen = haystack.length();
        int nLen = needle.length();

        for (int i = 0; i <= hLen - nLen; i++) {
            
            int j = 0;
            while(j < nLen && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            if (j == nLen) {
                return i;
            }

        }

        return -1;
        
    }
}