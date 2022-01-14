/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Length of Last Word.
Memory Usage: 38.7 MB, less than 38.76% of Java online submissions for Length of Last Word.

這題在 Cmoney題庫有 已經寫過2.3次
但都沒有想到要從後面來算，突然想到~讚!
*/
class Solution {
    public int lengthOfLastWord(String s) {     
        boolean find = false;
        int lastWordLen = 0;
            
        for(int i = s.length() - 1; i >= 0; i --){
            if(s.charAt(i) != ' '){
                find = true;
                lastWordLen += 1;
            }
            else if(s.charAt(i) == ' ' && find){
                break;
            }
        }
        return lastWordLen;
    }
}
