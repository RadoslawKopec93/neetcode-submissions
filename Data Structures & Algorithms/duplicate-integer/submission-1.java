class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> set = Arrays.stream(nums).collect(HashSet::new, HashSet::add, HashSet::addAll);
        return nums.length > set.size();
    }
}