package single;

class Solution {
    public int singleNumber(int[] nums) {

        // [4,1,2,1,2] = 10

        int res = 0;

        for (int num : nums) {
            res = res ^ num;
            // 0100 --> 4
            // 0101 --> 1
            // 0111 --> 2
            // 0110 --> 1
            // 0100 --> 4 end resultat
        }

    return res;
    }
}
