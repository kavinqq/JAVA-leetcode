import java.util.*;

public class SingleNumber1{
  public static void main(String[] argv){
      Scanner sc = new Scanner(System.in);
      HashMap<Integer , Integer> map = new HashMap<>();
      int size = sc.nextInt();
      int[] data = new int[size];
      for(int i = 0; i < size; i++){
          data[i] = sc.nextInt();
      }
    
      // 若map中已經有該數值 則刪除 沒有則加入
      for(int key : data){
          if(map.containsKey(key)){
              map.remove(key);
          }          
          else{
              map.put(key , 1);
          }
      }
      //map.entrySet會回傳一個Set物件，該物件內每個元素都是Map.Entry實例，可呼叫getKey() / getValue()
      for(Map.Entry<Integer , Integer> m : map.entrySet()){
          System.out.print(m.getKey());
      }
  }
}
