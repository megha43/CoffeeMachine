package test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Before;
import org.junit.Test;

import main.Utills.CustomRunnable;
import main.exceptions.InsuficientException;
import main.operational.CoffeeMachine;

public class TestCoffeeMachine {

	CoffeeMachine machine;
	int outlet = 3;

	@Before
	public void Setup()
	{
		machine = new CoffeeMachine(3,outlet);
		machine = machine.InitialiseMachine();

	}

	@Test
	public void SetAlertTest() throws InsuficientException, InterruptedException
	{
		machine.MakeBeverage("Water",machine.GetOutlet(1));
		System.out.println("Success");
	}

	@Test
	public void MakeBeverageTest() throws InsuficientException, InterruptedException
	{
		//Make beverage on outlet 1 and 0;
		machine.MakeBeverage("Tea", machine.GetOutlet(1));
		machine.MakeBeverage("Tea", machine.GetOutlet(0));
		System.out.println("Servered Successfully !!");
	}

	@Test
	public void MakeParallelBeverages()
	{
		int orders = 7;

		List<String> beverages = new ArrayList<String>();
		beverages.add("Tea");
		beverages.add("Water");
		beverages.add("Tea");
		beverages.add("Water");
		beverages.add("Tea");
		beverages.add("Water");
		beverages.add("Tea");

		ExecutorService executor = Executors.newFixedThreadPool(outlet);
		for (int i = 0; i < orders; i++) {  
			Runnable worker = new CustomRunnable(machine.GetOutlet(i%outlet),machine,beverages.get(i));  
			executor.execute(worker);//calling execute method of ExecutorService  
		}  
		executor.shutdown();  
		while (!executor.isTerminated()) {   }  
		System.out.println("Finished all threads");  

	}


}
