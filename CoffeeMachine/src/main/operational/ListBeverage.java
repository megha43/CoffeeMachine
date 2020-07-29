package main.operational;

import java.util.HashMap;
import java.util.Map;

import main.Utills.Beverage;

public class ListBeverage {

	Map<String, Beverage> beverages;

	/**
     *  Constructors
     */
	public ListBeverage() {
		// TODO Auto-generated constructor stub
		beverages = new HashMap<String, Beverage>();
	}
	
	/**
     * Initialising beverages and the ingridients required. 
     * Imnplement this function according to the data available 
     * hard coding the values, but can be initialised using the properties file similar to ingridients 
     */
	void initialise()
	{
		Map<String, Integer> ingridientMap = new HashMap<String, Integer>();
		ingridientMap.put("water", 3);
		ingridientMap.put("tea", 1);
		ingridientMap.put("milk",2);
		beverages.put("Tea", new Beverage("Tea", ingridientMap));


		Map<String, Integer> ingridientMap1 = new HashMap<String, Integer>();
		ingridientMap1.put("water", 3);
		beverages.put("Water", new Beverage("Water", ingridientMap1));

		Map<String, Integer> ingridientMap2 = new HashMap<String, Integer>();
		ingridientMap2.put("milk", 3);
		beverages.put("Milk", new Beverage("Milk", ingridientMap2));
	}

	/**
     *  Get beverage by name
     */
	Beverage getBeverage(String name)
	{
		return beverages.get(name);
	}

}
