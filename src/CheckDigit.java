
import java.util.Scanner;

public class CheckDigit {

	public static void main(String[] args){
	System.out.println("Enter the sixteen digit credit card number with no spaces or hyphens for verification: ");
    Scanner ccNo = new Scanner(System.in);
    String stringNo = ccNo.next();
	typeCheck(stringNo);
	numberCheck(stringNo);
	
	
	}
	
    public static boolean typeCheck(String stringNo){
    if(stringNo.charAt(0)==4){
    	String cardType = "Visa";
    	return true;
    }
    else if(stringNo.charAt(0)==5){
        	String cardType = "MasterCard";
        	return true;
    }   	
    else if(stringNo.charAt(0)==6){
    	String cardType = "Discover";
    	return true;
}   	
    else if((stringNo.charAt(0)==3) && (stringNo.charAt(1)==7)){
    	String cardType = "AmEx";
    	return true;
}   	
    else{
    	System.out.println("This card is fake");
    	return false;
    }
    }

    
    
 public static boolean numberCheck(String stringNo){
	 int[] even_list; 
	 even_list=new int[8];
	 int[] odd_list; 
	 odd_list=new int[8];
	 
    for(int i = 0;i < stringNo.length(); i= i+2){
    	int number = stringNo.charAt(i);
    	even_list[i] = number;
    }	
	 
    for(int i = 1;i < stringNo.length(); i= i+2){
    	int number = stringNo.charAt(i);
    	odd_list[i] = number;
    }	
    int[] new_even_list;
    new_even_list = new int[4];

    Integer[] new_odd_list;
    new_odd_list = new Integer[4];

    for(int n = 1; n < 8; n = n+2){
    	int i = 0;
    	new_even_list[i] = even_list[-n] + even_list[-n-1];
    	i = i + 1;
    }
    
    for(int n = 1; n < 8; n = n+2){
    	int i = 0;
    	new_odd_list[i] = odd_list[-n] + odd_list[-n-1];
    	i = i + 1;
    }
    
    for(int n:new_odd_list){
    	if(new_odd_list[n]>=10){
    		new_odd_list[n] = new_odd_list[n]%10 + new_odd_list[n]/10;
    	}
    }
    for(int n:new_even_list){
        	if(new_even_list[n]>=10){
        		new_even_list[n] = new_even_list[n]%10 + new_even_list[n]/10;
        	}

    	}
    int total1 = 0;
    int total2 = 0;
    for(int n:new_odd_list){
    	total1+=new_odd_list[n];
    	
    	}
    for(int n:new_even_list){
    	total2+=new_even_list[n];
    	
    	}
    total1+=total2;
    
    if(total1%10==0){
    	return true;
    }
    else{
    	return false;
    }
    }
}

 