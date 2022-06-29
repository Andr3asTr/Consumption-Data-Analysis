package mainengine;

import java.util.ArrayList;

import reporting.*;
import datamodel.*;
//import datamodel.MeasurementRecord;
import dataload.Loader;

public class MainEngine implements IMainEngine{

	private ArrayList<MeasurementRecord> record = new ArrayList<MeasurementRecord>();
	@Override
	public int loadData(String fileName, String delimeter, Boolean hasHeaderLine, int numFields,
			ArrayList<MeasurementRecord> objCollection) {
		Loader dataLoad = new Loader();
		int correctLines = dataLoad.load(fileName, delimeter, hasHeaderLine, numFields, objCollection);
		record = dataLoad.readFile();
		return correctLines;
	}

	@Override
	public IResult aggregateByTimeUnit(ArrayList<MeasurementRecord> inputMeasurements, String aggregatorType,
			String aggFunction, String description) {
		Result result = new Result(inputMeasurements, aggregatorType, aggFunction, description);
		for(int i=0; i<inputMeasurements.size(); i++)
		{
			result.add(aggregatorType, inputMeasurements.get(i));
		}
		return result;
	}

	@Override
	public int reportResultInFile(IResult result, String reportType, String filename) {
		ResultReporter report = new ResultReporter(reportType);
		int x = report.reportResultInFile(result, filename);
		if(x<0) {return -1;}
		return 0;
	}
	
	public ArrayList<MeasurementRecord> getReadData()
	{
		return record;
	}
}
