package main.Utills;

import main.exceptions.InsuficientException;
import main.operational.CoffeeMachine;

public class CustomRunnable implements Runnable{

	Outlet parameter;
	CoffeeMachine machine;
	String name;

	public CustomRunnable(Outlet outlet, CoffeeMachine in_machine, String in_name) {
		// TODO Auto-generated constructor stub
		parameter = outlet;
		machine = in_machine;
		name = in_name;
	}
	public void run() {

		try {
			machine.MakeBeverage(name, parameter);
			//System.out.println("Beverage Server "+ name);

		} catch (InsuficientException e) {
			// TODO Auto-generated catch block
			System.out.println("Insuficient Quantity Exception");
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Tread interuption");
			e.printStackTrace();
		}

	}

}
