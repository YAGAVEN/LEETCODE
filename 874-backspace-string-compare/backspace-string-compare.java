class Solution {
    public boolean backspaceCompare(String s, String t) {
        Deque<Character> s1 = new ArrayDeque<>();
        Deque<Character> s2 = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(c!='#'){
                s1.push(c);
            }else{
                if (!s1.isEmpty()) {
                    s1.pop();
                }
            }
        }
        for(char c : t.toCharArray()){
            if(c!='#'){
                s2.push(c);
            }else{
                if (!s2.isEmpty()) {
                    s2.pop();
                }
            }
        }
        return build(s1).equals(build(s2));
    }
    private String build(Deque<Character> stack) {
    StringBuilder sb = new StringBuilder();
    while(!stack.isEmpty()) {
        sb.append(stack.pop());
    }
    return sb.reverse().toString();
}
}