/*
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    You can return the answer in any order.
*/

/*
    思考目的: 如何縮短執行時間? 
    1.暴力解法 缺點? → 每一輪都要全找，不能夠再每一輪儲存有用且可再用資訊
    2.問題 → 如何每輪存資訊?
    思考方法:
    1.由陣列中找兩數(A,B)相加為target → target - A = B
    2.把target - A 的差(diff)存入HashMap的Key[運用HashMap的containsKey()來找]
    3.如果之後的數 = taget - A則找到答案 hm.get(diff) i 回傳兩數在陣列中的index
    4.如果是要回傳值 則把Key 跟 Value 互換即可
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {            
        Map<Integer,Integer> hm = new HashMap<>();  
        for(int i = 0 ; i<nums.length ; i++){
            int diff = target-nums[i];
             if (hm.containsKey(diff)) {
                return new int[] { hm.get(diff), i};
            }
            hm.put(nums[i],i);
        }   
        throw new IllegalArgumentException("No Answer");
    }    
}

