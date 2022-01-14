/*
Runtime: 11 ms, faster than 5.49% of Java online submissions for Maximum Subarray.
Memory Usage: 90.3 MB, less than 20.75% of Java online submissions for Maximum Subarray.
很慢 但是 對了!
先記錄下來 ， 慢慢改進。
*/
class Solution {
    public int maxSubArray(int[] nums) {             
        int max = nums[0];
        if(nums.length == 1){
            return max;
        }                
        for(int i = 0; i < nums.length; i ++){
           //從 i 的位置 開始找
           int tmp_i = i,
               head = nums[tmp_i],
               tmpMax = nums[tmp_i ++];           
               
           max = (max > tmpMax)? max : tmpMax;
           /*
                如果目前的和為正 && 後面還有元素進while() 
                tmpMax > 0 當前元素為負 那就不用往後找 直接和目前max比完就跳出(處理全部負數的狀況)
           */
           while(tmpMax > 0 && tmp_i != nums.length){
               //如果後面是 正 或 0 直接加，外圈的陣列index也加 (因為正的就是越加越大)              
               if(nums[tmp_i] >= 0){
                   i++;
                   tmpMax += nums[tmp_i++];
                   max = (max > tmpMax)? max : tmpMax;
               }               
               else if(nums[tmp_i] <= 0){
                   //如果加了之後 累加 <= 0 那表示 i 這個數之前的數 為此子字串最大值 跳出
                   if(tmpMax + nums[tmp_i] <= 0){
                       break;
                   }
                   //如果加了之後 累加<=0 那表示可以再往後找找看
                   else{
                       tmpMax += nums[tmp_i ++];                       
                   }                       
               }
           }//end while()              
        }//end for()
        return max;
    }//end maxSubArray()
}//end Solution
