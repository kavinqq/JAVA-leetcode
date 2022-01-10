/*
  要理解題目的意思
  題目是要 全部字串相同字首的長度 
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {  
        if(strs.length == 1)
            return strs[0];        
        int prefixLen = 0;
        for(int i = 1; i < strs.length; i++){
            int tmpLen = 0,
                strPtr1 = 0,
                strPtr2 = 0;
            while(strPtr1 < strs[i - 1].length() && strPtr2 < strs[i].length()){
                if(strs[i - 1].charAt(strPtr1) == strs[i].charAt(strPtr2)){
                    strPtr1++;
                    strPtr2++;
                    tmpLen++;
                }
                else
                    break;
            }
            if(i == 1){
                prefixLen = tmpLen;
            }
            prefixLen = (tmpLen < prefixLen) ? tmpLen : prefixLen;
        }
        if(prefixLen == 0){
            return "";     
        }
        return strs[0].substring(0, prefixLen);
    }
}
