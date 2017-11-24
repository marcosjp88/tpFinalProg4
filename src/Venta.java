import java.util.ArrayList;
import miPaquete.Fecha;

public class Venta {
	private int nroVenta;
	private Pedido pedido;
	private Fecha fecha;
	private ArrayList<DetalleVenta> despachos;
	private float total;
	
	public Venta(int val1, Pedido ped) {
		nroVenta = val1;
		pedido = ped;
		fecha = Fecha.hoy();
		despachos = new ArrayList<DetalleVenta>();
		total = 0;
	}
}
