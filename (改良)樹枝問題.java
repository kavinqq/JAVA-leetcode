/*
若樹枝起始
為  1  則 沒有分支     加自己共 1
為  2  則 有2個1的分支 加自己共 3
為  3  則 有3個2的分支 加自己共 10
...

得到規律為
1 = 1
2 = 樹枝2 * 1 + 1
3 = 樹枝2 * 3 + 1
...
*/
import java.util.Scanner;

public class Main{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int first = sc.nextInt(),
    	result = 0;
    int[] store = new int[10];    
    for(int i = 0; i < first; i ++){
      if(i == 0){
        store[i] = 1;
      }
      else{
        int tmp = store[i - 1] * (i + 1);
        store[i] = tmp + 1;
      }
      result = store[i];
    }   
    System.out.println(result);
  }//end main()
}//end class Main
