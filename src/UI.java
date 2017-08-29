import java.util.InputMismatchException;
import java.util.Scanner;


public class UI {
	static final String[] MENU_0 = {"车辆进入", "车辆离开", "停车场信息", "退出" };
	
	public void menu_0() {
		//第一层菜单
		System.out.println("\n停车场管理系统");
		DrawLine();
		DrawUserSelection();
		DrawLine();
		for (int i = 0; i < MENU_0.length; i++) {
			System.out.println(""+i+MENU_0[i]);
		}
		DrawLine();
		UserPrompt();
	}
	
	public void menu_0_UI(CarPark carPark) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		String exit = "n";
		boolean running = true;
		while (running) {
			menu_0();
			try {
				choice = sc.nextInt();
				System.out.print("你选择了功能"+choice+"，执行"+MENU_0[choice]);
				if(choice>=0&&choice<3){
					running = false;
				}else if (choice==3) {
					System.out.println("你确定要退出程序吗？[y/n]");
					exit = sc.next();
					if (exit.matches("[yY]")) {
						running = false;
						System.out.println("退出主程序。\n");
					}else {
						System.out.println("你选择了继续执行程序");
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("输入不合法：只能输入0-5的数字");
				sc.next();
			}
		}
		switch (choice) {
		case 0:
			menu_0_0_UI(carPark);
			break;
		case 1:
			menu_0_1_UI(carPark);
			break;
		case 2:
			menu_0_2_UI(carPark);
			break;
		default:
			break;
		}
	}

	public void menu_0_0_UI(CarPark carPark) {
		//第二层菜单
		Scanner sc = new Scanner(System.in);
		String name;
		boolean running = true;
		while (running) {
			System.out.println("请输入车辆代号");
			name = sc.nextLine();
			System.out.println("车辆代号为："+name+"，请确定[y/n]");
			if(sc.next().equals("y")){
				Car car = new Car(name);
				carPark.Park(car);
				running = false;
			}
		}
		System.out.println("继续？[y/n]");
		if (sc.next().equals("y")) {
			menu_0_0_UI(carPark);
		}else {
			menu_0_UI(carPark);
		}
	}

	public void menu_0_1_UI(CarPark carPark) {
		//第二层菜单
		Scanner sc = new Scanner(System.in);
		String name;
		boolean running = true;
		while (running) {
			System.out.println("请输入车辆代号");
			name = sc.nextLine();
			System.out.println("车辆代号为："+name+"，请确定[y/n]");
			if(sc.next().equals("y")){
				Car car = new Car(name);
				carPark.Leave(car);
				running = false;
			}
		}
		System.out.println("继续？[y/n]");
		if (sc.next().equals("y")) {
			menu_0_1_UI(carPark);
		}else {
			menu_0_UI(carPark);
		}
	}

	private void menu_0_2_UI(CarPark carPark) {
		//第二层菜单
		Scanner sc = new Scanner(System.in);
		System.out.println("停车场信息：");
		carPark.ListPark();
		
		System.out.println();
		System.out.println("继续？[y/n]");
		if (sc.next().equals("y")) {
			menu_0_2_UI(carPark);
		}else {
			menu_0_UI(carPark);
		}
	}

	private void UserPrompt() {
		System.out.println("请选择……");
	}

	private void DrawUserSelection() {
		System.out.println("--------------------------------------");
	}

	private void DrawLine() {
		System.out.println("功能列表（请输入功能前面对应的数字，按回车键执行）：");
	}
}
