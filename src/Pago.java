
public class Pago {
	private Comprador comprador;
	private Proveedor proveedor;
	private Venta venta;
	private float importe;
	
	public Pago(Comprador comp, Proveedor prov, Venta ven, float val1) {
		comprador 	= comp;
		proveedor 	= prov;
		venta 		= ven;
		importe 	= val1;
	}
	
	
}
