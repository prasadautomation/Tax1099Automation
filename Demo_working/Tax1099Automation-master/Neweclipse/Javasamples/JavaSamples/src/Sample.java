import java.awt.List;

public class Sample {

	public static void main(String args[]) {

		// ---------------------------------reverse string----------------------------//
		/*
		 * System.out.print("First sample program");
		 * 
		 * String name="Sridevi"; int length=name.length();
		 * 
		 * 
		 * 
		 * System.out.print("\n"+"Length of the name is:"+length);
		 * 
		 * for(int i=(length)-1;i>=0;i--) {
		 * 
		 * System.out.print("\n"+name.charAt(i)); }
		 */

		// -------------count the repetition of letters---------------//

		
	String name="iamsridevi";
	char[] nameletters=name.toCharArray();
	int length=nameletters.length;
	int flag=0;
	for(int i=0;i<length;i++) {
		
		System.out.print("\n"+"letter :"+i+" "+nameletters[i]);
		
		for(int j=i+1;j<length;j++) {
			
			System.out.print("\n"+"letter :"+j+" "+nameletters[j]);
			
		/*	if(nameletters[i]==nameletters[j]) {
				
				flag++;
				
			//	System.out.print("\n"+nameletters[j]+flag);
				
				
				
			}
			*/
					
		}
		//System.out.print("\n"+nameletters[i]+flag);
		// String d=String.valueOf(name.charAt(i)).trim();
		// name=name.replaceAll(d,"");
		
		
	} 
	
	
		  
		  
		  
		  
		  
	/*	char[] letters = { 'a', 'a', 'b', 'b', 'c', 'd', 'c', 'b' };
		int flag = 0;

		for (int i = 0; i < letters.length; i++) {

			// System.out.print(letters[i]);

			for (int j = 0; j < letters.length; j++) {

				if (letters[i] == letters[j]) {

					flag++;
				}

			}
			System.out.print("\n" + letters[i] + "--" + flag);
			flag = 0;

		}*/

	}
}
