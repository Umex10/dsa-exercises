class Solution {
    public int[] twoSum(int[] nums, int target) {

        int i = 0;
        int j = 1;

        while (i < nums.length - 1) { 

           if (nums[i] + nums[j] == target) {
                return new int[]{i, j};
            }

            if (j != nums.length - 1) {
                j++;
            } else {
                i++;
                j = i + 1;
            }
        }

        // Unnecessary but java still needs a return 
        return new int[0];
    }
}