class Solution {
    // val = 4
    // nums = 1, 2, 3, 4
    // j = 0
    // 4,4,4
    public int removeElement(int[] nums, int val) {
        int j = 0;

        for(int i = 0; i<nums.length; i++) {
            if(nums[i] != val) {
                nums[j] = nums[i];

                j++;
            }
        }
        return j;
    }
}