class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] rans = ransomNote.toCharArray();
        char[] maga = magazine.toCharArray();
        boolean[] magbool = new boolean[maga.length];
        for(int i=0;i<rans.length;i++){
            for(int j=0;j<maga.length;j++){
                if(rans[i]==maga[j] && magbool[j] == false){
                    magbool[j]=true;
                    break;
                }
            }
        }
        int c=0;
        for(boolean b : magbool){
            if(b){
                c++;
            }
        }
        return (c==rans.length);
    }
}