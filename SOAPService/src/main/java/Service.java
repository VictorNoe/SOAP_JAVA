import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

@WebService(name = "Service", targetNamespace = "utez")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class Service {
    static Scanner sc = new Scanner(System.in);
    private String work;
    private int count = 0;

    @WebMethod(operationName = "responseMessage")

    public String responsePalabra(@WebParam(name = "message") String menssage) {

        String palabra = (menssage);
        String result = consonantes(palabra);
        return result;

    }

    public String responseNumeros(@WebParam(name = "message") String menssage) {

        String numero = (menssage);
        String result = numeros(numero);
        return result;

    }

    public String responseRFC(@WebParam(name = "message") String name, String apellido11, String apellido22,String anos,String meses,String dias) {

        String nombre = (name);
        String apellido1 = (apellido11);
        String apellido2 = (apellido22);
        String ano = (anos);
        String mes = (meses);
        String dia = (dias);
        String result = rfc(nombre,apellido1,apellido2,ano,mes,dia);
        return result;

    }

    public String consonantes(String palabra) {
        if (count == palabra.length()) {
            return work;
        } else {
            if (!(palabra.charAt(count) == 'a' | palabra.charAt(count) == 'e' | palabra.charAt(count) == 'i' | palabra.charAt(count) == 'o' | palabra.charAt(count) == 'u')) {
                work += palabra.charAt(count);
            }
            count++;
            return consonantes(palabra);
        }
    }

    public String numeros(String numero) {
        int numero1 = Integer.parseInt(numero);
        Random random = new Random();
        int v = random.nextInt(101);
        if (numero1 == v) {
            return "Ganaste tu numero " + numero1 + " es igual a numero ramdom " + v;
        } else {
            return "Perdiste el numero es " + v;
        }

    }

    public String rfc(String nombre, String apellido1, String apellido2, String ano, String mes, String dia){
        String rfc = "";
        int longitud = 3;
        String cadena = cadenaAleatoria(longitud);
        rfc = apellido1.trim().substring(0,2);
        rfc = rfc.concat(apellido2.trim().substring(0,1));
        rfc = rfc.concat(nombre.trim().substring(0,1));
        rfc = rfc.concat(ano.trim().substring(2,4));
        rfc = rfc.concat(mes);
        rfc = rfc.concat(dia);
        rfc = rfc.concat(cadena);
        rfc = rfc.toUpperCase();
        return "Tu rfc es: "+rfc;
    }

    public static int numeroAleatorioEnRango(int minimo, int maximo) {
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }

    public static String cadenaAleatoria(int longitud) {
        String tres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String cadena = "";
        for (int x = 0; x < longitud; x++) {
            int indiceAleatorio = numeroAleatorioEnRango(0, tres.length() - 1);
            char caracterAleatorio = tres.charAt(indiceAleatorio);
            cadena += caracterAleatorio;
        }
        return cadena;
    }

    public static void main(String[] args) {
        Service service = new Service();
        System.out.println("Initialixing server...");
        Endpoint.publish("http://localhost:8080/Service", new Service());
        System.out.println("Weiting requests...");
    }
    //Flores Toledo Víctor Noé
}
