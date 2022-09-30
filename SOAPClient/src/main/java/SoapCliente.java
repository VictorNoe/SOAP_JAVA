import utez.Service;
import utez.ServiceService;
import java.util.Scanner;

public class SoapCliente {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ServiceService service=new ServiceService();
        Service port = service.getServicePort();

        int option = 0;
        do {
            System.out.println("Ingresar opcion: ");
            System.out.println("1)Numero ramdom");
            System.out.println("2)Palabra");
            System.out.println("3)RFC");
            System.out.println("4)Salir");
            option = sc.nextInt();
            switch (option) {
                case 1 :
                    System.out.print("Ingresar el numero del 0 al 100: ");
                    String numero = sc.next();
                    String numeros = port.numeros(numero);
                    System.out.println(numeros);
                    System.out.println();
                    break;
                case 2 :
                    System.out.print("Ingresa la palabra: ");
                    String palabra = sc.next();
                    String consonante = port.consonantes(palabra.toLowerCase());
                    System.out.println(consonante);
                    break;
                case 3 :
                    System.out.print("Ingresa tu nombre: ");
                    String nombre = sc.next();
                    System.out.print("Ingresa tu primer apellido: ");
                    String apellido1 = sc.next();
                    System.out.print("Ingresa tu segundo apellido");
                    String apellido2 = sc.next();
                    System.out.print("Ingresa año de nacimiento: ");
                    String ano = sc.next();
                    System.out.print("Ingresa mes de nacimiento: ");
                    System.out.println("\n1) Enero 2) Febrero 3) Marzo 4) Abril\n5) Mayo 6) Junio 7) Julio 8) Agosto\n9)Septiembre 10) Octubre 11) Noviembre 12) Diciembre");
                    String mes = sc.next();
                    switch (mes) {
                        case "1" :
                            mes = "01";
                            break;
                        case "2" :
                            mes = "02";
                            break;
                        case "3" :
                            mes = "03";
                            break;
                        case "4" :
                            mes = "04";
                            break;
                        case "5" :
                            mes = "05";
                            break;
                        case "6" :
                            mes = "06";
                            break;
                        case "7" :
                            mes = "07";
                            break;
                        case "8" :
                            mes = "08";
                            break;
                        case "9" :
                            mes = "09";
                            break;
                        case "10" :
                            mes = "10";
                            break;
                        case "11" :
                            mes = "11";
                            break;
                        case "12 " :
                            mes = "12";
                            break;
                        default:
                            System.out.println("Opcion incorrecta");
                            break;
                    }
                    System.out.print("Ingresar dia de nacimiento: ");
                    String dia = sc.next();

                    String rfc = port.rfc(nombre,apellido1,apellido2,ano,mes,dia);
                    System.out.println(rfc);
                    break;
                default:
                    System.out.println("Gracias");
                    break;
            }
        }while(option != 4);
        //Flores Toledo Víctor Noé
    }
}
