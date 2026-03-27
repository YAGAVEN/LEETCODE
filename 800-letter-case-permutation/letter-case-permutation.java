class Solution {
public List<String> letterCasePermutation(String s) {
    List<String> ans = new ArrayList<>();
    List<Character> arr = new ArrayList<>();
    backtrack(0, ans, s, arr);
    return ans;
}

public void backtrack(int i, List<String> ans, String s, List<Character> arr) {
    if (i == s.length()) {
        StringBuilder sb = new StringBuilder();
        for (char c : arr) sb.append(c);
        ans.add(sb.toString());
        return;
    }
    char ch = s.charAt(i);
    arr.add(ch);
    backtrack(i + 1, ans, s, arr);
    arr.remove(arr.size() - 1);
    if (Character.isLetter(ch)) {
        char toggled = Character.isLowerCase(ch)
                ? Character.toUpperCase(ch)
                : Character.toLowerCase(ch);

        arr.add(toggled);
        backtrack(i + 1, ans, s, arr);
        arr.remove(arr.size() - 1);
    }
}
}