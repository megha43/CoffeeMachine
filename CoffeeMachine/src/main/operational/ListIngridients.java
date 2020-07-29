package main.operational;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import main.Utills.Ingridient;

public class ListIngridients {

	Map<String, Ingridient> allIngridient;
	static int alertLimit;

	/**
     *  Constructors
     */
	public ListIngridients(int in_alert) {
		allIngridient = new HashMap<String, Ingridient>();
		alertLimit=in_alert;
	}

	/**
     *  Initialised ingridients based on the config file in res folder
     *  Alert is also set based on this.
     */
	void Initialise() throws IOException
	{
		FileReader reader=new FileReader("..\\CoffeeMachine\\src\\Resources\\config.properties");  

		Properties p=new Properties();  
		p.load(reader);  

		alertLimit = Integer.parseInt(p.getProperty("Alert"));
		String ingre = p.getProperty("Ingridients");
		List<String> allingre = Arrays.asList(ingre.split(","));

		for(int i =0; i<allingre.size(); i++)
		{
			if(p.getProperty(allingre.get(i))!=null);
			allIngridient.put(allingre.get(i), new Ingridient(allingre.get(i), Integer.parseInt(p.getProperty(allingre.get(i))), setAlert(Integer.parseInt(p.getProperty(allingre.get(i))))));	    	
		}

	}

	/**
     *  Set Alert
     */
	boolean setAlert(int n)
	{
		if(n<=alertLimit)
			return true;
		return false;
	}

	/**
     *  Refill all ingridient
     */
	void RefillAll()
	{
		for(String k: allIngridient.keySet())
			allIngridient.get(k).Refill();
	}

	/**
     *  Set quantity for ingridient
     */
	void SetQuantityFor(String name, int in_stockLeft)
	{
		allIngridient.get(name).setstockLeft(in_stockLeft);
	}

	/**
     *  Refill ingridient by name
     */
	void Refill(String in_name)
	{
		allIngridient.get(in_name).Refill();
	}

	/**
     *  Get ingridient by name
     */
	Ingridient getIngridient(String in_name)
	{
		return allIngridient.get(in_name);
	}
}
