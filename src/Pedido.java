import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

import miPaquete.Fecha;

public class Pedido {
	private int nroPedido;
	private Fecha fecha;
	private Hashtable<Producto,Integer> productos;
	private Comprador comprador;
	private boolean pendiente;
	
	public Pedido(int nro,Comprador comp) {
		nroPedido = nro;
		comprador = comp;
		pendiente = true;
		fecha = Fecha.hoy();
		productos = new Hashtable<Producto,Integer>();
	}
	
	
	public void agregarProductos(Producto pro, int cant) {
		Scanner entrada = new Scanner(System.in);
		if(productos.get(pro) != null) {
			System.out.print("El producto ya esta en el pedido desea sumar esta cantidad al pedido? (Si / No");
			String sino = entrada.next();
			if(sino.compareToIgnoreCase("si") == 0) {
				productos.put(pro,productos.get(pro) + cant);
				System.out.print("la cantidad fue actualizada con exito!");
			}
		} else {
			productos.put(pro, cant);
			System.out.println("El producto fue agregado con exito!");
		}
	}
	
	public boolean tieneProductosCargados() {
		return !productos.isEmpty(); 
	}
	
	public int getNumeroPedido()
	{
		return nroPedido;
	}
	
	public String getComprador() {
		return comprador.getNombre();
	}
	
	public String getFecha() {
		return fecha.dia() + "/" + fecha.mes() + "/" + fecha.anio();
	}
	
	public String getEstado() {
		if(pendiente) {
			return "Pendiente";
		} else {
			return "Completado";
		}
	}
	
	
	public void getListadoDeProductos() {
		Enumeration<Producto> enumeration = productos.keys();
		Producto pro;
		while (enumeration.hasMoreElements()) {
			pro = enumeration.nextElement();
			System.out.println(""+"Producto: " + pro.getName() + " Cantidad pedida: " + productos.get(pro));
			 
		}
	}
}
