import java.math.RoundingMode;
import java.util.ArrayList;

//
//
//
//  @ Project : HDT01
//  @ File Name : Radio.java
//  @ Date : 1/16/2023
//  @ Author : Nicolle Gordillo
//
//




public class Radio implements IRadio {
	private String freq;
	private double actualStationFM;
	private int actualStationAM;
	private String estado;
	private ArrayList<Double> emisorasFM = new ArrayList<Double>();
	private ArrayList<Integer> emisorasAM = new ArrayList<Integer>();
	private int slot;

	//Enciende el radio
	@Override
	public void on(){
		estado = "on";
	}

	//Apaga el radio
	@Override
	public void off(){
		estado = "off";
	}

	
	/** 
	 * @return boolean
	 */
	//Revisa si la radio está encendida o apagada
	@Override
	public boolean isOn() {
		if(estado=="on"){
			return true;
		}else{
			return false;
		}
		
	}
	
	/** 
	 * @param freq
	 */
	@Override
	public void setFrequence(String freq) {
		this.freq=freq;
		
	}
	
	/** 
	 * @return String
	 */
	@Override
	public String getFrequence() {
		return freq;
	}

	
	/** 
	 * @param )if(freq=="AM"
	 */
	//Cambia la emisora para adelante
	@Override
	public void Forward() {//**
		if(freq=="AM"){
			if(actualStationAM==1610){
				actualStationAM=530;
			}
			else{
				actualStationAM=actualStationAM+10;
			}

		}
		else if(freq=="FM"){
			if(actualStationFM==107.9){
				actualStationFM=87.9;

			}
			else{
				actualStationFM=actualStationFM+0.2;
				actualStationFM=Math.round((actualStationFM) * 10) / 10.0;
			}
		}
		else{

		}
	}

	//Cambia la emisora para atras
	@Override
	public void Backward() {
		if(freq=="AM"){
			if(actualStationAM==530){
				actualStationAM=1610;
				

			}
			else{
				actualStationAM=actualStationAM-10;
			}
		}
		else if(freq=="FM"){
			if(actualStationFM==87.9){
				actualStationFM=107.9;
				

			}
			else{
				actualStationFM=actualStationFM-0.2;
				actualStationFM=Math.round((actualStationFM) * 10) / 10.0;
			}
		}
		else{

		}
	}
	
	/** 
	 * @return double
	 */
	@Override
	public double getFMActualStation() {
		return actualStationFM;
	}
	
	/** 
	 * @return int
	 */
	@Override
	public int getAMActualStation() {
		return actualStationAM;
	}
	
	/** 
	 * @param actualStation
	 */
	@Override
	public void setFMActualStation(double actualStation) {
		this.actualStationFM = actualStation;
	}
	
	/** 
	 * @param actualStation
	 */
	@Override
	public void setAMActualStation(int actualStation){
		this.actualStationAM= actualStation;
	}

	
	/** 
	 * @param actualStation
	 * @param slot
	 */
	//Guardar estacion en frecuencia FM
	@Override
	public void saveFMStation(double actualStation, int slot) {
		if(emisorasFM.size()<=12){
			emisorasFM.add(actualStation);
		}
	}

	
	/** 
	 * @param actualStation
	 * @param slot
	 */
	//Guardar estacion en frecuencia AM
	@Override
	public void saveAMStation(int actualStation, int slot) {
		if(emisorasAM.size()<=12){
			emisorasAM.add(actualStation);
		}
	}

	
	/** 
	 * @param slot
	 * @return double
	 */
	//Selecciona la emisora en el slot deseado FM
	@Override
	public double getFMSlot(int slot) {
		if(slot<emisorasAM.size()){
			actualStationFM= emisorasFM.get(slot);
			return emisorasFM.get(slot);
		}
		else{
			return 0;
		}
		
	}

	
	/** 
	 * @param slot
	 * @return int
	 */
	//Selecciona la emisora en el slot deseado AM
	@Override
	public int getAMSlot(int slot) {
		if(slot<emisorasAM.size()){
			actualStationAM= emisorasAM.get(slot);
			return emisorasAM.get(slot);
		}
		else{
			return 0;
		}
		
	}
	//constructores
	public Radio() {
		freq="AM";
		slot=0;
		actualStationFM=87.9;
		actualStationAM=530;
		estado="off";
	}
	
	public Radio(String freq, int slot, double actualStationFM, String estado, int actualStationAM) {
		this.freq=freq;
		this.slot=slot;
		this.actualStationFM=actualStationFM;
		this.actualStationAM=actualStationAM;
		this.estado=estado;
	}
	
	
}
