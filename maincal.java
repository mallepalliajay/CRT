import java.util.*;
import java.io.*;
public class maincal{
    public static void main(String []args)
    {
        Scanner in =new Scanner(System.in);
        System.out.println("Enter the first number ");
        double num1=in.nextDouble();
        System.out.println("enter the operator (such as :+ ,_,%,*)");
        char operator = in.next().charAt(0);
        System.out.println("entert he second number");
        double num2=in.nextDouble();
        double result;
        switch(operator)
        {
            case '+':
             result =num1+num2;
             System.out.println("result:"+result);
             break;
            case '-':
             result =num1-num2;
             System.out.println("result:"+result);
             break;
            case '*':
             result =num1*num2;
             System.out.println("result:"+result);
             break;
            case '/':
             if (num2!=0){

              result =num1/num2;
              System.out.println("result:"+result);
             }
             else 
             {
                System.out.println("error: zero divide by error");
             } 
                break;
            default:
            {
                System.out.println("enter the vliad operator");
            }



        }
        in.close();
    }
    
   
}