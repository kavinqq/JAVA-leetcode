class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            char roman = s.charAt(i);
            if(i + 1 != s.length()){
                char nextRoman = s.charAt(i + 1);
                if(roman == 'I' && (nextRoman == 'V' || nextRoman == 'X')){
                    sum += getValue(nextRoman)-getValue(roman);
                    i ++;
                }                    
                else if(roman == 'X' && (nextRoman == 'L' || nextRoman == 'C')){
                    sum += getValue(nextRoman)-getValue(roman);
                    i ++;
                }
                else if(roman == 'C' && (nextRoman == 'D' || nextRoman == 'M')){
                    sum += getValue(nextRoman)-getValue(roman);
                    i ++;
                }
                else{
                    sum += getValue(roman);
                }                    
            }
            else sum += getValue(roman);            
        }
        return sum;
    }
    
    public int getValue(char roman){
        if(roman == 'I')
            return 1;
        else if(roman == 'V')
            return 5;
        else if(roman == 'X')
            return 10;
        else if(roman == 'L')
            return 50;
        else if(roman == 'C')
            return 100;
        else if(roman == 'D')
            return 500;
        else 
            return 1000;
    }
}
