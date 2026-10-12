class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^\\p{L}\\p{N}]", "");
      
        char[] ch = s.toLowerCase().toCharArray();
    
        List<Character> list = new ArrayList<>();
        for (char c : ch) {
            list.add(c);
            }
        String ns = new StringBuilder(s).reverse().toString();
       
        return s.toLowerCase().equals(ns.toLowerCase());
    }
}
