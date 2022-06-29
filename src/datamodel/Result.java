package datamodel;

import timeaggregation.Aggregator;
import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDate;
import java.time.DayOfWeek;

public class Result implements IResult{
	
	
	private ArrayList<MeasurementRecord> tempArrayList = new ArrayList<MeasurementRecord>();
	private ArrayList<ArrayList<MeasurementRecord>> season = new ArrayList<ArrayList<MeasurementRecord>>(4);
		ArrayList<MeasurementRecord> winter = new ArrayList<MeasurementRecord>();
		ArrayList<MeasurementRecord> spring = new ArrayList<MeasurementRecord>();
		ArrayList<MeasurementRecord> summer = new ArrayList<MeasurementRecord>();
		ArrayList<MeasurementRecord> autumn = new ArrayList<MeasurementRecord>();
	private ArrayList<ArrayList<MeasurementRecord>> month = new ArrayList<ArrayList<MeasurementRecord>>(12);
		ArrayList<MeasurementRecord> January = new ArrayList<MeasurementRecord>();
		ArrayList<MeasurementRecord> February = new ArrayList<MeasurementRecord>();
		ArrayList<MeasurementRecord> March = new ArrayList<MeasurementRecord>();
		ArrayList<MeasurementRecord> April = new ArrayList<MeasurementRecord>();
		ArrayList<MeasurementRecord> May = new ArrayList<MeasurementRecord>();
		ArrayList<MeasurementRecord> June = new ArrayList<MeasurementRecord>();
		ArrayList<MeasurementRecord> July = new ArrayList<MeasurementRecord>();
		ArrayList<MeasurementRecord> August = new ArrayList<MeasurementRecord>();
		ArrayList<MeasurementRecord> September = new ArrayList<MeasurementRecord>();
		ArrayList<MeasurementRecord> Octomber = new ArrayList<MeasurementRecord>();
		ArrayList<MeasurementRecord> November = new ArrayList<MeasurementRecord>();
		ArrayList<MeasurementRecord> December = new ArrayList<MeasurementRecord>();
	private ArrayList<ArrayList<MeasurementRecord>> day = new ArrayList<ArrayList<MeasurementRecord>>(7);
		ArrayList<MeasurementRecord> Monday = new ArrayList<MeasurementRecord>();
		ArrayList<MeasurementRecord> Tuesday = new ArrayList<MeasurementRecord>();
		ArrayList<MeasurementRecord> Wednesday = new ArrayList<MeasurementRecord>();
		ArrayList<MeasurementRecord> Thursday = new ArrayList<MeasurementRecord>();
		ArrayList<MeasurementRecord> Friday = new ArrayList<MeasurementRecord>();
		ArrayList<MeasurementRecord> Saturday = new ArrayList<MeasurementRecord>();
		ArrayList<MeasurementRecord> Sunday = new ArrayList<MeasurementRecord>();
	private ArrayList<ArrayList<MeasurementRecord>> periodOfDay = new ArrayList<ArrayList<MeasurementRecord>>(5);
		ArrayList<MeasurementRecord> Night = new ArrayList<MeasurementRecord>();
		ArrayList<MeasurementRecord> Early_Morning = new ArrayList<MeasurementRecord>();
		ArrayList<MeasurementRecord> Morning = new ArrayList<MeasurementRecord>();
		ArrayList<MeasurementRecord> Afternoon = new ArrayList<MeasurementRecord>();
		ArrayList<MeasurementRecord> Evening = new ArrayList<MeasurementRecord>();
	private String[] seasons = {"Winter","Spring","Summer","Autumn"};
	private String[] months = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
	private String[] days = {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
	private String[] periodsOfDay = {"Night","Early_Morning","Morning","Afternoon","Evening"};
	
	
	
	private String timeUnit;//"season" or "month" etc
	private String description;
	private int counter = 0;//counts if it is the first time the add() function is used
	private MeasurementRecord record;
	private String aggFunction;//avg or sum
	private String tempString;
	private double tempDouble;
	
	
	public Result(String tempString, double tempDouble) 
	{
		this.tempString = tempString;
		this.tempDouble = tempDouble;
	}
	
	public Result(String timeUnit, String description,String aggFunction, MeasurementRecord record)
	{
		this.timeUnit = timeUnit;
		this.description = description;
		this.record = record;
		this.aggFunction = aggFunction;
	}
	
	public Result()
	{
		
	}
	
	@Override
	public int add(String timeUnit, MeasurementRecord record) {
		if(counter == 0) {//create the arraylists inside the timeUnit arraylist
			season.add(winter);
			season.add(spring);
			season.add(summer);
			season.add(autumn);
			month.add(January);
			month.add(February);
			month.add(March);
			month.add(April);
			month.add(May);
			month.add(June);
			month.add(July);
			month.add(August);
			month.add(September);
			month.add(Octomber);
			month.add(November);
			month.add(December);
			day.add(Monday);
			day.add(Tuesday);
			day.add(Wednesday);
			day.add(Thursday);
			day.add(Friday);
			day.add(Saturday);
			day.add(Sunday);
			periodOfDay.add(Night);
			periodOfDay.add(Early_Morning);
			periodOfDay.add(Morning);
			periodOfDay.add(Afternoon);
			periodOfDay.add(Evening);
			counter ++;
		}
		
		if(timeUnit.equals("season"))
		{
			if(record.getDate()[1] == 1 || record.getDate()[1] == 2 || record.getDate()[1] == 12)
			{
				season.get(0).add(record);
			}
			else if(record.getDate()[1] == 3 || record.getDate()[1] == 4 || record.getDate()[1] == 5)
			{
				season.get(1).add(record);
			}
			else if(record.getDate()[1] == 6 || record.getDate()[1] == 7 || record.getDate()[1] == 8)
			{
				season.get(2).add(record);
			}
			else if(record.getDate()[1] == 9 || record.getDate()[1] == 10 || record.getDate()[1] == 11)
			{
				season.get(3).add(record);
			}
			return season.size();
		}
		else if(timeUnit.equals("month"))
		{
			month.get(record.getDate()[1] - 1).add(record);
			return month.size();
		}
		else if(timeUnit.equals("day of week"))
		{
			LocalDate localDate = LocalDate.of(record.getDate()[2], record.getDate()[1], record.getDate()[0]);
			DayOfWeek dayOfWeek = localDate.getDayOfWeek();
			int dayNum = dayOfWeek.getValue();//deutera: 1, trith: 2, ... , kyriakh: 7
			day.get(dayNum - 1).add(record);
			return day.size();
		}
		else if(timeUnit.equals("period of day"))
		{
			int time = record.getTime()[0];
			if(time >= 21 && time < 5)//vrady
			{
				periodOfDay.get(0).add(record);
				return periodOfDay.size();
			}
			else if(time >= 5 && time < 9)//nwris prwi
			{
				periodOfDay.get(1).add(record);
				return periodOfDay.size();
			}
			else if(time >= 9 && time < 13)//prwi
			{
				periodOfDay.get(2).add(record);
				return periodOfDay.size();
			}
			else if(time >= 13 && time < 17)
			{
				periodOfDay.get(3).add(record);
				return periodOfDay.size();
			}
			else if(time >= 17 && time < 21)
			{
				periodOfDay.get(4).add(record);
				return periodOfDay.size();
			}
		}
		
		return 0;
	}
	
	public Result(ArrayList<MeasurementRecord> inputMeasurements, String aggregatorType, String aggFunction, String description)
	{
		this.tempArrayList = inputMeasurements;
		this.timeUnit = aggregatorType;
		this.aggFunction = aggFunction;
		this.description = description;
	}
	
	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public HashMap<String, ArrayList<MeasurementRecord>> getDetailedResults() {
		HashMap<String, ArrayList<MeasurementRecord>> hashMap = new HashMap<String, ArrayList<MeasurementRecord>>();
		hashMap.put("WINTER", season.get(0));
		hashMap.put("SPRING", season.get(1));
		hashMap.put("SUMMER", season.get(2));
		hashMap.put("AUTUMN", season.get(3));
		hashMap.put("JANUARY", month.get(0));
		hashMap.put("FEBRUARY", month.get(1));
		hashMap.put("MARCH", month.get(2));
		hashMap.put("APRIL", month.get(3));
		hashMap.put("MAY", month.get(4));
		hashMap.put("JUNE", month.get(5));
		hashMap.put("JULY", month.get(6));
		hashMap.put("AUGUST", month.get(7));
		hashMap.put("SEPTEMBER", month.get(8));
		hashMap.put("OCTOMBER", month.get(9));
		hashMap.put("NOVEMBER", month.get(10));
		hashMap.put("DECEMBER", month.get(11));
		hashMap.put("MONDAY", day.get(0));
		hashMap.put("TUESDAY", day.get(1));
		hashMap.put("WEDNESDAY", day.get(2));
		hashMap.put("THURSDAY", day.get(3));
		hashMap.put("FRIDAY", day.get(4));
		hashMap.put("SATURDAY", day.get(5));
		hashMap.put("SUNDAY", day.get(6));
		hashMap.put("NIGHT", periodOfDay.get(0));
		hashMap.put("EARLY MORNING", periodOfDay.get(1));
		hashMap.put("MORNING", periodOfDay.get(2));
		hashMap.put("AFTERNOON", periodOfDay.get(3));
		hashMap.put("EVENING", periodOfDay.get(4));
		return hashMap;
	}

	@Override
	public HashMap<String, Double> getAggregateMeterKitchen() {
		HashMap<String, Double> hashMap = new HashMap<String, Double>();
		double tempDouble;
		String description = "";
		
		Result resultat = new Result();
		if(timeUnit.equals("season"))
		{
			Aggregator aggr = new Aggregator("Kitchen", timeUnit);
			for(int i=0; i<season.size(); i++)
			{
				description = seasons[i];
				resultat = (Result) aggr.aggregateByTimeUnit(season.get(i), aggFunction, description);
				tempDouble = resultat.getTempDouble();
				hashMap.put(description, tempDouble);
			}
			return hashMap;
		}
		else if(timeUnit.equals("month"))
		{
			Aggregator aggr = new Aggregator("Kitchen", timeUnit);
			for(int i=0; i<month.size(); i++)
			{
				description = months[i];
				resultat = (Result) aggr.aggregateByTimeUnit(month.get(i), aggFunction, description);
				tempDouble = resultat.getTempDouble();
				hashMap.put(description, tempDouble);
			}
			return hashMap;
		}
		else if(timeUnit.equals("day of week"))
		{
			Aggregator aggr = new Aggregator("Kitchen", timeUnit);
			for(int i=0; i<day.size(); i++)
			{
				description = days[i];
				resultat = (Result) aggr.aggregateByTimeUnit(day.get(i), aggFunction, description);
				tempDouble = resultat.getTempDouble();
				hashMap.put(description, tempDouble);
			}
			return hashMap;
		}
		else if(timeUnit.equals("period of day"))	
		{
			Aggregator aggr = new Aggregator("Kitchen", timeUnit);
			for(int i=0; i<periodOfDay.size(); i++)
			{
				description = periodsOfDay[i];
				resultat = (Result) aggr.aggregateByTimeUnit(periodOfDay.get(i), aggFunction, description);
				tempDouble = resultat.getTempDouble();
				hashMap.put(description, tempDouble);
			}
			return hashMap;
		}
		return null;
	}

	@Override
	public HashMap<String, Double> getAggregateMeterLaundry() {
		HashMap<String, Double> hashMap = new HashMap<String, Double>();
		double tempDouble;
		String description = "";
		Result resultat = new Result();
		if(timeUnit.equals("season"))
		{
			Aggregator aggr = new Aggregator("Laundry", timeUnit);
			for(int i=0; i<season.size(); i++)
			{
				description = seasons[i];
				resultat = (Result) aggr.aggregateByTimeUnit(season.get(i), aggFunction, description);
				tempDouble = resultat.getTempDouble();
				hashMap.put(description, tempDouble);
			}
			return hashMap;
		}
		if(timeUnit.equals("month"))
		{
			Aggregator aggr = new Aggregator("Laundry", timeUnit);
			for(int i=0; i<month.size(); i++)
			{
				description = months[i];
				resultat = (Result) aggr.aggregateByTimeUnit(month.get(i), aggFunction, description);
				tempDouble = resultat.getTempDouble();
				hashMap.put(description, tempDouble);
			}
			return hashMap;
		}
		if(timeUnit.equals("day of week"))
		{
			Aggregator aggr = new Aggregator("Laundry", timeUnit);
			for(int i=0; i<day.size(); i++)
			{
				description = days[i];
				resultat = (Result) aggr.aggregateByTimeUnit(day.get(i), aggFunction, description);
				tempDouble = resultat.getTempDouble();
				hashMap.put(description, tempDouble);
			}
			return hashMap;
		}
		if(timeUnit.equals("period of day"))
		{
			Aggregator aggr = new Aggregator("Laundry", timeUnit);
			for(int i=0; i<periodOfDay.size(); i++)
			{
				description = periodsOfDay[i];
				resultat = (Result) aggr.aggregateByTimeUnit(periodOfDay.get(i), aggFunction, description);
				tempDouble = resultat.getTempDouble();
				hashMap.put(description, tempDouble);
			}
			return hashMap;
		}
		return null;
	}

	@Override
	public HashMap<String, Double> getAggregateMeterAC() {
		HashMap<String, Double> hashMap = new HashMap<String, Double>();
		double tempDouble;
		String description = "";
		Result resultat = new Result();
		if(timeUnit.equals("season"))
		{
			Aggregator aggr = new Aggregator("A/C", timeUnit);
			for(int i=0; i<season.size(); i++)
			{
				description = seasons[i];
				resultat = (Result) aggr.aggregateByTimeUnit(season.get(i), aggFunction, description);
				tempDouble = resultat.getTempDouble();
				hashMap.put(description, tempDouble);
			}
			return hashMap;
		}
		if(timeUnit.equals("month"))	
		{
			Aggregator aggr = new Aggregator("A/C", timeUnit);
			for(int i=0; i<month.size(); i++)
			{
				description = months[i];
				resultat = (Result) aggr.aggregateByTimeUnit(month.get(i), aggFunction, description);
				tempDouble = resultat.getTempDouble();
				hashMap.put(description, tempDouble);
			}
			return hashMap;
		}
		if(timeUnit.equals("day of week"))	
		{	
			Aggregator aggr = new Aggregator("A/C", timeUnit);
			for(int i=0; i<day.size(); i++)
			{
				description = days[i];
				resultat = (Result) aggr.aggregateByTimeUnit(day.get(i), aggFunction, description);
				tempDouble = resultat.getTempDouble();
				hashMap.put(description, tempDouble);
			}
			return hashMap;
		}
		if(timeUnit.equals("period of day"))	
		{	
			Aggregator aggr = new Aggregator("A/C", timeUnit);
			for(int i=0; i<periodOfDay.size(); i++)
			{
				description = periodsOfDay[i];
				resultat = (Result) aggr.aggregateByTimeUnit(periodOfDay.get(i), aggFunction, description);
				tempDouble = resultat.getTempDouble();
				hashMap.put(description, tempDouble);
			}
			return hashMap;
		}
		return null;
	}

	@Override
	public String getAggregateFunction() {
		return aggFunction;
	}
	
	public String getTempString()
	{
		return tempString;
	}
	
	public double getTempDouble()
	{
		return tempDouble;
	}

	//checking
	public void setTimeUnit(String timeUnit)
	{
		this.timeUnit = timeUnit;
	}
	
	public void setAggFunction(String aggFunction)
	{
		this.aggFunction = aggFunction;
	}
}
