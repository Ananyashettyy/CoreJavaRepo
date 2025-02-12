public class reverseSum{
	public static void main(String args[]){
		int num,rem;
		int rev=0,sum=0;
		num=123;
		do {
			rem=num % 10;
			rev= rev * 10 +rem;
			sum= sum + rem;
			num=num/10;
		}while(num>0);
		System.out.println("The reverse of the number is "+rev);
		System.out.println("The sum of the number is "+sum);
	}
}

