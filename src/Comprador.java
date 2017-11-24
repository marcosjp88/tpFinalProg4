import java.util.ArrayList;

public class Comprador {
	private int cuit;
	private String razonSocial;
	private ArrayList<Pedido> pedidos;
	private ArrayList<Venta> compras;
	
	public Comprador(int val1, String str1) {
		cuit = val1;
		razonSocial = str1;
		pedidos = new ArrayList<Pedido>();
		compras = new ArrayList<Venta>();
	}
	
	
	public boolean sosComprador(int cod) {
		return cod == cuit;
	}
	
	public String getNombre() {
		return razonSocial;
	}
	
	public void agregarPedido(Pedido ped) {
		pedidos.add(ped);
	}
}
