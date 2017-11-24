

public abstract class Producto {
	private int codigo;
	private String descripcion;
	private float precio;
	
	public Producto(int val1, String str1, float val2) {
		codigo 		= val1;
		descripcion = str1;
		precio 		= val2;
	}
	
	public boolean sosProducto(int cod) {
		return cod == codigo;
	}
	
	public String getName() {
		return descripcion;
	}
}
