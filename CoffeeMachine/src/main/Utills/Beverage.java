package main.Utills;

import java.util.Map;

public class Beverage {

	String name;
	Map<String,Integer> requirement;
	
	public Beverage(String in_name, Map<String, Integer> in_requirements) {
		// TODO Auto-generated constructor stub
		name=in_name;
		requirement=in_requirements;
	}
	
	public void InitialiseBeverage(String in_name, Map<String, Integer> in_requirements)
	{
		name = in_name;
		requirement = in_requirements;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, Integer> getRequirement() {
		return requirement;
	}

	public void setRequirement(Map<String, Integer> requirement) {
		this.requirement = requirement;
	}
	
}
