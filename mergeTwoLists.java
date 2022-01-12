/*
要多練習 鏈結串列的題目
很不熟 雖然想得很簡單可是寫得很卡
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
        ListNode list3 = new ListNode(0),
                 head3 = list3,
                 node = null;
        
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                node = new ListNode(list1.val);
                node.next = null;
                list3.next = node;
                list3 = list3.next;
                list1 = list1.next;
            }
            else if(list1.val > list2.val){
                node = new ListNode(list2.val);
                node.next = null;
                list3.next = node;
                list3 = list3.next;
                list2 = list2.next;
            }                
        }// end while   
        while(list1 != null){
            node = new ListNode(list1.val);
            node.next = null;
            list3.next = node;
            list3 = list3.next;
            list1 = list1.next;            
        }
        while(list2 != null){
            node = new ListNode(list2.val);
            node.next = null;
            list3.next = node;
            list3 = list3.next;
            list2 = list2.next;
            
        }
        list3 = head3.next;
        return list3;
    }//end mergeTwoLists()
}
