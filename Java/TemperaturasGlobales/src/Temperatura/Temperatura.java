package Temperatura;
import java.util.Scanner;
public class Temperatura {
	private String ciudades[] = new String [10];
	private int temperaturas[][] = new int [10][2];
	public void llenarVectorCiudades(Scanner sc) {
		for(int i=0;i<9;i++) {
			System.out.print("Ingrese ciudad: ");
			this.ciudades[i] = sc.nextLine();
		}
		System.out.println("Se ha terminado de llenar el vector de ciudades");
	}
	public void llenarMatrizTemperaturas(Scanner sc) {
		for(int i=0;i<9;i++) {
			System.out.print("Ingrese la minima de "+this.ciudades[i]+": ");
			this.temperaturas[i][0]=sc.nextInt();
			System.out.print("Ingrese la maxima de "+this.ciudades[i]+": ");
			this.temperaturas[i][1]=sc.nextInt();
		}
		System.out.println("Se ha terminado de llenar la matriz de temperaturas");
	}
	public void buscarMinimosYMaximos() {
		int minimo = 9999;
		String ciudadMinima="";
		int maximo = -1;
		String ciudadMaxima="";
		for(int i=0;i<9;i++) {
			for(int j=0;j<2;j++) {
				if(this.temperaturas[i][j] < minimo) {
					minimo = this.temperaturas[i][j];
					ciudadMinima = this.ciudades[i];
				}
				if(this.temperaturas[i][j] > maximo){
					maximo = this.temperaturas[i][j];
					ciudadMaxima = this.ciudades[i];
				}
			}
		}
		System.out.println("La ciudad con menos temperatura es "+ciudadMinima+" con una temperatura de "+minimo);
		System.out.println("La ciudad con mayor temperatura es "+ciudadMaxima+" con una temperatura de "+maximo);	
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Temperatura temp = new Temperatura();
		temp.llenarVectorCiudades(sc);
		temp.llenarMatrizTemperaturas(sc);
		sc.close();
		temp.buscarMinimosYMaximos();
		System.out.print("Finaliza la ejecucion del programa principal");
	}
}
