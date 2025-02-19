import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner myObj = new Scanner(System.in);
        int N = myObj.nextInt(); 
        int C = myObj.nextInt();
        int P = myObj.nextInt();
        if(C * P >= N ){
            System.out.println("yes");         

        }
        else{
            System.out.println("no"); 
        }

    }
}
