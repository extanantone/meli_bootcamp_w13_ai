package distribuidoraDeProductos;

public class Perecedero extends Producto{
	private int diasPorCaducar;
	
	@Override
	protected void calcular(int cantidadDeProductos) {
		this.precio = this.precio * cantidadDeProductos;
		switch(diasPorCaducar) {
			case 1:
				precio /= 4;
				break;
			case 2:
				precio /= 3;
				break;
			case 3:
				precio /= 2; 
				break;
			default: break;
		}
	}

	public int getDiasPorCaducar() {
		return diasPorCaducar;
	}

	public void setDiasPorCaducar(int diasPorCaducar) {
		this.diasPorCaducar = diasPorCaducar;
	}

	public Perecedero(String nombre, double precio, int diasPorCaducar) {
		super(nombre, precio);
		this.diasPorCaducar = diasPorCaducar;
	}

	@Override
	public String toString() {
		return "Perecedero [diasPorCaducar=" + diasPorCaducar + ", nombre=" + nombre + ", precio=" + precio + "]";
	}
}
