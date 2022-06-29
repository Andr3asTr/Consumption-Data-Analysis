package reporting;

import datamodel.IResult;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;

public class ResultReporter implements IResultReporter{

	private String reportType;
	
	public ResultReporter(String reportType)
	{
		this.reportType = reportType;
	}
	
	@Override
	public int reportResultInFile(IResult result, String filename) {
		HashMap<String, Double> kitchenMap = new HashMap<String, Double>();
		HashMap<String, Double> laundryMap = new HashMap<String, Double>();
		HashMap<String, Double> a_cMap = new HashMap<String, Double>();
		kitchenMap = result.getAggregateMeterKitchen();
		laundryMap = result.getAggregateMeterLaundry();
		a_cMap = result.getAggregateMeterAC();
		String aggFunction = result.getAggregateFunction();
		if(reportType.equals("text"))
		{
			FileOutputStream outputStream = null;
			try
			{
				outputStream = new FileOutputStream(filename);
			}
			catch(FileNotFoundException e)
			{
				System.out.println("Error opening the file " + filename);
				return -1;
			}
			PrintWriter outputWriter = new PrintWriter(outputStream);
			if(kitchenMap.get("Winter")!=null)
			{
				outputWriter.println(result.getAggregateFunction() + " consumption (watt-hours) over (a) Kitchen, (b) Laundry, (c) A/C");
				outputWriter.println("");
				outputWriter.println("Kitchen");
				outputWriter.println("--------------");
				outputWriter.println("* 01    " + kitchenMap.get("Winter"));
				outputWriter.println("* 02    " + kitchenMap.get("Spring"));
				outputWriter.println("* 03    " + kitchenMap.get("Summer"));
				outputWriter.println("* 04    " + kitchenMap.get("Autumn"));
				outputWriter.println("");
				outputWriter.println("Laundry");
				outputWriter.println("--------------");
				outputWriter.println("* 01    " + laundryMap.get("Winter"));
				outputWriter.println("* 02    " + laundryMap.get("Spring"));
				outputWriter.println("* 03    " + laundryMap.get("Summer"));
				outputWriter.println("* 04    " + laundryMap.get("Autumn"));
				outputWriter.println("");
				outputWriter.println("A/C");
				outputWriter.println("--------------");
				outputWriter.println("* 01    " + a_cMap.get("Winter"));
				outputWriter.println("* 02    " + a_cMap.get("Spring"));
				outputWriter.println("* 03    " + a_cMap.get("Summer"));
				outputWriter.println("* 04    " + a_cMap.get("Autumn"));
				outputWriter.println("\n");
				outputWriter.println(result.getDescription());
				outputWriter.close();
			}
			else if(kitchenMap.get("Jan")!=null)
			{
				outputWriter.println(result.getAggregateFunction() + " consumption (watt-hours) over (a) Kitchen, (b) Laundry, (c) A/C");
				outputWriter.println("");
				outputWriter.println("Kitchen");
				outputWriter.println("--------------");
				outputWriter.println("* 01    " + kitchenMap.get("Jan"));
				outputWriter.println("* 02    " + kitchenMap.get("Feb"));
				outputWriter.println("* 03    " + kitchenMap.get("Mar"));
				outputWriter.println("* 04    " + kitchenMap.get("Apr"));
				outputWriter.println("* 05    " + kitchenMap.get("May"));
				outputWriter.println("* 06    " + kitchenMap.get("Jun"));
				outputWriter.println("* 07    " + kitchenMap.get("Jul"));
				outputWriter.println("* 08    " + kitchenMap.get("Aug"));
				outputWriter.println("* 09    " + kitchenMap.get("Sep"));
				outputWriter.println("* 10    " + kitchenMap.get("Oct"));
				outputWriter.println("* 11    " + kitchenMap.get("Nov"));
				outputWriter.println("* 12    " + kitchenMap.get("Dec"));
				outputWriter.println("");
				outputWriter.println("Laundry");
				outputWriter.println("--------------");
				outputWriter.println("* 01    " + laundryMap.get("Jan"));
				outputWriter.println("* 02    " + laundryMap.get("Feb"));
				outputWriter.println("* 03    " + laundryMap.get("Mar"));
				outputWriter.println("* 04    " + laundryMap.get("Apr"));
				outputWriter.println("* 05    " + laundryMap.get("May"));
				outputWriter.println("* 06    " + laundryMap.get("Jun"));
				outputWriter.println("* 07    " + laundryMap.get("Jul"));
				outputWriter.println("* 08    " + laundryMap.get("Aug"));
				outputWriter.println("* 09    " + laundryMap.get("Sep"));
				outputWriter.println("* 10    " + laundryMap.get("Oct"));
				outputWriter.println("* 11    " + laundryMap.get("Nov"));
				outputWriter.println("* 12    " + laundryMap.get("Dec"));
				outputWriter.println("");
				outputWriter.println("A/C");
				outputWriter.println("--------------");
				outputWriter.println("* 01    " + a_cMap.get("Jan"));
				outputWriter.println("* 02    " + a_cMap.get("Feb"));
				outputWriter.println("* 03    " + a_cMap.get("Mar"));
				outputWriter.println("* 04    " + a_cMap.get("Apr"));
				outputWriter.println("* 05    " + a_cMap.get("May"));
				outputWriter.println("* 06    " + a_cMap.get("Jun"));
				outputWriter.println("* 07    " + a_cMap.get("Jul"));
				outputWriter.println("* 08    " + a_cMap.get("Aug"));
				outputWriter.println("* 09    " + a_cMap.get("Sep"));
				outputWriter.println("* 10    " + a_cMap.get("Oct"));
				outputWriter.println("* 11    " + a_cMap.get("Nov"));
				outputWriter.println("* 12    " + a_cMap.get("Dec"));
				outputWriter.println("\n");
				outputWriter.println(result.getDescription());
				outputWriter.close();
			}
			else if(kitchenMap.get("Mon")!=null)
			{
				outputWriter.println(result.getAggregateFunction() + " consumption (watt-hours) over (a) Kitchen, (b) Laundry, (c) A/C");
				outputWriter.println("");
				outputWriter.println("Kitchen");
				outputWriter.println("--------------");
				outputWriter.println("* 01    " + kitchenMap.get("Mon"));
				outputWriter.println("* 02    " + kitchenMap.get("Tue"));
				outputWriter.println("* 03    " + kitchenMap.get("Wed"));
				outputWriter.println("* 04    " + kitchenMap.get("Thu"));
				outputWriter.println("* 05    " + kitchenMap.get("Fri"));
				outputWriter.println("* 06    " + kitchenMap.get("Sat"));
				outputWriter.println("* 07    " + kitchenMap.get("Sun"));
				outputWriter.println("");
				outputWriter.println("Laundry");
				outputWriter.println("--------------");
				outputWriter.println("* 01    " + laundryMap.get("Mon"));
				outputWriter.println("* 02    " + laundryMap.get("Tue"));
				outputWriter.println("* 03    " + laundryMap.get("Wed"));
				outputWriter.println("* 04    " + laundryMap.get("Thu"));
				outputWriter.println("* 05    " + laundryMap.get("Fri"));
				outputWriter.println("* 06    " + laundryMap.get("Sat"));
				outputWriter.println("* 07    " + laundryMap.get("Sun"));
				outputWriter.println("");
				outputWriter.println("A/C");
				outputWriter.println("--------------");
				outputWriter.println("* 01    " + a_cMap.get("Mon"));
				outputWriter.println("* 02    " + a_cMap.get("Tue"));
				outputWriter.println("* 03    " + a_cMap.get("Wed"));
				outputWriter.println("* 04    " + a_cMap.get("Thu"));
				outputWriter.println("* 05    " + a_cMap.get("Fri"));
				outputWriter.println("* 06    " + a_cMap.get("Sat"));
				outputWriter.println("* 07    " + a_cMap.get("Sun"));
				outputWriter.println("\n");
				outputWriter.println(result.getDescription());
				outputWriter.close();
			}
			else if(kitchenMap.get("Night")!=null)
			{
				outputWriter.println(result.getAggregateFunction() + " consumption (watt-hours) over (a) Kitchen, (b) Laundry, (c) A/C");
				outputWriter.println("");
				outputWriter.println("Kitchen");
				outputWriter.println("--------------");
				outputWriter.println("* 01    " + kitchenMap.get("Night"));
				outputWriter.println("* 02    " + kitchenMap.get("Early_Morning"));
				outputWriter.println("* 03    " + kitchenMap.get("Morning"));
				outputWriter.println("* 04    " + kitchenMap.get("Afternoon"));
				outputWriter.println("* 05    " + kitchenMap.get("Evening"));
				outputWriter.println("");
				outputWriter.println("Laundry");
				outputWriter.println("--------------");
				outputWriter.println("* 01    " + laundryMap.get("Night"));
				outputWriter.println("* 02    " + laundryMap.get("Early_Morning"));
				outputWriter.println("* 03    " + laundryMap.get("Morning"));
				outputWriter.println("* 04    " + laundryMap.get("Afternoon"));
				outputWriter.println("* 05    " + laundryMap.get("Evening"));
				outputWriter.println("");
				outputWriter.println("A/C");
				outputWriter.println("--------------");
				outputWriter.println("* 01    " + a_cMap.get("Night"));
				outputWriter.println("* 02    " + a_cMap.get("Early_Morning"));
				outputWriter.println("* 03    " + a_cMap.get("Morning"));
				outputWriter.println("* 04    " + a_cMap.get("Afternoon"));
				outputWriter.println("* 05    " + a_cMap.get("Evening"));
				outputWriter.println("\n");
				outputWriter.println(result.getDescription());
				outputWriter.close();
			}
		}
		else if(reportType.equals("html"))
		{
			FileOutputStream outputStream = null;
			try
			{
				outputStream = new FileOutputStream(filename);
			}
			catch(FileNotFoundException e)
			{
				System.out.println("Error opening the file " + filename);
				return -1;
			}
			PrintWriter outputWriter = new PrintWriter(outputStream);
			if(kitchenMap.get("Winter")!=null)
			{
				outputWriter.println("<html>");
				outputWriter.println("<head>");
				outputWriter.println("<meta http-equiv=\"Content-Type\" content\"text/html; charset=windows-1253\">");
				outputWriter.println("<title>Season " + aggFunction + " aggregation over 2007</title>");
				outputWriter.println("</head>");
				outputWriter.println("<body>");
				outputWriter.println("");
				outputWriter.println("<h1> Season " + aggFunction +" aggregation over 2007 sample</h1>");
				outputWriter.println("");
				outputWriter.println("<p>" + result.getAggregateFunction() + " consumption (watt-hours) over (a) Kitchen, (b) Laundry, (c) A/C</p>");
				outputWriter.println("");
				outputWriter.println("<h2> Kitchen</h2>");
				outputWriter.println("<ul>");
				outputWriter.println("<li>* 01      " + kitchenMap.get("Winter"));
				outputWriter.println("<li>* 02      " + kitchenMap.get("Spring"));
				outputWriter.println("<li>* 03      " + kitchenMap.get("Summer"));
				outputWriter.println("<li>* 04      " + kitchenMap.get("Autumn"));
				outputWriter.println("</ul>");
				outputWriter.println("");
				outputWriter.println("<h2> Laundry</h2>");
				outputWriter.println("<ul>");
				outputWriter.println("<li>* 01      " + laundryMap.get("Winter"));
				outputWriter.println("<li>* 02      " + laundryMap.get("Spring"));
				outputWriter.println("<li>* 03      " + laundryMap.get("Summer"));
				outputWriter.println("<li>* 04      " + laundryMap.get("Autumn"));
				outputWriter.println("</ul>");
				outputWriter.println("");
				outputWriter.println("<h2> A/C</h2>");
				outputWriter.println("<ul>");
				outputWriter.println("<li>* 01      " + a_cMap.get("Winter"));
				outputWriter.println("<li>* 02      " + a_cMap.get("Spring"));
				outputWriter.println("<li>* 03      " + a_cMap.get("Summer"));
				outputWriter.println("<li>* 04      " + a_cMap.get("Autumn"));
				outputWriter.println("</ul>");
				outputWriter.close();
			}
			else if(kitchenMap.get("Jan")!=null)
			{
				outputWriter.println("<html>");
				outputWriter.println("<head>");
				outputWriter.println("<meta http-equiv=\"Content-Type\" content\"text/html; charset=windows-1253\">");
				outputWriter.println("<title>Month " + aggFunction + " aggregation over 2007</title>");
				outputWriter.println("</head>");
				outputWriter.println("<body>");
				outputWriter.println("");
				outputWriter.println("<h1> Month " + aggFunction +" aggregation over 2007 sample</h1>");
				outputWriter.println("");
				outputWriter.println("<p>" + result.getAggregateFunction() + " consumption (watt-hours) over (a) Kitchen, (b) Laundry, (c) A/C</p>");
				outputWriter.println("");
				outputWriter.println("<h2> Kitchen</h2>");
				outputWriter.println("<ul>");
				outputWriter.println("<li>* 01      " + kitchenMap.get("Jan"));
				outputWriter.println("<li>* 02      " + kitchenMap.get("Feb"));
				outputWriter.println("<li>* 03      " + kitchenMap.get("Mar"));
				outputWriter.println("<li>* 04      " + kitchenMap.get("Apr"));
				outputWriter.println("<li>* 05      " + kitchenMap.get("May"));
				outputWriter.println("<li>* 06      " + kitchenMap.get("Jun"));
				outputWriter.println("<li>* 07      " + kitchenMap.get("Jul"));
				outputWriter.println("<li>* 08      " + kitchenMap.get("Aug"));
				outputWriter.println("<li>* 09      " + kitchenMap.get("Sep"));
				outputWriter.println("<li>* 10      " + kitchenMap.get("Oct"));
				outputWriter.println("<li>* 11      " + kitchenMap.get("Nov"));
				outputWriter.println("<li>* 12      " + kitchenMap.get("Dec"));
				outputWriter.println("</ul>");
				outputWriter.println("");
				outputWriter.println("<h2> Laundry</h2>");
				outputWriter.println("<ul>");
				outputWriter.println("<li>* 01      " + laundryMap.get("Jan"));
				outputWriter.println("<li>* 02      " + laundryMap.get("Feb"));
				outputWriter.println("<li>* 03      " + laundryMap.get("Mar"));
				outputWriter.println("<li>* 04      " + laundryMap.get("Apr"));
				outputWriter.println("<li>* 05      " + laundryMap.get("May"));
				outputWriter.println("<li>* 06      " + laundryMap.get("Jun"));
				outputWriter.println("<li>* 07      " + laundryMap.get("Jul"));
				outputWriter.println("<li>* 08      " + laundryMap.get("Aug"));
				outputWriter.println("<li>* 09      " + laundryMap.get("Sep"));
				outputWriter.println("<li>* 10      " + laundryMap.get("Oct"));
				outputWriter.println("<li>* 11      " + laundryMap.get("Nov"));
				outputWriter.println("<li>* 12      " + laundryMap.get("Dec"));
				outputWriter.println("</ul>");
				outputWriter.println("");
				outputWriter.println("<h2> A/C</h2>");
				outputWriter.println("<ul>");
				outputWriter.println("<li>* 01      " + a_cMap.get("Jan"));
				outputWriter.println("<li>* 02      " + a_cMap.get("Feb"));
				outputWriter.println("<li>* 03      " + a_cMap.get("Mar"));
				outputWriter.println("<li>* 04      " + a_cMap.get("Apr"));
				outputWriter.println("<li>* 05      " + a_cMap.get("May"));
				outputWriter.println("<li>* 06      " + a_cMap.get("Jun"));
				outputWriter.println("<li>* 07      " + a_cMap.get("Jul"));
				outputWriter.println("<li>* 08      " + a_cMap.get("Aug"));
				outputWriter.println("<li>* 09      " + a_cMap.get("Sep"));
				outputWriter.println("<li>* 10      " + a_cMap.get("Oct"));
				outputWriter.println("<li>* 11      " + a_cMap.get("Nov"));
				outputWriter.println("<li>* 12      " + a_cMap.get("Dec"));
				outputWriter.println("</ul>");
				outputWriter.close();
			}
			else if(kitchenMap.get("Mon")!=null)
			{
				outputWriter.println("<html>");
				outputWriter.println("<head>");
				outputWriter.println("<meta http-equiv=\"Content-Type\" content\"text/html; charset=windows-1253\">");
				outputWriter.println("<title>Day of week " + aggFunction + " aggregation over 2007</title>");
				outputWriter.println("</head>");
				outputWriter.println("<body>");
				outputWriter.println("");
				outputWriter.println("<h1> Day of week " + aggFunction +" aggregation over 2007 sample</h1>");
				outputWriter.println("");
				outputWriter.println("<p>" + result.getAggregateFunction() + " consumption (watt-hours) over (a) Kitchen, (b) Laundry, (c) A/C</p>");
				outputWriter.println("");
				outputWriter.println("<h2> Kitchen</h2>");
				outputWriter.println("<ul>");
				outputWriter.println("<li>* 01      " + kitchenMap.get("Mon"));
				outputWriter.println("<li>* 02      " + kitchenMap.get("Tue"));
				outputWriter.println("<li>* 03      " + kitchenMap.get("Wed"));
				outputWriter.println("<li>* 04      " + kitchenMap.get("Thu"));
				outputWriter.println("<li>* 05      " + kitchenMap.get("Fri"));
				outputWriter.println("<li>* 06      " + kitchenMap.get("Sat"));
				outputWriter.println("<li>* 07      " + kitchenMap.get("Sun"));
				outputWriter.println("</ul>");
				outputWriter.println("");
				outputWriter.println("<h2> Laundry</h2>");
				outputWriter.println("<ul>");
				outputWriter.println("<li>* 01      " + laundryMap.get("Mon"));
				outputWriter.println("<li>* 02      " + laundryMap.get("Tue"));
				outputWriter.println("<li>* 03      " + laundryMap.get("Wed"));
				outputWriter.println("<li>* 04      " + laundryMap.get("Thu"));
				outputWriter.println("<li>* 05      " + laundryMap.get("Fri"));
				outputWriter.println("<li>* 06      " + laundryMap.get("Sat"));
				outputWriter.println("<li>* 07      " + laundryMap.get("Sun"));
				outputWriter.println("</ul>");
				outputWriter.println("");
				outputWriter.println("<h2> A/C</h2>");
				outputWriter.println("<ul>");
				outputWriter.println("<li>* 01      " + a_cMap.get("Mon"));
				outputWriter.println("<li>* 02      " + a_cMap.get("Tue"));
				outputWriter.println("<li>* 03      " + a_cMap.get("Wed"));
				outputWriter.println("<li>* 04      " + a_cMap.get("Thu"));
				outputWriter.println("<li>* 05      " + a_cMap.get("Fri"));
				outputWriter.println("<li>* 06      " + a_cMap.get("Sat"));
				outputWriter.println("<li>* 07      " + a_cMap.get("Sun"));
				outputWriter.println("</ul>");
				outputWriter.close();
			}
			else if(kitchenMap.get("Night")!=null)
			{
				outputWriter.println("<html>");
				outputWriter.println("<head>");
				outputWriter.println("<meta http-equiv=\"Content-Type\" content\"text/html; charset=windows-1253\">");
				outputWriter.println("<title>Period of day " + aggFunction + " aggregation over 2007</title>");
				outputWriter.println("</head>");
				outputWriter.println("<body>");
				outputWriter.println("");
				outputWriter.println("<h1> Period of day " + aggFunction +" aggregation over 2007 sample</h1>");
				outputWriter.println("");
				outputWriter.println("<p>" + result.getAggregateFunction() + " consumption (watt-hours) over (a) Kitchen, (b) Laundry, (c) A/C</p>");
				outputWriter.println("");
				outputWriter.println("<h2> Kitchen</h2>");
				outputWriter.println("<ul>");
				outputWriter.println("<li>* 01      " + kitchenMap.get("Night"));
				outputWriter.println("<li>* 02      " + kitchenMap.get("Early_Morning"));
				outputWriter.println("<li>* 03      " + kitchenMap.get("Morning"));
				outputWriter.println("<li>* 04      " + kitchenMap.get("Afternoon"));
				outputWriter.println("<li>* 05      " + kitchenMap.get("Evening"));
				outputWriter.println("</ul>");
				outputWriter.println("");
				outputWriter.println("<h2> Laundry</h2>");
				outputWriter.println("<ul>");
				outputWriter.println("<li>* 01      " + laundryMap.get("Night"));
				outputWriter.println("<li>* 02      " + laundryMap.get("Early_Morning"));
				outputWriter.println("<li>* 03      " + laundryMap.get("Morning"));
				outputWriter.println("<li>* 04      " + laundryMap.get("Afternoon"));
				outputWriter.println("<li>* 05      " + laundryMap.get("Evening"));
				outputWriter.println("</ul>");
				outputWriter.println("");
				outputWriter.println("<h2> A/C</h2>");
				outputWriter.println("</ul>");
				outputWriter.println("<li>* 01      " + a_cMap.get("Night"));
				outputWriter.println("<li>* 02      " + a_cMap.get("Early_Morning"));
				outputWriter.println("<li>* 03      " + a_cMap.get("Morning"));
				outputWriter.println("<li>* 04      " + a_cMap.get("Afternoon"));
				outputWriter.println("<li>* 05      " + a_cMap.get("Evening"));
				outputWriter.println("</ul>");
				outputWriter.close();
			}
		}
		if(reportType.equals("md"))
		{
			FileOutputStream outputStream = null;
			try
			{
				outputStream = new FileOutputStream(filename);
			}
			catch(FileNotFoundException e)
			{
				System.out.println("Error opening the file " + filename);
				return -1;
			}
			PrintWriter outputWriter = new PrintWriter(outputStream);
			if(kitchenMap.get("Winter")!=null)
			{
				outputWriter.println(result.getAggregateFunction() + " consumption (watt-hours) over (a) Kitchen, (b) Laundry, (c) A/C");
				outputWriter.println("");
				outputWriter.println("Kitchen");
				outputWriter.println("--------------");
				outputWriter.println("* 01    " + kitchenMap.get("Winter"));
				outputWriter.println("* 02    " + kitchenMap.get("Spring"));
				outputWriter.println("* 03    " + kitchenMap.get("Summer"));
				outputWriter.println("* 04    " + kitchenMap.get("Autumn"));
				outputWriter.println("");
				outputWriter.println("Laundry");
				outputWriter.println("--------------");
				outputWriter.println("* 01    " + laundryMap.get("Winter"));
				outputWriter.println("* 02    " + laundryMap.get("Spring"));
				outputWriter.println("* 03    " + laundryMap.get("Summer"));
				outputWriter.println("* 04    " + laundryMap.get("Autumn"));
				outputWriter.println("");
				outputWriter.println("A/C");
				outputWriter.println("--------------");
				outputWriter.println("* 01    " + a_cMap.get("Winter"));
				outputWriter.println("* 02    " + a_cMap.get("Spring"));
				outputWriter.println("* 03    " + a_cMap.get("Summer"));
				outputWriter.println("* 04    " + a_cMap.get("Autumn"));
				outputWriter.println("\n");
				outputWriter.println(result.getDescription());
				outputWriter.close();
			}
			else if(kitchenMap.get("Jan")!=null)
			{
				outputWriter.println(result.getAggregateFunction() + " consumption (watt-hours) over (a) Kitchen, (b) Laundry, (c) A/C");
				outputWriter.println("");
				outputWriter.println("Kitchen");
				outputWriter.println("--------------");
				outputWriter.println("* 01    " + kitchenMap.get("Jan"));
				outputWriter.println("* 02    " + kitchenMap.get("Feb"));
				outputWriter.println("* 03    " + kitchenMap.get("Mar"));
				outputWriter.println("* 04    " + kitchenMap.get("Apr"));
				outputWriter.println("* 05    " + kitchenMap.get("May"));
				outputWriter.println("* 06    " + kitchenMap.get("Jun"));
				outputWriter.println("* 07    " + kitchenMap.get("Jul"));
				outputWriter.println("* 08    " + kitchenMap.get("Aug"));
				outputWriter.println("* 09    " + kitchenMap.get("Sep"));
				outputWriter.println("* 10    " + kitchenMap.get("Oct"));
				outputWriter.println("* 11    " + kitchenMap.get("Nov"));
				outputWriter.println("* 12    " + kitchenMap.get("Dec"));
				outputWriter.println("");
				outputWriter.println("Laundry");
				outputWriter.println("--------------");
				outputWriter.println("* 01    " + laundryMap.get("Jan"));
				outputWriter.println("* 02    " + laundryMap.get("Feb"));
				outputWriter.println("* 03    " + laundryMap.get("Mar"));
				outputWriter.println("* 04    " + laundryMap.get("Apr"));
				outputWriter.println("* 05    " + laundryMap.get("May"));
				outputWriter.println("* 06    " + laundryMap.get("Jun"));
				outputWriter.println("* 07    " + laundryMap.get("Jul"));
				outputWriter.println("* 08    " + laundryMap.get("Aug"));
				outputWriter.println("* 09    " + laundryMap.get("Sep"));
				outputWriter.println("* 10    " + laundryMap.get("Oct"));
				outputWriter.println("* 11    " + laundryMap.get("Nov"));
				outputWriter.println("* 12    " + laundryMap.get("Dec"));
				outputWriter.println("");
				outputWriter.println("A/C");
				outputWriter.println("--------------");
				outputWriter.println("* 01    " + a_cMap.get("Jan"));
				outputWriter.println("* 02    " + a_cMap.get("Feb"));
				outputWriter.println("* 03    " + a_cMap.get("Mar"));
				outputWriter.println("* 04    " + a_cMap.get("Apr"));
				outputWriter.println("* 05    " + a_cMap.get("May"));
				outputWriter.println("* 06    " + a_cMap.get("Jun"));
				outputWriter.println("* 07    " + a_cMap.get("Jul"));
				outputWriter.println("* 08    " + a_cMap.get("Aug"));
				outputWriter.println("* 09    " + a_cMap.get("Sep"));
				outputWriter.println("* 10    " + a_cMap.get("Oct"));
				outputWriter.println("* 11    " + a_cMap.get("Nov"));
				outputWriter.println("* 12    " + a_cMap.get("Dec"));
				outputWriter.println("\n");
				outputWriter.println(result.getDescription());
				outputWriter.close();
			}
			else if(kitchenMap.get("Mon")!=null)
			{
				outputWriter.println(result.getAggregateFunction() + " consumption (watt-hours) over (a) Kitchen, (b) Laundry, (c) A/C");
				outputWriter.println("");
				outputWriter.println("Kitchen");
				outputWriter.println("--------------");
				outputWriter.println("* 01    " + kitchenMap.get("Mon"));
				outputWriter.println("* 02    " + kitchenMap.get("Tue"));
				outputWriter.println("* 03    " + kitchenMap.get("Wed"));
				outputWriter.println("* 04    " + kitchenMap.get("Thu"));
				outputWriter.println("* 05    " + kitchenMap.get("Fri"));
				outputWriter.println("* 06    " + kitchenMap.get("Sat"));
				outputWriter.println("* 07    " + kitchenMap.get("Sun"));
				outputWriter.println("");
				outputWriter.println("Laundry");
				outputWriter.println("--------------");
				outputWriter.println("* 01    " + laundryMap.get("Mon"));
				outputWriter.println("* 02    " + laundryMap.get("Tue"));
				outputWriter.println("* 03    " + laundryMap.get("Wed"));
				outputWriter.println("* 04    " + laundryMap.get("Thu"));
				outputWriter.println("* 05    " + laundryMap.get("Fri"));
				outputWriter.println("* 06    " + laundryMap.get("Sat"));
				outputWriter.println("* 07    " + laundryMap.get("Sun"));
				outputWriter.println("");
				outputWriter.println("A/C");
				outputWriter.println("--------------");
				outputWriter.println("* 01    " + a_cMap.get("Mon"));
				outputWriter.println("* 02    " + a_cMap.get("Tue"));
				outputWriter.println("* 03    " + a_cMap.get("Wed"));
				outputWriter.println("* 04    " + a_cMap.get("Thu"));
				outputWriter.println("* 05    " + a_cMap.get("Fri"));
				outputWriter.println("* 06    " + a_cMap.get("Sat"));
				outputWriter.println("* 07    " + a_cMap.get("Sun"));
				outputWriter.println("\n");
				outputWriter.println(result.getDescription());
				outputWriter.close();
			}
			else if(kitchenMap.get("Night")!=null)
			{
				outputWriter.println(result.getAggregateFunction() + " consumption (watt-hours) over (a) Kitchen, (b) Laundry, (c) A/C");
				outputWriter.println("");
				outputWriter.println("Kitchen");
				outputWriter.println("--------------");
				outputWriter.println("* 01    " + kitchenMap.get("Night"));
				outputWriter.println("* 02    " + kitchenMap.get("Early_Morning"));
				outputWriter.println("* 03    " + kitchenMap.get("Morning"));
				outputWriter.println("* 04    " + kitchenMap.get("Afternoon"));
				outputWriter.println("* 05    " + kitchenMap.get("Evening"));
				outputWriter.println("");
				outputWriter.println("Laundry");
				outputWriter.println("--------------");
				outputWriter.println("* 01    " + laundryMap.get("Night"));
				outputWriter.println("* 02    " + laundryMap.get("Early_Morning"));
				outputWriter.println("* 03    " + laundryMap.get("Morning"));
				outputWriter.println("* 04    " + laundryMap.get("Afternoon"));
				outputWriter.println("* 05    " + laundryMap.get("Evening"));
				outputWriter.println("");
				outputWriter.println("A/C");
				outputWriter.println("--------------");
				outputWriter.println("* 01    " + a_cMap.get("Night"));
				outputWriter.println("* 02    " + a_cMap.get("Early_Morning"));
				outputWriter.println("* 03    " + a_cMap.get("Morning"));
				outputWriter.println("* 04    " + a_cMap.get("Afternoon"));
				outputWriter.println("* 05    " + a_cMap.get("Evening"));
				outputWriter.println("\n");
				outputWriter.println(result.getDescription());
				outputWriter.close();
			}
		}
		return 0;
	}

}
