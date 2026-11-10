class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        int[] stack = new int[n]; // indices of days still waiting
        int top = -1;

        for (int i = 0; i < n; i++) {
            while (top >= 0 && temperatures[i] > temperatures[stack[top]]) {
                int prev = stack[top--];
                result[prev] = i - prev;
            }
            stack[++top] = i;
        }
        return result;
    }
}