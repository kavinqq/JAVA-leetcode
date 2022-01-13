/* 複習
21
engineertrainengineer
14
engineer train  
↑ true

8
rainigee
10
rain nigee
↑ false
*/
import java.util.Scanner;

public class Main{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int str1Len = sc.nextInt();
    sc.nextLine();
    String str1 = sc.nextLine();
        
    int str2Len = sc.nextInt();
    sc.nextLine();
    String str2 = sc.nextLine();         
    String[] dict = str2.split(" ");
    boolean ans = false;
    
    for(int i = 0; i < str1Len; ){   
      int tmpIndex = i;
      for(String s: dict){
        if(str1.indexOf(s, tmpIndex) == i){
          tmpIndex += s.length();
        }        
      }
      if(tmpIndex == str1Len){
          ans = true;
          break;
      }
      else if(tmpIndex == i){
        ans = false;
        break;
      }
      else{
        i = tmpIndex;
      }
    }//end for()
    if(ans)
    	System.out.print("true");
    else
        System.out.print("false");
  }//end main()
}//end class Main
