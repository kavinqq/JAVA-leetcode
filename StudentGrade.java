import java.util.*;

class Student implements Comparable<Student> {
    int number , grade;
    
    public Student(int number , int grade){
        this.number = number;
        this.grade = grade;
    }
    public String toString(){
        return number+"."+grade;
    }
    @Override
    public int compareTo(Student st){
        return this.grade-st.grade;
    }
}


public class Main{
    public static void main(String[] argv){
        Scanner sc = new Scanner(System.in);
        List<Student> stu = new ArrayList<Student>();
        int number=1, grade, orderBy;   
        
        //輸入資料 -1跳出
        while(true){
            grade = sc.nextInt();
            if(grade == -1)
                break;
            stu.add(new Student(number++, grade));
        }
        //輸入排序方法
        orderBy = sc.nextInt();
        
        //由小到大
        if(orderBy == 1){
            Collections.sort(stu);
            for(Student s : stu)
                System.out.println(s);
        }
        //由大到小
        else{
            Collections.sort(stu);
            Collections.reverse(stu);
            //處理相同成績的狀況→把號碼由小到大print
            for(int i = 0; i < stu.size(); ){
                //tmp_i 為 相同成績的最後一個index , move為此輪for i移動格數
                int move = 1, tmp_i = i+1;
                while(tmp_i != stu.size() && stu.get(i).grade == stu.get(tmp_i).grade){
                    tmp_i++;
                    move++;
                }//end while
                //tmp_i 減去最後的為false的++
                tmp_i -= 1;
                //print到當前i
                while(tmp_i >= i){
                    System.out.println(stu.get(tmp_i));
                    tmp_i--;
                }
                i += move;
            }//end for
        }//end else
    }
}
