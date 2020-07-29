package main.Utills;

public class Outlet {

	int num;
	boolean IsLocked;
	public Outlet(int n)
	{
		num=n;
		IsLocked=false;
	}

	public void Lock()
	{
		if(IsLocked==false)
			IsLocked=true;
	}

	public void Unlock()
	{
		IsLocked=false;
	}

}