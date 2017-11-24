
import miPaquete.Fecha;
public final class Perecedero extends Producto {
	
	private Fecha fechaVencimiento;
	
	public Perecedero(int val1, String str1, float val2, Fecha fec) {
		super(val1,str1,val2);
		fechaVencimiento = fec;
	}
		
}
