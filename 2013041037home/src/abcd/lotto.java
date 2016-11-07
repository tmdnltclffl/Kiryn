package abcd;


import java.util.Random;
import java.util.Arrays;

public class lotto {
	static int [] arr = new int[6];

	
	public static void lotto(){
		Random r1 = new Random(System.currentTimeMillis());
		for(int i=0; i<6; i++)
		{
			arr[i]=r1.nextInt(45)+1;
			for(int j = 0; j < i; j++)
			{
	            if (arr[i] == arr[j]) {
	                 i--;
	                 break;
	            }
	         }
		}
		Arrays.sort(arr);// sort
		lottogui a = new lottogui(arr);
	}
}
