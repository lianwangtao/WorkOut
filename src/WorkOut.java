import java.util.*;
import java.io.*;

import javax.swing.JOptionPane;


public class WorkOut {

	//variables
	static Scanner scan = new Scanner(System.in);
	static String filename = "Record.txt";
	static Calendar c = Calendar.getInstance();
	static Date date = c.getTime();
	static int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);	
	static BufferedWriter writer = null;

	public static void main(String[] args){

		//try if the file exists
		try{
			//read the file
			FileWriter file = new FileWriter(filename, true);
			// Always wrap FileWriter in BufferedWriter.
			writer = new BufferedWriter(file);

		}catch (IOException e) {
			//display error message
			System.out.println("Sorry there's something wrong with the file!");
			return;
		}

		//Welcome Message
		System.out.println("Welcome to WorkOut Recording!");

		//the Writing function
		writing(dayOfWeek);

	}

	private static String[] Other(int dayOfWeek) {

		//variables
		String[] info = new String[3];

		//determine the date
		switch(dayOfWeek){
		case 1: info[0] = "Sunday";
		break;
		case 2: info[0] = "Monday";
		break;
		case 3: info[0] = "Tuesday";
		break;
		case 4: info[0] = "Wednesday";
		break;
		case 5: info[0] = "Thursady";
		break;
		case 6: info[0] = "Friday";
		break;
		case 7: info[0] = "Saturday";
		break;
		}
		//Ask User for the primary and secondary exerise
		System.out.print("Select Today's Primary Exercise: 1) Bench Press 2) Shoulder Press 3) Squat 4) Deadlift ");
		switch(scan.nextInt()){
		case 1: info[1] = "Bench Press";
		break;
		case 2: info[1] = "Shoulder Press";
		break;
		case 3: info[1] = "Squat";
		break;
		case 4: info[1] = "Deadlift";
		break;
		}
		scan.nextLine();
		//Ask User for the secondary
		System.out.print("Select Today's Secondary Exercise: 1) Bench Press 2) Shoulder Press 3) Squat 4) Deadlift ");
		switch(scan.nextInt()){
		case 1: info[2] = "Bench Press";
		break;
		case 2: info[2] = "Shoulder Press";
		break;
		case 3: info[2] = "Squat";
		break;
		case 4: info[2] = "Deadlift";
		break;
		}

		return info;
	}



	private static void writing(int dayOfWeek) {
		//variables
		boolean normal = true;
		String day = null;
		String primary = null;
		String second = null;
		int firstSets = 0;
		int firstReps = 0;
		int firstMax = 0;
		int secondWeight = 0;
		int BodyWeight = 0;
		ArrayList<Integer> weights = new ArrayList<Integer>();

		//prompt user to choose if Today's normal schedule
		System.out.print("Is today according to the normal schedule? (Y)es or press any key for (N)o: ");
		char answer = scan.next().charAt(0);
		if (answer != 'y' ){
			normal = false;
		}

		//check if today's normal scheule
		if (!normal){

			String[] info  = Other(dayOfWeek);
			day = info[0];
			primary = info[1];
			second = info [2];	
			
		}else{

			//determine which day of the week 
			switch(dayOfWeek){

			case 2: day = "Monday";
			primary = "Shoulder Press";
			second = "Bench Press";
			break;
			case 3: day = "Tuesday";
			primary = "Squat";
			second = "Deadlift";
			break;
			case 5: day = "Thursday";
			primary = "Bench Press";
			second = "Shoudler Press";

			break;
			case 6: day = "Friday";
			primary = "Deadlift";
			second = "Squat";
			break;

			}
		}
		boolean isNumber = false;


		//prompt 
		System.out.println("Today is " + day);
		System.out.println("Today's date is " + date);
		//see if the user entered a number
		while(!isNumber){
			try {
				scan.nextLine();
				//Ask for SETS
				System.out.print("The number of SETS of " + primary +" I've done: ");
				firstSets = Integer.parseInt(scan.nextLine());
				//ASK for REPS
				System.out.print("Nice! The number of REPS of " + primary +" I've done: ");
				firstReps = Integer.parseInt(scan.nextLine());
				//Ask for the weight for each set
				for (int i = 1; i <= firstSets; i ++){
					System.out.print("What weight did you do for the SET " + i + " : " );
					weights.add(scan.nextInt());
				}
				//Ask for Max
				System.out.print("Awesome! My max is: ");
				firstMax = scan.nextInt();

				//Ask for 5 X 10
				System.out.print("The weight you use for 5 by 10 "+ second +" is: ");
				secondWeight = scan.nextInt();

				//Ask for body weight
				System.out.print("At last, my body weight is: ");
				BodyWeight = scan.nextInt();

				isNumber = true;
			} catch (NumberFormatException e) {
				System.out.println("Please Enter a number!");
			}
		}
		//write into file
		try {
			writer.append("Date: " + date);
			writer.newLine();
			writer.append(primary +" for " + firstSets + " sets of " + firstReps + " reps on weight: " );
			Iterator<Integer> itr = weights.iterator();
			while (itr.hasNext()){
				writer.append(itr.next() + " ");
			}
			writer.newLine();
			writer.append("The Max on " + primary + " is " + firstMax);
			writer.newLine();
			writer.append( second  + " for 5 sets of 10 on weight" + secondWeight);
			writer.newLine();
			writer.append("Body weight is " + BodyWeight);
			writer.newLine();
			writer.write("-----------------------------------------------------------------------");
			writer.newLine();
			writer.close();

			System.out.println("Writing Complete! Thank you! Goodbye!");


		} catch (IOException e) {
			//display the error
			System.out.println("Sorry there's something wrong while writing the file!");
		}



	}
}
