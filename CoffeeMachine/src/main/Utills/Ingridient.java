package main.Utills;

public class Ingridient {

	private String name;
	int stockLeft;
	boolean alert;
	
	/**
     * Constructors
     * 
     * @param in_name
     * @param in_stock
     * @param in_alert
     */
	public Ingridient(String in_name, int in_stock, boolean in_alert)
	{
		setName(in_name);
		stockLeft = in_stock;
		alert = in_alert;
	};

	/**
     * Gets the remaining stock of ingridient
     * @return
     */
	public int getstockLeft() {
		return stockLeft;
	}
	
	/**
     * Sets the remaining stock of ingridient
     * 
     */
	public void setstockLeft(int in_stockLeft) {
		this.stockLeft = in_stockLeft;
	}
	
	/**
     * Gets the Alert of ingridient
     * @return
     */
	public boolean getAlert() {
		return alert;
	}
	
	/**
     * Sets the ifAlert required of ingridient
     * @return
     */
	public void setAlert(boolean in_alert) {
		this.alert = in_alert;
	}
	
	/**
     * Refill the stock of ingridient
     * @return
     */
	public void Refill() {
		this.stockLeft=10;
		this.alert=false;
	}

	/**
     * Gets the name of ingridient
     * @return
     */
	public String getName() {
		return name;
	}

	/**
     * Sets the name of ingridient
     */
	public void setName(String name) {
		this.name = name;
	}
}


