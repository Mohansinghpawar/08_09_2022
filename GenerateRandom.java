import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;


public class GenerateRandom {

	public static void main(String[] args) 
	{
		Scanner scn=new Scanner(System.in);
		// math.random ->returns only 0-1
		// Random class -> to generate range values
		Set<String> otpObjTrue = new LinkedHashSet<>();
		Set<String> otpObj = new LinkedHashSet<>();

		Generator generator = () -> 
		{
			int generate = (int) (Math.random() * 1000000);
			String intoString = String.valueOf(generate);
			//System.out.println(s);
			return intoString;
		};
		System.out.println("Enter how many otp's do you want?");
		int inputOtp=scn.nextInt();
		while(inputOtp>0)
		{
			String otp1 = generator.generateOtp();
//			String otp2 = generator.generateOtp();
//			String otp3= generator.generateOtp();
//			String otp4 = generator.generateOtp();

			Predicator predicator = (otp) ->otp1.length() == 6;
			
			
			boolean status = predicator.check(otp1);
			//System.out.println(status);
			
			if(status==true)
			{
				otpObjTrue.add(otp1);
			}
			else
			{
				otpObj.add(otp1);
			}
			
			n--;
		}
		System.out.println("Six digit otp List"+otpDigit6);
		System.out.println("Except Six digit otp list "+otpDigit);

	}

}

interface Predicator {
	public abstract boolean check(String otp);
}

interface Generator {
	public abstract String generateOtp();
}
