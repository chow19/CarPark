import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CarPark {
	int carParkSize;
	Stack<Car> park;
	Queue<Car> channel;
	ArrayList<String> history = new ArrayList<>();
	
	
	public CarPark(int num){
		carParkSize = num;
		park = new Stack<>();
		channel = new LinkedList<>();
	}
	
	public void Park(Car car){
		if(!history.contains(car.Show())){
			if (park.size()<carParkSize) {
				park.push(car);
			}else{
				channel.add(car);
			}
			history.add(car.Show());
			System.out.println("车辆 "+car.Show()+" 已进入。");
		}else {
			System.out.println("车已存在。");
		}
	}
	
	public void Leave(Car car){
		if(history.contains(car.Show())){
			history.remove(car.Show());
			Stack<Car> miniCarPark = new Stack<>();
			
			//int carsize = park.search(car);	
			//search为由后往前数
			while(!park.isEmpty()) {
				Car car2 = park.pop();
				if(car2.Equals(car)){
					System.out.println("车辆 "+car2.Show()+" 已离开。");
					break;
				}
				miniCarPark.push(car2);
			}
			
			while (!miniCarPark.isEmpty()) {
				park.push(miniCarPark.pop());
			}
			if (!channel.isEmpty()) {
				park.push(channel.remove());
			}
		}else{
			System.out.println("车不存在。");
		}
	}
	
	public void ListPark(){
		for (Car car : park) {
			System.out.println("车辆 "+car.Show()+" 停放中。");
		}
	}
	
	public static void main(String[] args) {
		CarPark carPark = new CarPark(10);
		Car car1 = new Car("a");
		Car car2 = new Car("b");
		Car car3 = new Car("c");
		Car car4 = new Car("a");
		carPark.Park(car1);
		carPark.Park(car2);
		carPark.ListPark();
		System.out.println("--------------");
		System.out.println(carPark.park.search(car4));
		System.out.println("--------------");
		carPark.Leave(car4);
		carPark.ListPark();
	}
}
