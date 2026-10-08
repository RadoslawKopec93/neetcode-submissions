class Solution {
public int[] productExceptSelf(int[] nums) {
       int prd = 1;
       int count = 0;
       int[] arr = new int[nums.length];

        for(int n : nums) {
            if(n != 0) {
                prd *= n;
            } else {
                count++;
            }
        }

        if(count >= 2) {
            for(int i = 0; i < nums.length; i++) {
               arr[i] = 0;
            }
            return arr;
        }

        if(count == 1) {
             for(int i = 0; i < nums.length; i++) {
                if(nums[i] == 0) {
                    arr[i] = prd;
                } else {
                    arr[i] = 0;
                }
            }
            return arr;
        }

        for(int i = 0; i < nums.length; i++) {

            arr[i] = prd / nums[i];
        }
        return arr;
}
}