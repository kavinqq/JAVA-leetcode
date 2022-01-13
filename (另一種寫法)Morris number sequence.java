/*
學到String的各種方法後來複習 :

比之前的寫法容易懂
但是要先知道 
StringBuilder類別
StringBuilder的 .append() / .insert()
String 的   .toCharArray() 
的運用
*/
import java.util.Scanner;

public class Main{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int layer = sc.nextInt();
    String output = "1";
    for(int i = 1; i <= layer; i ++){
        if(i != 1){
            char[] data = output.toCharArray();
            StringBuilder result = new StringBuilder();
            int times = 1;
            for(int j = 0; j < data.length; j ++){
                if(j + 1 == data.length){
                    result.append(times);
                    result.append(data[j]);
                    break;
                }
                if(data[j] == data[j + 1]){
                    times++;
                }
                else{
                    result.append(times);
                    result.append(data[j]);
                    times = 1;
                }
            }
            output = result.toString();
        }
        System.out.println(output);
    }//end for
  }//end main()
}//end class Main
