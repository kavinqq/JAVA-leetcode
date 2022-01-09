/* 
Given an integer x, return true if x is palindrome integer.

An integer is a palindrome when it reads the same backward as forward.

For example, 121 is a palindrome while 123 is not.
*/

class Solution {
    public boolean isPalindrome(int x) {
        //此題是數字前後顛倒 是否一樣(回文) -若改到後面直接false
        if(x < 0){
            return false;
        }
        int tmpX = x, newNum = 0, digitMove = 10;
        //tmpX%10得到最後一位數 ， newNum 每次往左移動一位 ，最終會得到回文結果
        while(tmpX > 0){
            newNum *= digitMove;
            newNum += tmpX % 10;
            tmpX /= 10;
        }    
        
        if(newNum == x)
            return true;
        else 
            return false;
    }
}
