import java.util.*;
/*
    非常厲害的寫法,利用XOR的特性將題目速解
    A XOR B → AB相同則為 0
    依此類推
    A XOR B XOR C ...→ 若只有一個不同，則會變成 0 XOR 不同的數 → 答案
    補充:
    RAID 5 同位元也是利用XOR概念  ABC 一個硬碟儲存XOR後的BIT 若A損壞 則用完好的B和C可推出A的位元
*/
public class SingleNumber2{
  public static void main(String[] argv){
      Scanner sc=new Scanner(System.in);
      int size=sc.nextInt();
      int answer=0,input;
      for(int i=0;i<size;i++){
          input=sc.nextInt();
          answer^=input;
      }
      System.out.print(answer);
  }
}
