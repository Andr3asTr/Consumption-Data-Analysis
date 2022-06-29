package timeaggregation;

import java.util.ArrayList;

import datamodel.Result;
import datamodel.IResult;
import datamodel.MeasurementRecord;

public class Aggregator implements IAggregator{

	private String place;
	private String timeUnit;
	
	public Aggregator(String place, String timeUnit)
	{
		this.place = place;
		this.timeUnit = timeUnit;
	}
	
	@Override
	public IResult aggregateByTimeUnit(ArrayList<MeasurementRecord> inputMeasurements, String aggFunction, String description) {
		if(place.equals("Kitchen"))
		{
			if(aggFunction.equals("sum"))
			{
				double sum = 0;
				for(int i=0; i<inputMeasurements.size(); i++)
				{
					sum = sum +	inputMeasurements.get(i).getSubMetering1();
				}
				Result temp = new Result("Kitchen", sum);
				return temp;
			}
			else if(aggFunction.equals("avg"))
			{
				double avg = 0;
				double sum = 0;
				int itemNumber = 0;//number of items in the arraylist
				for(int i=0; i<inputMeasurements.size(); i++)
				{
					sum = sum +	inputMeasurements.get(i).getSubMetering1();
					itemNumber ++;
				}
				if(sum == 0) {}
				else
				{
					avg = sum / itemNumber;
				}
				Result temp = new Result("Kitchen", avg);
				return temp;
			}
		}
		else if(place.equals("Laundry"))
		{
			if(aggFunction.equals("sum"))
			{
				double sum = 0;
				for(int i=0; i<inputMeasurements.size(); i++)
				{
					sum = sum +	inputMeasurements.get(i).getSubMetering2();
				}
				Result temp = new Result("Laundry", sum);
				return temp;
			}
			else if(aggFunction.equals("avg"))
			{
				double avg = 0;
				double sum = 0;
				int itemNumber = 0;//number of items in the arraylist
				for(int i=0; i<inputMeasurements.size(); i++)
				{
					sum = sum +	inputMeasurements.get(i).getSubMetering2();
					itemNumber ++;
				}
				if(sum == 0) {}
				else 
				{	
					avg = sum / itemNumber;
				}
				Result temp = new Result("Laundry", avg);
				return temp;
			}
		}
		else if(place.equals("A/C"))
		{
			if(aggFunction.equals("sum"))
			{
				double sum = 0;
				for(int i=0; i<inputMeasurements.size(); i++)
				{
					sum = sum +	inputMeasurements.get(i).getSubMetering3();
				}
				Result temp = new Result("A/C", sum);
				return temp;
			}
			else if(aggFunction.equals("avg"))
			{
				double avg = 0;
				double sum = 0;
				int itemNumber = 0;//number of items in the arraylist
				for(int i=0; i<inputMeasurements.size(); i++)
				{
					sum = sum +	inputMeasurements.get(i).getSubMetering3();
					itemNumber ++;
				}
				if(sum == 0) {}
				else
				{
					avg = sum / itemNumber;
				}
				Result temp = new Result("A/C", avg);
				return temp;
			}
		}
		return null;
	}

	@Override
	public String getTimeUnitType() {
		return this.timeUnit;
	}

	public String getPlace()
	{
		return this.place;
	}
}
