class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int k;

        while(l<=r) {
            k = (l+r)/2;
            if(nums[k] > target) {
                r = k-1;
            } else if(nums[k]<target) {
                l = k+1;
            } else {
                return k;
            }
        } 
        return -1;

    }
}





