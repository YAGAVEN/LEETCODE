class Solution {
    public int romanToInt(String s) {
    int sum = 0;
    
    for (int i = 0; i < s.length(); i++) {
        int current = value(s.charAt(i));
        
        if (i < s.length() - 1) {
            int next = value(s.charAt(i + 1));
            
            if (current < next) {
                sum -= current;
            } else {
                sum += current;
            }
        } else {
            sum += current;
        }
    }
    
    return sum;
}

public int value(char c) {
    switch (c) {
        case 'I': return 1;
        case 'V': return 5;
        case 'X': return 10;
        case 'L': return 50;
        case 'C': return 100;
        case 'D': return 500;
        case 'M': return 1000;
        default: return 0;
    }
}

    // public int intToRoman(Integer n) {
    //     String[] sym ={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    //     int[] val ={1000,900,500,400,100,90,50,40,10,9,5,4,1};
    //     StringBuilder sb = new StringBuilder();
    //     while(n>0){
    //         for(int i=0;i<val.length;i++){
    //             if(val[i]<=n){
    //                 n-=val[i];
    //                 sb.append(sym[i]);
    //                 break;
    //             }
    //         }
    //     }
    //     return sb.toString();    
    // }
}