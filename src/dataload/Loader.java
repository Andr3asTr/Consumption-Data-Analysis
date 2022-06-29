package dataload;

import java.util.ArrayList;
import datamodel.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Loader implements ILoader<MeasurementRecord>{

	private ArrayList<MeasurementRecord> objCollection;

	@Override
	public int load(String fileName, String delimeter, boolean hasHeaderLine, int numFields, ArrayList<MeasurementRecord> objCollection) {
		if (numFields < 1){
			System.out.println("Wrong number of fields, less than 1!");
			System.exit(0);		
		}
		//Opening files for read and write, checking exception
		Scanner inputStream = null;
		try {
			inputStream = new Scanner(new FileInputStream(fileName));

		} catch (FileNotFoundException e) {
			System.out.println("Problem opening file: " + fileName);
			System.exit(0);
		}
		
		this.objCollection = objCollection;
		int count = 0;

		
		String line = "";
		
		if(hasHeaderLine){
			line = inputStream.nextLine();
			count ++;
		}
		
		//process the actual rows one by one
		while (inputStream.hasNextLine()) {
			line = inputStream.nextLine();
			//System.out.println(line);
			count ++;
			String[] items = line.split(delimeter);
			if(items.length != 9)
			{
				System.out.println("Wrong Input format in file " + fileName +". I found " + items.length + " values, but I expect " + numFields +" values per row!");
				//System.exit(0);
			}
			else if(items.length == 9)
			{
				String[] tempDate = items[0].split("/");
				String[] tempTime = items [1].split(":");
				if(tempDate.length != 3 || tempTime.length != 3)
				{
					System.out.println("Wrong Input format in file " + fileName);
					continue;
				}
				else
				{
					if(tempTime[0].equals("00"))
					{
						tempTime[0] = "0";
					}
					else if(tempTime[0].equals("01"))
					{
						tempTime[0] = "1";
					}
					else if(tempTime[0].equals("02"))
					{
						tempTime[0] = "2";
					}
					else if(tempTime[0].equals("03"))
					{
						tempTime[0] = "3";
					}
					else if(tempTime[0].equals("04"))
					{
						tempTime[0] = "4";
					}
					else if(tempTime[0].equals("05"))
					{
						tempTime[0] = "5";
					}
					else if(tempTime[0].equals("06"))
					{
						tempTime[0] = "6";
					}
					else if(tempTime[0].equals("07"))
					{
						tempTime[0] = "7";
					}
					else if(tempTime[0].equals("08"))
					{
						tempTime[0] = "8";
					}
					else if(tempTime[0].equals("09"))
					{
						tempTime[0] = "9";
					}
					MeasurementRecord record = new MeasurementRecord(items[0], items[1], items[2], items[3], items[4], items[5], items[6], items[7], items[8]);
					this.objCollection.add(record);
				}
			}
		}
		inputStream.close();
		System.out.println("Processed " + count + " rows and loaded " + this.objCollection.size() + " objects.");
		return count;
	}
	
	public ArrayList<MeasurementRecord> readFile()
	{
		return this.objCollection;
	}

}
