package miPaquete;
import java.util.Scanner;
import java.util.Calendar;

public class Fecha {
	private int dia;
	private int mes;
	private int anio;
	
	public Fecha(int dd, int mm, int aaaa) {
		dia 	= dd;
		mes 	= mm;
		anio 	= aaaa;
	}
	
	public static Fecha hoy() {
		Calendar c 	= Calendar.getInstance();
		int dd 		= c.get(c.DAY_OF_MONTH);
		int mm 		= c.get(c.MONTH);
		int aaaa	= c.get(c.YEAR);
		Fecha hoy 	= new Fecha(dd,mm,aaaa);
		return hoy;
	}
	
	public static Fecha nueva() {
		Scanner entrada = new Scanner(System.in);
		Fecha nueva;
		int dd,mm,aaaa;
		boolean valida;		
		do {
			do {
				System.out.print("Ingrese nro de dia: ");
				dd = entrada.nextInt();
			} while (dd < 1 || dd > 31);
			do {
				System.out.print("Ingrese Año: ");
				aaaa = entrada.nextInt();
			} while (aaaa < 1492 || aaaa > 2100);
				System.out.print("Ingrese nro de mes: ");
				mm = entrada.nextInt();
				if(mm == 4 || mm == 6 || mm == 9 || mm == 11) {
					if (dd == 31) {
						valida = false;
					} else {
						valida = true;
					}
				} else {
					if (mm != 2) {
						valida = true;
					} else {
						if (dd <= 28) {
							valida = true;
						} else {
							if (dd >= 30) {
								valida = false;
							} else {
								if(aaaa % 4 != 0) {
									valida = false;
								} else {
									if(aaaa % 100 != 0) {
										valida = true;
									} else {
										if(aaaa % 400 != 0) {
											valida = false;
										} else {
											valida = true;
										}
									}
								}
							}
							
							
						}
					}
				}
		} while (valida == false);
		nueva = new Fecha(dd,mm,aaaa);
		return nueva;
	}
	
	
	public boolean esIgualA(Fecha otraFecha) {
		if((this.dia() == otraFecha.dia()) && (this.mes() == otraFecha.mes()) && (this.anio() == otraFecha.anio())) {
			return true;
		} else {
			return false;
		}
	}
	
	public int dia() {
		return dia;
	}
	
	public int mes() {
		return mes;
	}
	
	public int anio() {
		return anio;
	}
}