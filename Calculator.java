package calculator;
import java.util.Scanner;

public class Calculator {
	public static long calculator(long op1,long op2, String operator) {
		long result = op1;
		switch(operator) {
		case"+":
			result = op1 + op2;
			break;
		case"-":
			result = op1 - op2;
			break;
		case"*":
			result = op1 * op2;
			break;
		case"/":
			result = op1 / op2;
			break;
		default:
			System.err.println("Invalid operator,cannot perform the operation");
			break;
		}
		return result;
	}
	
	public static void main (String args [])
	throws Exception{
		try(Scanner operandScanner = new Scanner (System.in);
				Scanner actionScanner = new Scanner(System.in))
		{ while(true) {
			System.out.println("Welcome to Calculator,\n"
					+ " if you want to star type=>ON,\n "
					+ "if you want off type =>OFF \n "
					+ "if you want to exit type =>EXIT");
			System.out.println("*****************************************************************");
			String calculatorstatus = actionScanner.nextLine();
			System.out.println("__________________________________________"+calculatorstatus+"____________________________________");
            if("ON".equalsIgnoreCase(calculatorstatus)) {
            	long firstop=0;
            	long secondop=0;
            	String operator =null;
            	boolean  init = true;
            	int i=0;
            	while(i<10) {
            		if(init) {
            			firstop=operandScanner.nextLong();
            			operator=actionScanner.nextLine();
            			secondop=operandScanner.nextLong();
            			init = false;
            			}else {
            				System.out.println("Enter the operator:");
            				operator=actionScanner.nextLine();
            				System.out.println("Enter next value:");
            				secondop = operandScanner.nextLong();
            				}
            		firstop = calculator(firstop,secondop,operator);
            		System.out.println("=========>:"+firstop);
            		i++;
            	}
            }else if ("oFF".equalsIgnoreCase(calculatorstatus)) {
            	System.out.println("calculator");
            }else if ("EXIT".equalsIgnoreCase(calculatorstatus)) {
            	break;
            }else {
            	throw new Exception("Invalid Action");
            }
			
		}
			actionScanner.close();
			operandScanner.close();
		}
	}

}
