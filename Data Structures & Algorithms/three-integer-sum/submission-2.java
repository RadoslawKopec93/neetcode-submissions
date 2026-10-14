class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int target = 0;
        int[] newNums = Arrays.stream(nums).sorted().toArray();
        int left = 1, right = newNums.length - 1;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < newNums.length - 2; i++) {
            while (left < right) {
                if (i != left && i != right) {

                    if (newNums[i] + newNums[left] + newNums[right] == target) {
                        if (!duplicationCheck(result, newNums[i], newNums[left], newNums[right])) {
                            result.add(new ArrayList<>(Arrays.asList(newNums[i], newNums[left],newNums[right])));
                        }
                    }
                    if (newNums[i] + newNums[left] + newNums[right] < target) {
                        left++;
                    } else {
                        right--;
                    }
                } else {
                    left++;
                }
            }
            right = newNums.length - 1;
            left = 0;
        }
        return result;
    }
      private boolean duplicationCheck(List<List<Integer>> result, int one, int two, int three) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(one, two, three).stream().sorted().collect(Collectors.toList()));
        for (List<Integer> list : result) {
            list.sort(Comparator.naturalOrder());
            if (list.equals(list1)) {
                return true;
            }
        }
        return false;
    }
}
