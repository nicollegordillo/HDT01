import java.util.Scanner;

//
//
//
//  @ Project : HDT01
//  @ File Name : Principal.java
//  @ Date : 1/16/2023
//  @ Author : Nicolle Gordillo
//
//




public class Principal {
	public static void main(String[] args) {
		Scanner teclado= new Scanner(System.in);
		Radio miradio= new Radio();
		boolean continuar=true;
		boolean continuar2;
		int op1;
		int op2;
		int slot=0;
		String estatus="";
		while(continuar){
			continuar2=true;
			estatus="Apagado";
			System.out.println("-------Radio------");
			System.out.println("Estatus: "+estatus);
			System.out.println("Bienvenido a su radio \n1.Encender \n2.Salir");
			op1 = teclado.nextInt();//variable de eleccion del usuario del menu principal
			teclado.nextLine();//recibe eleccion 
			if(op1==1){
				miradio.on();
				while(continuar2){
					System.out.println("-------Radio------");
					if(miradio.isOn()){
						estatus="Encendido";
					}
					else{
						estatus="Apagado";
					}
					System.out.println("Estatus: "+estatus);
					System.out.println("Frecuencia: "+miradio.getFrequence());
					if(miradio.getFrequence()=="AM"){
						System.out.println("Emisora: "+miradio.getAMActualStation());
					}
					else if(miradio.getFrequence()=="FM"){
						System.out.println("Emisora: "+miradio.getFMActualStation());
					}
					System.out.println("1.Cambiar frecuencia \n2.Subir emisora \n3. Bajar emisora \n4. Guardar emisora actual \n5. Seleccionar emisora guardada \n6. Apagar");
					op2 = teclado.nextInt();
					teclado.nextLine();
					if(op2==1){
						if(miradio.getFrequence()=="AM"){
							miradio.setFrequence("FM");
						}
						else if(miradio.getFrequence()=="FM"){
							miradio.setFrequence("AM");
						}

					}
					else if(op2==2){
						miradio.Forward();

					}
					else if(op2==3){
						miradio.Backward();

					}
					else if(op2==4){
						if(miradio.getFrequence()=="AM"){
							miradio.saveAMStation(miradio.getAMActualStation(), slot);
						}
						else if(miradio.getFrequence()=="FM"){
							miradio.saveFMStation(miradio.getFMActualStation(), slot);
						}
						slot+=1;
					}
					else if(op2==5){
						System.out.println("Ingrese el n??mero donde se encuentra la emisora que desea escuchar");
						slot=teclado.nextInt()-1;
						teclado.nextLine();
						if(miradio.getFrequence()=="AM"){
							System.out.println("Emisora seleccionada: "+miradio.getAMSlot(slot));
						}
						else if(miradio.getFrequence()=="FM"){
							System.out.println("Emisora seleccionada: "+miradio.getFMSlot(slot));
						}

					}
					else if(op2==6){
						miradio.off();
						continuar2=false;
					}
					else{
						System.out.println("Ingrese algo v??lido");
					}
				}

			}
			else if(op1==2){
				continuar=false;
			}
			else{
				System.out.println("Ingrese algo v??lido");
			}
		}
	}
}
