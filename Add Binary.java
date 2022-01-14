/*
用C++的指標概念作的
仔細處理 進位的操作 其實不難 而且程式碼重複性高
雖然感覺很冗長 有待改進

Runtime: 5 ms, faster than 30.36% of Java online submissions for Add Binary.
*/
class Solution {
    public String addBinary(String a, String b) {       
        int aPtr = a.length() - 1;
        int bPtr = b.length() - 1;
        StringBuilder result = new StringBuilder();
        boolean carry = false;
        while(aPtr >= 0 && bPtr >=0){
            if(!carry && a.charAt(aPtr) == b.charAt(bPtr)){
                if(a.charAt(aPtr) == '1'){
                    carry = true;                    
                }
                result.insert(0,0);
            }
            else if(carry && a.charAt(aPtr) == b.charAt(bPtr)){
                if(a.charAt(aPtr) == '1'){
                    result.insert(0,1);
                }
                else{
                    carry = false;
                    result.insert(0,1);
                }                
            }
            else if(carry && a.charAt(aPtr) != b.charAt(bPtr)){
                result.insert(0,0);
            }
            else{
                carry = false;
                result.insert(0,1);
            }
            aPtr--;
            bPtr--;
            if(aPtr < 0 && bPtr < 0 && carry){
                carry = false;
                result.insert(0,1);
            }
        }
        
        
        while(aPtr >= 0){
            if(a.charAt(aPtr) == '1'){
                if(carry){
                    result.insert(0,0);
                }
                else{                    
                    result.insert(0,1);
                }
            }
            else{
                 if(carry){
                    carry = false;
                    result.insert(0,1);
                }
                else{                    
                    result.insert(0,0);
                }                
            }
            aPtr--;
            if(aPtr < 0 && carry){
                result.insert(0,1);
                break;
            }
        }
        
        
         while(bPtr >= 0){
            if(b.charAt(bPtr) == '1'){
                if(carry){
                    result.insert(0,0);
                }
                else{                    
                    result.insert(0,1);
                }
            }
            else{
                if(carry){
                    carry = false;
                    result.insert(0,1);
                }
                else{                    
                    result.insert(0,0);
                }                
            }
            bPtr--;
            if(bPtr < 0 && carry){
                result.insert(0,1);
                break;
            }
        }
        
        return result.toString();
    }
}
