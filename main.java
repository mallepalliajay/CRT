import java.util.Scanner;

import javax.xml.soap.SOAPElement;

public class main
{
	public static void main(String[] args){

		Scanner s=new Scanner(System.in);
            int[] arr=new int[5];
            for(int i=0;i<arr.length;i++)
            {
                  arr[i]=s.nextInt();
            }
            int max=0;
            int min=999;
            for(int i=0;i<arr.length;i++)
            {
                  if(arr[i]<min)
                  {
                        min=arr[i];
                  }
                  if(arr[i]>max)
                  {
                        max=arr[i];
                  }
            }
            System.out.println("max element is "+max);
            System.out.println("min element is "+min);
	}
}