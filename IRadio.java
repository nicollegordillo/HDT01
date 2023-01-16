//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : IRadio.java
//  @ Date : 1/16/2023
//  @ Author : 
//
//




public interface IRadio {
	public void on();
	public void off();
	public boolean isOn();
	public void setFrequence(String freq) throws Exception;
	public String getFrequence();
	public void Forward();
	public void Backward();
	public double getFMActualStation();
	public int getAMActualStation();
	public void setFMActualStation(double actualStation);
	public void setAMActualStation(int actualStation);
	public void saveFMStation(double actualStation, int slot);
	public void saveAMStation(int actualStation, int slot);
	public double getFMSlot(int slot);
	public int getAMSlot(int slot);
}
