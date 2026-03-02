class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int l = 0 ;
        int r = arr.length-1;
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('e');
        while(l<r){
            while( l<r && !set.contains(Character.toLowerCase(arr[l])))l++;
            while( l<r && !set.contains(Character.toLowerCase(arr[r])))r--;
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
        StringBuilder sb = new StringBuilder();
        for(char c : arr){
            sb.append(c);
        }
        return sb.toString();
        
    }
}