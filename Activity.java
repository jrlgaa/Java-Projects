import java.util.Scanner;
public class Activity {

	public static class Information {

		String Name;
		String Role;

		public Information(String Name, String Role) {
			this.Name = Name;
			this.Role = Role;

		}

		public void displayInformation () {
			System.out.println("\n--------------------------------------------------------------------------------------------");
			System.out.println("------------------------------------------------------------------------------------------------\n");
			System.out.println("\nLEADER INFORMATION\n");
			System.out.println("Name: " + Name);
			System.out.println("Role: " + Role);

		}
	}

	public static class Events {

		String Event;
		String Date;
		String Message;
		String said;

		public Events(String Event, String  Date, String Message, String said) {
			this.Event = Event;
			this.Date = Date;
			this.Message = Message;
			this.said = said;
		}

		public void displayEvents() {
			System.out.println("\nEVENT DETAILS\n");
			System.out.println("Event: " + Event);
			System.out.println("Date: " + Date);
			System.out.print("\nFamous Message: " + Message);
			System.out.println(" -" + said);
		}

	}
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.print("ENTER NAME: ");
		String name = input.nextLine();
		System.out.print("ENTER THIER ROLE: ");
		String role = input.nextLine();

		System.out.print("ENTER A SIGNIFICANT EVENT DURING EDSA: ");
		String event = input.nextLine();
		System.out.print("ENTER THE DATE OF THE EVENT: ");
		String date = input.nextLine();
		System.out.print("ENTER FAMOUS MESSAGE FROM EDSA: ");
		String message = input.nextLine();
		System.out.print("WHO SAID IT?: ");
		String whoSaid = input.nextLine();


		Information info = new Information(name,role);
		info.displayInformation();

		Events eve = new Events(event, date, message, whoSaid);
		eve.displayEvents();

		input.close();

	}
}