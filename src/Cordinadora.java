import java.util.Scanner;

public class Cordinadora {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MercadoCentral mc = new MercadoCentral("Mercado central");
		Scanner entrada = new Scanner(System.in);
		byte opc = 0;
		do {
			System.out.println("\n\tMenu");
			System.out.println("\n1: Cargar Producto : ");
			System.out.println("2: Cargar Productor: ");
			System.out.println("3: Cargar Cliente: ");
			System.out.println("4: Crear pedido: ");
			System.out.println("5: Listar Pedidos: ");
			System.out.println("0: Salir");
			System.out.print("Ingrese opc:");
			opc = entrada.nextByte();
			System.out.println("");
			switch (opc) {
				case 1: {
						mc.crearUnProducto();
					}break;
				case 2: {
						mc.crearProveedor();
					}break;
				case 3:{
						mc.crearComprador();
					}break;
				case 4:{
					mc.crearPedido();
					}break;
				case 5:{
					mc.listarPedidos();
					}break;
				case 6:{
					
					}break;
			}
		}while (opc !=0);
	}

}
