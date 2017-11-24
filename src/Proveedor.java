import java.util.Hashtable;
import java.util.ArrayList;


public class Proveedor {
	private int cuit;
	private String razonSocial;
	private Hashtable<Producto,Integer> productos;
	private ArrayList<Pago> pagos;
	private ArrayList<Venta> ventas;
	
	public Proveedor(int val1, String str1) {
		cuit  = val1;
		razonSocial = str1;
		productos = new Hashtable<Producto,Integer>();
		pagos = new ArrayList<Pago>();
		ventas = new ArrayList<Venta>();
			
	}
	
	public boolean sosProveedor(int cod) {
		return cod == cuit;
	}
}


