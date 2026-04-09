class Solution {
    public void rotate(int[] nums, int k) {

        k = k % nums.length;
				
				// [1,2,3,4,5,6,7]
        switchNumbers(nums, 0, nums.length - 1);

        // [7,6,5,4,3,2,1]

        switchNumbers(nums, 0, k - 1);

        // [5,6,7,4,3,2,1]

        switchNumbers(nums, k, nums.length - 1);

        // [5,6,7,1,2,3,4]
    }

    public void switchNumbers(int[] nums, int left, int right) {

        while (left < right) {
            int num = nums[left];
            nums[left] = nums[right];
            nums[right] = num;
            left++;
            right--;
        }

    }
}
