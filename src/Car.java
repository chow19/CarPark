import com.sun.org.apache.regexp.internal.recompile;

public class Car {
	String carName;
	
	public Car(String name) {
		carName = name;
	}
	
	public String Show() {
		return carName;
	}
	
	public boolean Equals(Car car) {
		if(carName.equals(car.Show())){
			return true;
		}else {
			return false;
		}
	}
}
