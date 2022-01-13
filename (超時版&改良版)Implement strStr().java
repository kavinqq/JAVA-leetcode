/*
都對 但是
Time Limit Exceeded!!!

留著作警惕 可以看看自己在第一次寫 有多少多餘的敘述

class Solution {
    public int strStr(String haystack, String needle) {                
        if(haystack.equals(null) || needle.equals(null) || needle.length() == 0){
            return 0;
        }
        boolean find = false;
        int ans = 0,
            checkTime = 0,
            needleIndex = 0;
                  
        for(int i = 0; i < haystack.length(); i ++){       
            if(i + checkTime >= haystack.length()){
                break;
            }
            if(haystack.length() - i < needle.length()){
                break;
            }
            int tmpIndex = i;            
            while(haystack.charAt(tmpIndex ++) == needle.charAt(needleIndex ++) ){  
                checkTime +=1 ;
                if(tmpIndex == haystack.length() && needleIndex != needle.length() ){
                    break;
                }
                if(needleIndex == needle.length()){
                    ans = i;
                    find = true;
                    break;
                }
            }//end while()                  
            if(find){
                break;                    
            }
            else{ 
                checkTime = 0;
                needleIndex = 0;   
            }
        }//for()
        if(find)
            return ans;
        else
            return -1;
    }
}

*/


class Solution {
    public int strStr(String haystack, String needle) {                
        if(needle.length() == 0){
            return 0;
        }                
        
        for(int i = 0; i < haystack.length(); i ++){                   
            int tmpIndex = i;
            if(haystack.length() - i < needle.length()){
                break;
            }
            for(int j = 0; j < needle.length(); j ++){
                
                if(haystack.charAt(tmpIndex) != needle.charAt(j) ){
                    break;
                }
                else{
                    tmpIndex += 1;
                }
                if(j == needle.length() - 1){
                    return i;
                }
            }//end for() line 7
        }//end for() line 12
        return -1;
    }
}
