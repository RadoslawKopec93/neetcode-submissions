class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        boolean loop = true;
        int i = 0;

        if(nums == null) {
            return 0;
        }

        if(nums.length == 0) {
            return 0;
        }
        while(loop) {
            if(set.contains(nums[i])) {
                return nums[i];
            }

            set.add(nums[i]);
            i++;
            if(i == nums.length) {
                loop = false;
            }
        }
        return 0;
    }
}
