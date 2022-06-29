package datamodel;


public class MeasurementRecord {
	int[] date;
	int[] time;
	double global_active_power;
	double global_reactive_power;
	double voltage;
	double global_intensity;
	double sub_metering_1;//kitchen
	double sub_metering_2;//washroom
	double sub_metering_3;//a/c
	
	public MeasurementRecord(String date, String time, String global_active_power, String global_reactive_power, String voltage, String global_intensity, String sub_metering_1, String sub_metering_2, String sub_metering_3)
	{
		String[] tempDate = date.split("/");
		this.date = new int[tempDate.length];
		for(int i=0; i<tempDate.length; i++)
		{
			this.date[i] = Integer.parseInt(tempDate[i]);
		}
		String[] tempTime = time.split(":");
		this.time = new int[tempTime.length];
		for(int i=0; i<tempTime.length; i++)
		{
			this.time[i] = Integer.parseInt(tempTime[i]);
		}
		this.global_active_power = Double.parseDouble(global_active_power);
		this.global_reactive_power = Double.parseDouble(global_reactive_power);
		this.voltage = Double.parseDouble(voltage);
		this.global_intensity = Double.parseDouble(global_intensity);
		this.sub_metering_1 = Double.parseDouble(sub_metering_1);
		this.sub_metering_2 = Double.parseDouble(sub_metering_2);
		this.sub_metering_3 = Double.parseDouble(sub_metering_3);
	}
	
	public int[] getDate()
	{
		return this.date;
	}
	
	public void setDate(int[] date)
	{
		this.date = date;
	}
	
	public int[] getTime()
	{
		return this.time;
	}
	
	public void setTime(int[] time)
	{
		this.time = time;
	}
	
	public double getGlobalActivePower() 
	{
		return this.global_active_power;
	}
	
	public void setGlobalActivePower(double global_active_power)
	{
		this.global_active_power = global_active_power;
	}
	
	public double getVoltage()
	{
		return this.voltage;
	}
	
	public void setVoltage(double voltage)
	{
		this.voltage = voltage;
	}
	
	public double getGlobalIntensity()
	{
		return this.global_intensity;
	}
	
	public void setGlobalIntensity(double global_intensity)
	{
		this.global_intensity = global_intensity;
	}
	
	public double getSubMetering1() 
	{
		return this.sub_metering_1;
	}
	
	public void setSubMetering1(double sub_metering_1)
	{
		this.sub_metering_1 = sub_metering_1;
	}
	
	public double getSubMetering2()
	{
		return this.sub_metering_2;
	}
	
	public void setSubMetering2(double sub_metering_2)
	{
		this.sub_metering_2 = sub_metering_2;
	}
	
	public double getSubMetering3()
	{
		return this.sub_metering_3;
	}
	
	public void setSubMetering3(double sub_metering_3)
	{
		this.sub_metering_3 = sub_metering_3;
	}

}

