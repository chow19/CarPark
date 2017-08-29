import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
 		System.out.println("请输入停车场容量:");
 		CarPark carPark = new CarPark(sc.nextInt());
 		UI ui = new UI();
 		ui.menu_0_UI(carPark);
	}

}
