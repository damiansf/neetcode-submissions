class Solution {
    public int findKthLargest(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i<nums.length;i++) {
            list.add(nums[i]);
        }
        Collections.sort(list);
        return list.get(list.size()-k);
    }
}
