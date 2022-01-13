/*
都對 但是
Time Limit Exceeded!!!
*/
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
