
public class Revesrestring {
	
	public static String main(String args[]) {
	
	String name="Sridevi";
	char ch[]=name.toCharArray();
	int length=name.length();
	String reversename="";
	
	for(int i=length-1;i<=0;i--) {
		
		reversename+=ch[i];
		
		
	}
	return reversename;

}}
