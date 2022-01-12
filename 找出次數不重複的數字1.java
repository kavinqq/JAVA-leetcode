import java.util.Scanner;

public class Main{
    public static void main(String[] argv){
        Scanner sc = new Scanner(System.in);
        int outputTime = 0,
            inputTimes = sc.nextInt(),
            nonRepeatedInput = 0;
            
        boolean find = false,
                hasZero = false;
        int[][] store = new int[inputTimes][2];
        
        while(inputTimes-- > 0){
            int num = sc.nextInt();
            find = false;
            if(num == 0 && hasZero == false){
                store[nonRepeatedInput++][1] += 1;
                hasZero = true;
            }
            else{
                for(int i = 0; i < nonRepeatedInput; i++){
                    if(store[i][0] == num){
                        find = true;
                        store[i][1]++;
                        break;
                    }
                }
                if(!find){
                    store[nonRepeatedInput][0] = num;
                    store[nonRepeatedInput++][1] += 1;
                }
            }
        }
        
        for(int i = 0; i < nonRepeatedInput; i++){
            if(store[i][1] == 1){
                outputTime += 1;
                System.out.print(store[i][0]);
                if(i + 1 != nonRepeatedInput){
                    System.out.print(" ");
                }
            }
        }
        
        if(outputTime == 0){
            System.out.print("找不到非重複元素");
        }
   }
}
