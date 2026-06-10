package mn.icode;

public interface Sensor {
	double readValue();
	String unit();

	default String report() {
		return "Sensor reading: " + readValue() + " , " + unit();
	}
	
	default boolean isNormal(double min, double max) {
		if (min < readValue() && readValue() < max) {
			return true;
		}
		return false;
	}
}

class TemperatureSensor implements Sensor {
	double celsius;
	
	public TemperatureSensor(double celsius) {
		this.celsius = celsius;
	}
	
	@Override 
	public double readValue() {
		return celsius;
	}
	
    @Override public String unit() {
    	return "°C";
    }
}

class PressureSensor implements Sensor {
	double hPa;
	
	public PressureSensor(double hPa) {
		this.hPa = hPa;
	}
	
	@Override 
	public double readValue() {
		return hPa;
	}
	
    @Override public String unit() {
    	return "hPa";
    }
}

class HumiditySensor implements Sensor {
	double percent;
	
	public HumiditySensor(double percent) {
		this.percent = percent;
	}
	
	@Override 
	public double readValue() {
		return percent;
	}
	
    @Override public String unit() {
    	return "%";
    }
}