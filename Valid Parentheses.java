/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
*/
/*
要記住 stack 是用 Deque類別 和 常用方法
Deque<資料型別> stack = new ArrayDeque<>();
.isEmpty()  "是否" 為空
.assLast()  存入元素
.peekLast() 取出元素
.removeLast() 移除最後一個元素
*/
class Solution {
    public boolean isValid(String s) {
        boolean ans = true;
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                stack.addLast(s.charAt(i));
            else if((s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') && stack.isEmpty()){
                ans = false;
                break;
            }
            else if((s.charAt(i) == ')' && stack.peekLast() != '(') ||
               (s.charAt(i) == ']' && stack.peekLast() != '[') ||
               (s.charAt(i) == '}' && stack.peekLast() != '{'))
            {
                ans = false;
                break;
            }
            else{
                stack.removeLast();
            }
        }// end of for
        if(!stack.isEmpty()) 
            ans = false;
        return ans;
    }
}
