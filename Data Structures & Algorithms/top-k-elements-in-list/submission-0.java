class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Long> map = Arrays.stream(nums)
                  .boxed()
                  .collect(
                    Collectors.groupingBy(this::sortNumbers,
                    Collectors.counting()
                    ));
        List<Integer> list = map.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        int[] r = new int[k];        
        boolean start = false;
        int index = 0;
        for(int i = 0; i < list.size(); i++) {
            if(i == list.size() - k) {
                start = true;
            }
            if(start) {
                r[index] = list.get(i);
                index++;
            }
        }   
        return r;     
    }

    private Integer sortNumbers(int i) {
        return i;
    }
}
