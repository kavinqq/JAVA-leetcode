/*
Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].

一開始想用 先算出陣列總合 再用 (int)Math.log10(sum) + 1 去算 回傳陣列的長度
↑ 為什麼?  因為要考慮 9999999 + 1  = 10000000 進位長度會多一個狀況

但是 LeetCode的測試資料中 有超級無敵長的 int[] 連用long都沒辦法接
所以後來就想說直接用if else 去 實作 加法進位

Runtime: 0 ms, faster than 100.00% of Java online submissions for Plus One.
Memory Usage: 37.5 MB, less than 59.89% of Java online submissions for Plus One.
*/
class Solution {
    public int[] plusOne(int[] digits) {
        boolean sizePlusone = false,
                carry = false,
                carry2 = false;
        int ansArrLen = 0,
            ansArrIndex = 0;
        //去計算 +1後 會不會導致 整體長度+1
        for(int i = digits.length - 1; i >= 0; i--){
            if(i == digits.length - 1 && digits[i] == 9){
                carry = true;
            }
            else if(carry && digits[i] == 9){
                carry = true;
            }
            else {
                carry = false;
            }
        }
        
        if(carry){
            ansArrLen = digits.length + 1;
        }
        else{
            ansArrLen = digits.length;
        }
        
        int[] ansArr = new int[ansArrLen];
        
        for(int i = digits.length - 1; i >= 0; i--){
            //兩個指標不同 如果算完後整體會進位(長度+1)  那答案陣列的index都要+ 1 反之不用
            if(carry){
                ansArrIndex = i + 1;
            }
            else{
                ansArrIndex = i;
            }
            
            //由於只在最後一位 + 1 ， 所以能控制carry2 變成true 只會在最後一位= 9 的情形
            if(i == digits.length - 1 && digits[i] == 9){
                carry2 = true;
                ansArr[ansArrIndex] = 0;
            }
            //最後一位 != 9   就直接 + 1
            else if(i == digits.length - 1 && digits[i] != 9){
                ansArr[ansArrIndex] = digits[i] + 1;
            }
            //下面處理 進位後的狀況 如果又是9 就又進位  反之 就 + 1 ，carry2關閉
            else if(carry2 && digits[i] == 9){
                carry2 = true;
                ansArr[ansArrIndex] = 0;
            }
            else if(carry2 && digits[i] != 9){
                carry2 = false;
                ansArr[ansArrIndex] = digits[i] + 1;
            }
            else{
                carry2 = false;
                ansArr[ansArrIndex] = digits[i];
            }
        }//end for
        if(carry){
            ansArr[0] = 1;
        }
        return ansArr;
    }
}
