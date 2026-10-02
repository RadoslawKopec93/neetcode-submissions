class Solution {
    public boolean isAnagram(String s, String t) {
        List<String> list1 = Arrays.asList(s.split(""));
        List<String> list2 = Arrays.asList(t.split(""));
        Collections.sort(list1);
        Collections.sort(list2);

        return list1.equals(list2);
    }
}
