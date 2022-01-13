// 還是很慢 但快了一點
class Solution {
    public int removeDuplicates(int[] nums) {
        int putNum = 0,
            tmpNum = 0;
        for(int i = 0; i < nums.length; i ++){
            if(i == 0){
                tmpNum = nums[i];
            }
            else if(tmpNum != nums[i]){
                nums[putNum ++] = tmpNum;
                tmpNum = nums[i];
            }            
        }
        if(nums.length >= 1)
            nums[putNum ++] = nums[nums.length - 1];    
        return putNum;
    }
}
