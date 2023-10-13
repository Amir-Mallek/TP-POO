import java.util.HashMap;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> index = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (index.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = index.get(target - nums[i]);
                break;
            } else
                index.put(nums[i], i);
        }
        return res;
    }
}