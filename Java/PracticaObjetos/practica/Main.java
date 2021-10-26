package practica;
public class Main {
	public static void main(String[] args) {
		Persona p1 =new Persona();
		Persona p2 =new Persona("prueba",13,"123");
		Persona p3 =new Persona("Jorge",15,"25647896",40,172);
		
		System.out.print(p3.calcularIMC());
		String mayoria = p3.esMayorDeEdad() ? " es mayor " : " es menor ";
		System.out.print(mayoria);
		System.out.print(p3.toString());
	}
}
