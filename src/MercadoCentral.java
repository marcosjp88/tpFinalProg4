import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.crypto.dsig.SignedInfo;

import miPaquete.Fecha;

public class MercadoCentral {
	private String nombre;
	private ArrayList<Producto> productos;
	private ArrayList<Comprador> compradores;
	private ArrayList<Venta> ventas;
	private ArrayList<Pedido> pedidos;
	private ArrayList<Proveedor> proveedores;
	
	public MercadoCentral(String str) {
		nombre 		= str;
		productos	= new ArrayList<Producto>();
		compradores	= new ArrayList<Comprador>();
		ventas 		= new ArrayList<Venta>();	
		pedidos 	= new ArrayList<Pedido>();
		proveedores	= new ArrayList<Proveedor>();
	}
	
	public void crearUnProducto() {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Ingrese el codigo del producto");
		int cod = entrada.nextInt();
		Producto pro = this.buscarProducto(cod);
		if(pro != null) {
			System.out.print("El codigo de producto ya esta siendo utilizado!");
		} else {
			System.out.print("Ingrese la descripcion del producto: ");
			String desc = entrada.next();
			System.out.print("Ingrese el precio del producto: ");
			float pre = entrada.nextFloat();
			String sino;
			do {
			System.out.print("El producto es perecedero? (S/N)");
			sino = entrada.next();
			}while(sino.compareToIgnoreCase("si") != 0 && sino.compareToIgnoreCase("no") != 0);
			if(sino.compareToIgnoreCase("si") == 0) {
				System.out.print("Ingrese la fecha de vencimiento del producto: ");
				Fecha fec = Fecha.nueva();
				pro = new Perecedero(cod,desc,pre,fec);
			} else {
				pro = new NoPerecedero(cod,desc,pre);
			}
			productos.add(pro);
			System.out.print("El producto fue cargado con exito!" );
		}
	
	}
	
	public Producto buscarProducto(int cod) {
		int i = 0;
		while(i < productos.size() && !productos.get(i).sosProducto(cod)) {
			i++;
		}
		if(i == productos.size()) {
			return null;
		} else {
			return productos.get(i);
		}
	}
	
	
	public void crearComprador() {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Ingrese el cuit del cliente");
		int cod = entrada.nextInt();
		Comprador com = this.buscarComprador(cod);
		if(com != null) {
			System.out.print("El numero de cuit ya esta siendo utilizado");
		} else {
			System.out.print("Ingrese la razon social");
			String raz = entrada.next();
			com = new Comprador(cod,raz);
			compradores.add(com);
			System.out.print("El cliente fue creado con exito!");
		}
		
	}
	
	
	public Comprador buscarComprador(int cod) {
		int i = 0;
		while(i < compradores.size() && !compradores.get(i).sosComprador(cod)) {
			i++;
		}
		if(i == compradores.size()) {
			return null;
		} else {
			return compradores.get(i);
		}
	}
	
	
	public void crearProveedor() {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Ingrese el cuit del productor");
		int cod = entrada.nextInt();
		Proveedor prov = this.buscarProveedor(cod);
		if(prov != null) {
			System.out.print("El numero de cuit ya esta siendo utilizado");
		} else {
			System.out.print("Ingrese la razon social");
			String raz = entrada.next();
			prov = new Proveedor(cod,raz);
			proveedores.add(prov);
			System.out.print("El Proveedor1 fue creado con exito!");
		}
		
	}
	
	
	public Proveedor buscarProveedor(int cod) {
		int i = 0;
		while(i < proveedores.size() && !proveedores.get(i).sosProveedor(cod)) {
			i++;
		}
		if(i == proveedores.size()) {
			return null;
		} else {
			return proveedores.get(i);
		}
	}
	
	public void crearPedido() {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Ingrese el codigo del comprador: ");
		int cod = entrada.nextInt();
		Comprador com = this.buscarComprador(cod);
		if(com == null) {
			System.out.print("El codigo no esta asociado a ningun comprador!");
		} else {
			Pedido ped = new Pedido(pedidos.size() + 1, com);
			System.out.print("desea agregar un producto? (Si / No)");
			String sino = entrada.next();
			while(sino.compareToIgnoreCase("si") == 0) {
				System.out.print("Ingrese el codigo del producto ");
				int codP = entrada.nextInt();
				Producto pro = this.buscarProducto(codP);
				if(pro == null) {
					System.out.print("El producto que desea pedir no existe!");
				} else {
					System.out.print("Ingrese la cantidad para " + pro.getName() + " :");
					int cantP = entrada.nextInt();
					ped.agregarProductos(pro, cantP);
				}
				System.out.print("desea agregar otro producto? (Si / No)");
				sino = entrada.next();
			}
			if(ped.tieneProductosCargados()) {
				pedidos.add(ped);
				com.agregarPedido(ped);
				System.out.println("El pedido NRO: " + ped.getNumeroPedido() + " Fue creado con exito!");
			}
		}
	}
	
	public void listarPedidos() {
		if(pedidos.isEmpty()) {
			System.out.print("No hay pedidos cargados!");
		} else {
			System.out.print("--------------- LISTADO DE PEDIDOS-------------\n");
			for (Pedido p : pedidos) {
				System.out.print("Pedido NRO: " + p.getNumeroPedido() + "\n");
				System.out.print("Razon Social Comprador: " + p.getComprador() + "\n");
				System.out.print("Fecha del pedido: " + p.getFecha() + "\n");
				System.out.print("Razon Social Comprador: " + p.getComprador() + "\n");
				System.out.print("Estado del pedido: " + p.getEstado() + "\n");
				System.out.print("---------Listado de productos---------\n");
				p.getListadoDeProductos();
				System.out.print("-----------------------------------------------\n");
			}
			System.out.print("--------------- FIN DE PEDIDOS-------------\n");
		}
	}
	
	
	
	
	
	
	
}
