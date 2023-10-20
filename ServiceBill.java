import java.util.Scanner;
public class ServiceBill {
			public static void main(String[] args) {
						Scanner input = new Scanner(System.in);
						
						//initialization
						int baseCharge = 50;
						int FreeMinutesReg = 50;
						int dayFree = 75;
						int nightFree = 100;
						int chargeRate = 5;
						
						//Account Number and Service you want 
						System.out.print("Enter Account Number: ");
						String AccountNum = input.next();
						System.out.println("Service Fee 50 Pesos");
						System.out.println("Select Service (5 Pesos Per Mins)");
						System.out.println(" R (Regular Free 50 mins)");
						System.out.println(" P (Premium Free 75 mins Day, 100 mins Night)");
						System.out.print("Input Here: ");
						//Use Char variable instead of String because 'R' and 'P' are single character
						char Service = input.next().charAt(0);
						//use Character.toLowerCase to ignore case sensitive
						Service = Character.toLowerCase(Service);
						
						//Regular Service Minutes and Bill Computations
						if (Service == 'r') { 
									System.out.print("Enter Minutes You Used: ");
									int Minutes = input.nextInt();
									int Charges = Minutes - FreeMinutesReg;
									int Bill = chargeRate * Charges + baseCharge;
									
									//OutPut for Regular Service
									System.out.println();
									System.out.println("****** Service Bill ******");
									System.out.println("Type of Service: Regular Service.");
									System.out.println("Account Number: " + AccountNum);
									System.out.println("Minutes of Telephone Service Used: " + Minutes);
									System.out.println("Ammount Due: " + Bill);
									
									//Premium Serivce Minutes and Bill Computations
						} else if (Service == 'p') {
									System.out.print("Enter Minutes Used During Day  : ");
						 int dayMins = input.nextInt();
						 System.out.print("Enter Minutes Used During Night: ");
						 int nightMins = input.nextInt();
								int dayCharge = chargeRate * (dayMins - dayFree);
						 int nightBill = chargeRate * (nightMins - nightFree);
						 int ammountDue = dayCharge + nightBill + baseCharge;
						
						 //Output for Premium Service
						 System.out.println();
						 System.out.println("****** Service Bill ******");
						 System.out.println("Type of Service: Premium.");
						 System.out.println("Account Number: " + AccountNum);
						 System.out.println("Minutes Used During Day : " + dayMins);
						 System.out.println("Minute Used During Night: " + nightMins);
						 System.out.println("Ammount Due: " + ammountDue);
					} else {
									System.out.print("Invalid Input Please Enter R or P ");
						}
									input.close();
			}
}