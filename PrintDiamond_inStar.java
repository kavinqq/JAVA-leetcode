public class Main{
    public static void main(String[] argv){
        int height = 9, width = 9, starSize = 1;
        for(int i = 1; i <= height; i++){
            int space = 0;
             /*starSize初始化為1 每層+2   *
                                        ***
                                       *****
            */
            if(i > 1 && i <= 5)
                starSize += 2;
            else if( i > 5)
                starSize -= 2;
             //空白= 寬減去星號數 ， 再/2分為 * 左和右邊                            
            space = (width - starSize) / 2;
            for(int j = 1; j <= width; j++){
                //若 i=5 菱形正中間那列 則無需考慮空格
                if(i == 5)
                    System.out.print("*");
                else {
                    /*寬度起點 + 空白數 = 星號起點 ， 總寬度 - 空白數 = 星號終點
                    index: 123456789                     
                           0000*0000   space = (9 - 1) / 2 = 4, [1 + space = 5, 9 - space = 5]
                           000***000
                    */
                    if( j >= 1 + space && j <= width - space)
                        System.out.print("*");
                    else
                        System.out.print(" ");
                }
            }// end of inner for
            System.out.println();
        }//end of for
    }
}
