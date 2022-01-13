import java.util.Scanner;

class IdCardCheck{
    private String id;
    public int[] firstLetterNum = {
      10,11,12,13,14,
      15,16,17,34,18,
      19,20,21,22,35,
      23,24,25,26,27,
      28,29,32,30,31,33
    };
    public IdCardCheck(String id){
        this.id = id;
    }
    public boolean checkInput(){
        return id.matches("[A-Z][0-9]{9}");
    }//end checkInput()
    public boolean checkValid(){
        if(!checkInput() ){
            return false;
        }
        
        int checkNum = id.charAt(id.length() - 1) - '0',
            sum = 0;
        
        for(int i = 0; i < id.length() - 1; i ++){
           if(i == 0){
               int firstLetter = firstLetterNum[(id.charAt(0) - 'A')];
               sum += (firstLetter % 10) * 9;
               sum += (firstLetter / 10) * 1;
               
           }
           else{
               int num = id.charAt(i) - '0';
               sum += num * (id.length() - 1 - i);
           }
        }
        
        if( (sum % 10 != 0) && ( (sum % 10) == (10 - checkNum) ) ){
            return true;
        }
        else if( (sum % 10 == 0) && (checkNum == 0) ){
            return true;
        }
        else{
            return false;
        }
    }//end checkValid()
}// end class IDCardCheck

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userId = sc.nextLine();
        IdCardCheck idC = new IdCardCheck(userId);
        if(idC.checkValid()){
            System.out.print("這是有效的身分證字號!");
        }
        else{
            System.out.print("身分證字號輸入錯誤!");
        }
    }//end main()
}//end class Main
