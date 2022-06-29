package client;

import mainengine.*;
import dataload.*;

import java.util.ArrayList;
import java.util.Scanner;

import datamodel.*;

import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		String header;
		boolean bHeader = false;
		int errorlight;//checks if the engine returns error
		ArrayList<String> reportHistory = new ArrayList<String>();
		String keepgoing;//continue making aggregate results
		String path;
		String delimeter;
		String reportPath;//the path where the report will be created
		String reportType;
		String description;
		String showReportHistory;
		String aggregationType;
		String avgsum = "";
		Scanner input1 = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);
		Scanner input3 = new Scanner(System.in);
		Scanner input4 = new Scanner(System.in);
		Scanner input5 = new Scanner(System.in);
		Scanner input6 = new Scanner(System.in);
		Scanner input7 = new Scanner(System.in);
		Scanner input8 = new Scanner(System.in);
		Scanner input9 = new Scanner(System.in);
		Scanner input10 = new Scanner(System.in);
		Scanner input11 = new Scanner(System.in);
		while(true)
		{
			
			System.out.println("When numbered options are provided to answer the question type the number that corresponds to your choice.");
			System.out.println("Put the file path you want to load");
			path = input1.nextLine();
			System.out.println("Set the delimeter");
			delimeter = input2.nextLine();
			while(true)
			{
				System.out.println("Does the file have a header line?");
				System.out.println("1.   Yes");
				System.out.println("2.   No");
				System.out.println("3.   Exit Program");
				header = input3.nextLine();
				if(header.equals("1"))
				{
					bHeader = true;
					break;
				}
				else if(header.equals("2"))
				{
					bHeader = false;
					break;
				}
				else if(header.equals("3"))
				{
					System.out.println("The program will now exit");
					System.exit(0);
				}
			}
			System.out.println("");
			System.out.println("Set the number of fields");
			int numFields = input4.nextInt();
			ArrayList<MeasurementRecord> record = new ArrayList<MeasurementRecord>();
			MainEngine engine = new MainEngine();
			engine.loadData(path, delimeter, bHeader, numFields, record);
			record = engine.getReadData();
			System.out.print("\n");
			
			while(true)
			{
				System.out.println("What type of data date aggregation do you want?");
				System.out.println("1.   Aggregate per season");
				System.out.println("2.   Aggregate per month");
				System.out.println("3.   Aggregate per week day");
				System.out.println("4.   Aggregate per period of day");
				System.out.println("5.   Exit Program");
				aggregationType = input5.nextLine();
				if(aggregationType.equals("1"))
				{
					aggregationType = "season";
					break;
				}
				else if(aggregationType.equals("2"))
				{
					aggregationType = "month";
					break;
				}
				else if(aggregationType.equals("3"))
				{
					aggregationType = "day of week";
					break;
				}
				else if(aggregationType.equals("4"))
				{
					aggregationType = "period of day";
					break;
				}
				else if(aggregationType.equals("5"))
				{
					System.out.println("The program will now exit");
					System.exit(0);
				}
			}
			System.out.println("");
			
			while(true)
			{
				System.out.println("What type of data aggregation do you want?");
				System.out.println("1.   Avg");
				System.out.println("2.   Sum");
				System.out.println("3.   Exit Program");
				avgsum = input6.nextLine();
				if(avgsum.equals("1"))
				{
					avgsum = "avg";
					break;
				}
				else if(avgsum.equals("2"))
				{
					avgsum = "sum";
					break;
				}
				else if(avgsum.equals("3"))
				{
					System.out.println("The program will now exit");
					System.exit(0);
				}
			}
			System.out.print("\n");
			System.out.println("Enter a description for the results");
			description = input7.nextLine();
			if(description.equals("\n"))
			{
				System.out.println("Please enter a description or the program will exit");
				System.out.println("");
				description = input7.nextLine();
				if(description.equals("\n"))
				{
					System.out.println("The program will now exit");
					System.exit(0);
				}
			}
			
			System.out.println("");
			Result result = new Result();
			result = (Result) engine.aggregateByTimeUnit(record, aggregationType, avgsum, description);
			while(true)
			{	
				System.out.println("What type of report do you want?");
				System.out.println("1.   Text");
				System.out.println("2.   Markdown");
				System.out.println("3.   Html");
				System.out.println("4.   Exit Program");
				reportType = input8.nextLine();
				if(reportType.equals("1"))
				{
					reportType = "text";
					break;
				}
				else if(reportType.equals("2"))
				{
					reportType = "md";
					break;
				}
				else if(reportType.equals("3"))
				{
					reportType = "html";
					break;
				}
				else if(reportType.equals("4"))
				{
					System.out.println("The program will now exit");
					System.exit(0);
				}
			}
			while(true)
			{
				System.out.println("Enter the path where you want the report to be created");
				System.out.println("");
				reportPath = input9.nextLine();
				if(reportPath != null)
				{
					break;
				}
			}
			System.out.println("");
			errorlight = engine.reportResultInFile(result, reportType, reportPath);
			if(errorlight == -1)
			{
				System.out.println("Something went wrong with the file path you provided");
				System.exit(0);
			}
			reportHistory.add(reportPath);
			while(true)
			{
				System.out.println("Do you want to see the report history?");
				System.out.println("1.   Yes");
				System.out.println("2.   No");
				showReportHistory = input10.nextLine();
				if(showReportHistory.equals("1"))
				{
					for(int i=0; i<reportHistory.size(); i++) 
					{	
						System.out.println(reportHistory.get(i));
					}
					break;
				}
				else if(showReportHistory.equals("2"))
				{
					break;
				}
				System.out.println("");
			}
			System.out.println("");
			while(true)
			{
				System.out.println("Do you want to create another aggregate result file?");
				System.out.println("1.   Yes");
				System.out.println("2.   No");
				keepgoing = input11.nextLine();
				if(keepgoing.equals("1"))
				{
					break;
				}
				else if(keepgoing.equals("2"))
				{
					System.out.println("The program will now exit");
					System.exit(0);
				}
				System.out.println("");
			}
			System.out.println("\n");
		}
		
	}

}
