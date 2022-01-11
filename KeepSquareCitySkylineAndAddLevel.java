/*先前做過的題目 改良版
  這次用兩個陣列 rowMax 和 colMax 再輸入city高度時就先抓出 行列高，
  就不需要再輸入完後，每個值再每次行列尋找。
  
  需要注意的點:
  1.colMax 記得是用 內層for的index來做比較索引 
    因為 要比較的是 city[0][0] / 1 0 / 2 0 / 3 0  是以" 行 " 為區隔
    
  2.想到第一次看到題目想了很久  citySkyline 要以人站在這個長條圖前去想
  
     人 ↓ 看的方向
    -----                                                       |建 |
   '     '                                                   |建|築 |
   '     '  人 ← 看的方向   建築物的上高那條線    示意圖 →  |建A| B| C |  
   '-----'                                                     人↑  此時看到的citySkyline 會是一個階梯形狀 
   
     人 ↑ 看的方向    
    
*/
import java.util.Scanner;

public class Main{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt(),
    	addLevel = 0;
    int[] rowMax = new int[size];
    int[] colMax = new int[size];
    int[][] city = new int[size][size];
    //將城市的高度輸入到陣列 並同時 抓取行列最大值
    for(int i = 0; i < size; i++){      
      for(int j = 0; j < size; j++){        
        city[i][j] = sc.nextInt();
        //再輸入時 就去抓出 行列最大值 以供後續加蓋比對
        rowMax[i] = (rowMax[i] > city[i][j]) ? rowMax[i] : city[i][j];
        //行要用j 來當index  因為一樣的的列中 要分size種儲存狀況
        colMax[j] = (colMax[j] > city[i][j]) ? colMax[j] : city[i][j];
      } // end for in 12
    } // end for in 11
    
    for(int i = 0; i < size ; i++){
      for(int j = 0 ; j < size; j++){
        //行最高 和 列最高 相比 取較小者 → 此值為不破壞city skyline的最高高度 (切齊)
        int max = (rowMax[i] > colMax[j]) ? colMax[j] : rowMax[i];
        if(city[i][j] < max){
          addLevel += max - city[i][j];
        }          
      }//end for in 22      
    }//end for in 21
    
    System.out.print(addLevel);
  }
}
