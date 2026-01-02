package Menus;
import java.util.Scanner;
import funcionalidades.Conversorapp;

public class MenuElegirMonedas {
    private static final Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        mostrarMenu();
    }
    public static void mostrarMenu(){
        Conversorapp conversor = new Conversorapp();
        String respuesta;
        do {
            System.out.println("Bienvenido al conversor de monedas");
            in.nextLine();
            System.out.println("dame las siglas de la moneda que tienes");
            String moneda_base = in.next();
            in.nextLine();
            System.out.println("dame las siglas de la moneda a la que quieres convertir");
            String moneda_final = in.next();
            in.nextLine();
            System.out.println("dame la cantidad que deseas convertir");
            double cantidad = in.nextDouble();
            conversor.convertir(moneda_base,moneda_final,cantidad);
            System.out.println("el cambio de " + moneda_base+" a "+moneda_final+" es de "+conversor.getResultado());
            in.nextLine();
            System.out.println("¿desea hacer otro cambio? Y/N");
            respuesta = in.next();
        }while(respuesta.equals("N"));
        System.out.println("gracias por haber utilizado el programa");
    }
}

