import java.util.Scanner;

class GCDandPrime{
    //找GCD的遞迴
    public int gcd(int numA, int numB){
        if(numA % numB == 0)
            return numB;
        else{
            return this.gcd(numB , numA % numB);
        }
    }
    //找質數
    public boolean isPrime(int n){
        boolean ans = true;
        if(n != 2 || n != 3){
            for(int i = 2; i<=n/2; i++){
                if(n % i == 0){
                    ans = false;
                    break;
                }
            }
        }
        return ans;
    }
}
public class Main{
    public static void main(String[] argv){
        Scanner sc = new Scanner(System.in);
        GCDandPrime gcdP = new GCDandPrime();
        int data = sc.nextInt(), gcd = 0, output_gcd;
        while(data != -1){
            gcd = gcdP.gcd(gcd, data);
            data = sc.nextInt();
        }//end while
        String ans = "1^1";
        output_gcd = gcd;
        for( int i = 2; i < output_gcd; i++){
            //如果i是質數則運算
            if(gcdP.isPrime(i))
            if(gcdP.isPrime(i)){
                int times = 0;
                //若gcd有此質因數，則計算有幾個
                while(gcd % i == 0){
                    gcd /= i;
                    times += 1;
                }
                if(times != 0)
                    ans += "*"+i+"^"+times;
            }//end if
        }//end for
        System.out.print(output_gcd+"="+ans);
    }
}
