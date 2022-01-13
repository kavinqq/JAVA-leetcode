/*
學到 String 的各種方法
拿以前的題目來重寫

注意的點:
1.sc.nextInt() 後緊接 sc.nextLine() 會讀不到， .nextInt() 沒有換行的功能!!
2.String 的 方法中  參數作為結束index 都是 一到就結束  (int start, int end)→ start ~ (end - 1)
*/
import java.util.Scanner;

public class Main{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int strLen = sc.nextInt(),
    	lastSpaceIndex;
    sc.nextLine();
    String str = sc.nextLine();
    lastSpaceIndex = str.lastIndexOf(' ');
    String ansStr = str.substring(lastSpaceIndex + 1, strLen);
    System.out.print(ansStr.length());
  }
}
