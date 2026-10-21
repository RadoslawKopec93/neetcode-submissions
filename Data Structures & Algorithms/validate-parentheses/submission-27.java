class Solution {
    public boolean isValid(String s) {
        // /10x-plan create-case-with-schedule
        char[] chars = s.toCharArray();
        int l = 0, r = chars.length - 1;
        List<Character> openedBrackets = new ArrayList<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(']','[');
        map.put('}','{');
        map.put(')','(');
        if(chars.length == 0 || chars.length == 1 || chars.length % 2 != 0) {
            return false;
        }
        while(l <= r) {
            if(isOpeningBracket(chars[l])) {
                openedBrackets.add(chars[l]);
            } else {
                if(openedBrackets.isEmpty()) {
                    return false;
                }
                int lastIndex = openedBrackets.size() - 1;  
                Character lastChar = openedBrackets.get(lastIndex);
              
                if(map.get(chars[l]).equals(lastChar)) {
                   openedBrackets.removeLast();
                } else {
                    return false;
                }
            }
            l++;
        }
        return openedBrackets.size() == 0;
    }

    public boolean isOpeningBracket(Character ch) {
        return (ch == '[' || ch == '{' || ch == '(');
    }
}
