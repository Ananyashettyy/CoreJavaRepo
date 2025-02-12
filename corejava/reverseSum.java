import java.util.Scanner;
public class reverseSum{
	public static void main(String args[]){
		int num,rem;
		int rev=0,sum=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the number");
		int num=sc.nextInt();
		while(num>0) {
			rem=num % 10;
			rev= rev * 10 +rem;
			sum= sum + rem;
			num=num/10;
		}
		System.out.println("The reverse of the number is "+rev);
		System.out.println("The sum of the number is "+sum);
	}
}

