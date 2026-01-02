package Menus;
import java.util.Scanner;
import funcionalidades.Conversorapp;

public class MenuChallenge {
    private static final Scanner in = new Scanner(System.in);
    public static void main(String[] args){

        mostrarMenu();
    }

    public static void mostrarMenu() {
        String respuesta;
        do {
            System.out.println("Elige la opcion de Conversion de moneda que deseas hacer");
            System.out.println("1. Peso colombia a Dolar");
            System.out.println("2. dolar a Peso colombiano");
            System.out.println("3. Real brasileño a Dolar");
            System.out.println("4. Dolar a real brasileño");
            System.out.println("5. Peso Argentino a Dolar USA");
            System.out.println("6. Dolar USA a Peso Argentino");
            System.out.println("-------------------------------------------------------");


            System.out.println("la opcion que elegiste:");
            try{
                double cantidad;
                Conversorapp conversor = new Conversorapp();
                int option = in.nextInt();
                switch (option){
                    case 1:
                        System.out.println("ingrese la cantidad la cual desea hacer la conversion");
                        cantidad = in.nextDouble();
                        conversor.convertir("COP","USD",cantidad);
                        System.out.println("la cantidad de pesos colimbianos: "+cantidad +" se convirtio en dolares a: "+conversor.getResultado()+" con una tasa de: "+conversor.getTasa());
                        break;
                    case 2:
                        System.out.println("ingrese la cantidad la cual desea hacer la conversion");
                        cantidad = in.nextDouble();
                        conversor.convertir("USD","COP",cantidad);
                        System.out.println("la cantidad de dolares: "+cantidad +" se convirtio en pesos colombianos a: "+conversor.getResultado()+" con una tasa de: "+conversor.getTasa());
                        break;
                    case 3:
                        System.out.println("ingrese la cantidad la cual desea hacer la conversion");
                        cantidad = in.nextDouble();
                        conversor.convertir("BRL","USD",cantidad);
                        System.out.println("la cantidad de reales brasileños: "+cantidad +" se convirtio en dolares a: "+conversor.getResultado()+" con una tasa de: "+conversor.getTasa());
                        break;
                    case 4:
                        System.out.println("ingrese la cantidad la cual desea hacer la conversion");
                        cantidad = in.nextDouble();
                        conversor.convertir("USD","BRL",cantidad);
                        System.out.println("la cantidad de dolares: "+cantidad +" se convirtio en reales brasileños a: "+conversor.getResultado()+" con una tasa de: "+conversor.getTasa());
                        break;
                    case 5:
                        System.out.println("ingrese la cantidad la cual desea hacer la conversion");
                        cantidad = in.nextDouble();
                        conversor.convertir("ARS","USD",cantidad);
                        System.out.println("la cantidad de pesos argentinos: "+cantidad +" se convirtio en dolares a: "+conversor.getResultado()+" con una tasa de: "+conversor.getTasa());
                        break;
                    case 6:
                        System.out.println("ingrese la cantidad la cual desea hacer la conversion");
                        cantidad = in.nextDouble();
                        conversor.convertir("USD","ARS",cantidad);
                        System.out.println("la cantidad de dolares: "+cantidad +" se convirtio en pesos argentinos a: "+conversor.getResultado()+" con una tasa de: "+conversor.getTasa());
                        break;

                }
            }catch (NumberFormatException e){
                System.out.println("numero invalido vuelve a elegir uno valido");
            }catch (RuntimeException e){
                System.out.println("ha ocurrido un error de ejecucion"+ e);
            } catch (Exception e) {
                System.out.println("ha ocurrido un error inesperado" + e);
            }
            in.nextLine();
            System.out.println("¿desea hacer otro cambio de moneda? Y/N");
            respuesta =in.next();
        }while(respuesta.equals("N"));
        System.out.println("Gracias por haber usado el programa");
    }
}
