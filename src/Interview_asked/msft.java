package Interview_asked;

public class msft {
//	Hi Vinay
//	Hi Javier

//
//	Function to return the addition of 2 numbers:
//
//	Input:  number1 and number2
//	        Format number1 = “134” and number2 = “456”
//	Output:  “590”.


	public String addNumbers(String n11, String n22) {

		String n1 = "1345";
		String n2 =   "456";

	int len1 = n1.length(); //3
	int len2 = n2.length(); //3
	int len;
	if (len1 > len2) {
	len = len1-1;
	}  else {
	len = len2-1;
	}
	//StringBuilder res;
	System.out.println("len: " + len);
	char[ ] res = new char[len+1];

	int sum, cf =0;

	 while (len1 != 0 && len2 !=0) {
		 sum =0;
		int i1 = n1.charAt(len1-1);// - ‘ ’; // 5 4 3

	int i2 = n2.charAt(len2-1);// - ‘ ‘ ; //6  5 4 
		
		sum = i1 +i2 + cf; // 11    10 8
		cf = sum /10; // 1       1 0
		sum = sum %10; // 1   0 8

		System.out.println("len: " + len);
	res[len--]  = (char)sum;  //  		801
	len1--;
	len2--;
	}

	if (len1 > len2) {
		System.out.println("len1: " + len1);
		while(len1 >0) {
			sum = 0;
			System.out.println("len1: " + len1);
			System.out.println(n1.charAt(len1-1));
			int i1 = n1.charAt(len1-1) - '0';// - ;// - ‘ ’; // 1
			System.out.println(" i1 " + i1);
			sum = i1 + cf; // 1
			cf = sum /10; //0
			sum = sum %10; // 1

			res[len--]  = (char)sum;   //  1801
			
			len1--;
		} 
	} else {
		while(len2-- >0) {
			sum =0;
			int i2 = n2.charAt(len2-1);// - ‘ ‘ ; 
			sum = i2 + cf;
			cf = sum /10;
			sum = sum %10; // 4
			res[len--]  = (char)sum; 
		}
	}
	
	for(int i : res) {
		System.out.println(i);
	}
	return res.toString();  // “1801”
	}

	public static void main(String[] args) {
		msft ob = new msft();
		System.out.println(ob.addNumbers("", ""));
		
	}

}
