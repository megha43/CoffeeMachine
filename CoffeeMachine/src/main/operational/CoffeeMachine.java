package main.operational;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import main.Utills.Beverage;
import main.Utills.Ingridient;
import main.Utills.Outlet;
import main.exceptions.InsuficientException;

public class CoffeeMachine  {

	ListBeverage beverages;
	ListIngridients ingridients;
	int Outlet;
	int alert;
	List<Outlet> outlist;

	/**
	 * Constructors
	 * 
	 */
	public CoffeeMachine(int in_alert, int in_outlet)
	{
		beverages = new ListBeverage();
		ingridients = new ListIngridients(alert);
		alert = in_alert;
		Outlet=in_outlet;
		outlist = new ArrayList<Outlet>();
		for(int i=0;i<Outlet;i++)
		{
			outlist.add(new Outlet(i));
		}

	}

	/**
	 * Initialise the Machine Adding various details
	 * 
	 */
	public CoffeeMachine InitialiseMachine()
	{
		beverages.initialise();

		try {
			ingridients.Initialise();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return this;
	}

	/**
	 * Gets the outlet of the machine to lock and unlock
	 * 
	 */
	public Outlet GetOutlet(int i)
	{
		return outlist.get(i);
	}

	/**
	 * Process to prepare beverage
	 * check for ingridients
	 * subtract the ingridients
	 * notify alert
	 */
	public void MakeBeverage(String name, Outlet out) throws InsuficientException, InterruptedException
	{
		out.Lock();
		Beverage b = beverages.getBeverage(name);

		Map<String, Integer> requirement = b.getRequirement();

		synchronized(out)
		{
			for(String ingName: requirement.keySet())
			{
				Ingridient i = ingridients.getIngridient(ingName);
				if(i.getstockLeft()<requirement.get(i.getName()))
				{
					System.out.println("Here");
					throw new InsuficientException("Insufficient quantity of the ingridients");
				}
			}

			for(String ingName: requirement.keySet())
			{
				Ingridient i = ingridients.getIngridient(ingName);
				if(i.getstockLeft()-requirement.get(i.getName())<alert)
				{
					SetAlert(i);				// Set Alert
					//		ingridients.Refill(i.getName()); // Auto refill 
				}
				ingridients.SetQuantityFor(i.getName(),i.getstockLeft()-requirement.get(i.getName()));
			}

		}
//Making coffeee
		Thread.sleep(1000);
		out.Unlock();
		System.out.println(Thread.currentThread().getName() + " Beverage "+ name +" Servered." );
	}


	void SetAlert(Ingridient i)
	{
		System.out.println("Alert for Low quantity Element: " + i.getName());
	}

}
