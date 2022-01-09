/* 
Q: Given a string s, find the length of the longest substring without repeating characters.
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
2022/01/09
卡了一整天 終於寫對了 雖然 faster than 9.81% 有夠爛 但至少解出來 YES!!
學到的
1.HashMap的淺複製:
  如果直接用 hMap = hMap2 的話 他只是物件引用的變化(hMap2 指向 hMap 的記憶體)，兩個變數其實指的是同一個物件，在記憶體中佔用同一塊記憶體。
  沒辦法分開用 remove / put
  所以要用 hMap2.putAll(hMap); 只複製 hMap中的 Key和Value。
2.妥善運用HashMap的 containsKey 來比較
3.(提醒)  使用 Map.keySet() 會回傳 Set型態  ， 他的順序是不固定的!
*/


class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ansLen = 0; //回傳的答案
        //hMap 用來記錄 題目字串中有多少不同的字元 ， hMap2則是 複製hMap的值作為比較用途
        HashMap<Character, Integer> hMap = new HashMap<>(); 
        HashMap<Character, Integer> hMap2 = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char key = s.charAt(i);
            //如果 hMap中還沒紀錄 當前字元 加入， 已經有紀錄則不動作
            if(!hMap.containsKey(key)){
                hMap.put(key, 1);
            }
        }
        
        for(int i = 0; i < s.length(); i++){
            //複製hMap的值(此時已經將所有出現且不重複的字元存入hMap中)
            hMap2.putAll(hMap);
            //計算當前字元遇到重複字元前的長度
            int tmpLen = 0;
            //從第 i 個位置往後找，如果hMap2中有這個字元(還沒遇到)長度+1並移除那個字元。反之則代表重複，便直接break;
            for(int j = i; j < s.length(); j++){
                char key = s.charAt(j);
                if(hMap2.containsKey(key)){
                    tmpLen += 1;
                    hMap2.remove(key);
                }
                else{
                    break;
                }
            }
            //若從第i個字元往後找，遇到重複字元前的長度比第i-1個長，則取代
            ansLen = (ansLen > tmpLen)? ansLen : tmpLen;
        }
        return ansLen;
    }//end lengthOfLongestSubstring()
}// end class Solution


/*  深複製 clone
    public static <T extends Serializable> T clone(T obj) {
            T cloneObj = null;
            try {
                // 寫入位元組流
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                ObjectOutputStream obs = new ObjectOutputStream(out);
                obs.writeObject(obj);
                obs.close();

                // 分配記憶體，寫入原始物件，生成新物件
                ByteArrayInputStream ios = new ByteArrayInputStream(out.toByteArray());
                ObjectInputStream ois = new ObjectInputStream(ios);
                // 返回生成的新物件
                cloneObj = (T) ois.readObject();
                ois.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return cloneObj;
        }

*/
