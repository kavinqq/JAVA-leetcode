import java.util.*;

public class Main{
    public static void main(String[] argv){
       Scanner sc = new Scanner(System.in);
       HashMap<Integer, Integer> checkMap = new HashMap<>();
       ArrayList<Integer> aList = new ArrayList<>();
       int inputTimes = sc.nextInt();
       while(inputTimes-- > 0){
           int num = sc.nextInt();
           if(!checkMap.containsKey(num)){
               checkMap.put(num, 1);
               aList.add(num);
           }
           else{
               if(aList.contains(num)){
                   for(int i = 0; i < aList.size(); i++){
                       if(num == aList.get(i)){
                           aList.remove(i);
                           break;
                       }
                   }
               }
           }
       }// end while
       if(aList.size() == 0){
           System.out.print("找不到非重複元素");
       }
       else{
           for(int i = 0; i < aList.size(); i++){
               if(i == 0){
                    System.out.print(aList.get(i));
               }
               else{
                   System.out.print(" " + aList.get(i));
               }
           }
       }// end else
   }
}
