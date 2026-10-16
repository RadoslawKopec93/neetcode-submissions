class Solution {
    public int maxArea(int[] heights) {
        boolean con = false;
        int result = 0;
        int left = 0, right = heights.length - 1;
        int hl = 0, hr = 0;
         
        while(left < right){
            if(hl < heights[left]) {
                hl = heights[left];
                int tmp = container(left,right,hl,hr);
                if(tmp > result) {
                    result = tmp;
                }
              }

            if(hr < heights[right]) {
                hr = heights[right];
                int tmp = container(left,right,hl,hr);
                if(tmp > result) {
                    result = tmp;
               }
            }

            if(heights[left] <= heights[right]) {
                left++;
            } else {
                right--;
            }
        }
           
        return result;
    }

    public int container(int left, int right, int num, int num2) {
        return countWidth(left,right) * countHeight(num,num2);
    }

    public int countWidth(int left, int right) {
        return right - left;
    }
    public int countHeight(int num, int num2) {
        return Math.min(num,num2);
    }
}
