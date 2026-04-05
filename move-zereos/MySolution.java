class MySolution {
    public void moveZeroes(int[] nums) {

        int i = 0;

        // [1,0,1]
        for (int l = 0; l < nums.length; l++) {

            if (nums[l] != 0) {
                int saveNumber = nums[i];
                nums[i] = nums[l];
                nums[l] = saveNumber;
                i++;
            } 
        
        }
    }
}