/*
遞迴真的很不能直觀的思考
有空多想想 才能靈活運用
重點1. 最早呼叫的()  最後得到值

先從簡單的去思考
List1    1  → 3
List1    1  → 4
方法簡稱 M()
M(L1, L2)
1. L1 <= L2 所以最晚得到值的會是 最小的 L1 
2. 此時我們要得知的是L1的下一個連著誰?
3. 所以用 L1.N = M(L1.N, L2)
4. L1.N (3) 和 L2(1) 比大小  ， L2小，所以L2會再前面，比較慢得到值，要得知L2的後面接?
5. L2.N = M(L1.N, L2) ... 依序比較
6. 比到 L2 == null  L2沒了 回傳 目前的 L1節點 給上一層的L2.N
           或 
        L1 == null  L1沒了 回傳 目前的 L2節點 給上一層的L1.N
   便會有實質回傳 停止遞迴
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {       
       if(list1 == null && list2 == null){
           return null;
       }    
       if(list1 == null){
           return list2;
       }
       if(list2 == null) {
           return list1;
       }
       if(list1.val <= list2.val){
           list1.next = mergeTwoLists(list1.next, list2);
           return list1;
       }
       else{
           list2.next = mergeTwoLists(list2.next, list1);
           return list2;
       }        
    }//end mergeTwoLists()
}
