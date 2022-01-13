/*  題目 : 求出外觀數列1~9層
第一層  1
第二層  11     由於上一層是1個1 
第三層  21     由於上一層是2個1 
第四層  1211   由於上一層是1個2 和 2個1
...


注意的點:  
由於第9層的數字會大於 int 記得要用long去做

想法:
數字 兩兩一組  一個該數數量 一個該數 
*/
import java.util.Scanner;

public class Main{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int len = sc.nextInt();
    long currentNum = 0,
         times = 0,    	
    	   data = 1;
    	 
    for(int i = 1; i <= len ; i++){      
      long digitLeftMove = 1,  //位元左移 * 10   每一層重置
           tmpData = data;     //tmpData 暫存 data現在的值 用來計算 
      
      times = 0; //上一個找的數字 數量歸零
      data = 0; // data的值已經被記錄，data歸零 當成 sum用
      // 像fibonacci數列一樣 要有個開頭  1 
      if(i == 1){
        data = i;
      }      
      else{
        //算到tmpData == 0 
        while(tmpData > 0){
          // 把尾巴抓出來 該數為 現在要計算次數的數
          currentNum = tmpData % 10;
          // 該數本身就是一次 要 + 1
          times++;
          // 抓出來後 tmpData右移(往前推算)
          tmpData /= 10;          
          // 如果 還有數字 && 這個數字 和目前要計算數量的數一樣 次數++ 再往前找
          while(tmpData > 0 && tmpData % 10 == currentNum){            
            times++;
            tmpData /= 10;
          }
          /* 前面想法提到的 兩兩一組  一個該數數量 一個該數  到這邊就找完一組了
             digitLeftMove(左移) 預設為1 為每層第一個數的位置 
             接著 dLM * 10  放 他的數量
             到此 一組數 找完&放完了 
             如果tmpData還沒完 就再找一次
          */
          data += currentNum * digitLeftMove;
          digitLeftMove *= 10;
          data += times * digitLeftMove;
          digitLeftMove *= 10;          
        }
      }//end else      
      System.out.println(data);
    }//end for()
  }//end main()
}//end class Main
