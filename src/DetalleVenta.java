
public class DetalleVenta {
	private Proveedor proveedor;
	private Producto producto;
	private int cantidad;
	private float precioUnitario;
	
	public DetalleVenta(Proveedor prov, Producto pro, int cant, float pre) {
		proveedor = prov;
		producto = pro;
		cantidad = cant;
		precioUnitario = pre;
	}
	
	
	
}
