class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> res = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (res.containsKey(nums[i])) {
                if (i - res.get(nums[i]) <= k) {
                    return true;
                }
            }
            res.put(nums[i], i);
        }
        return false;
    }
}