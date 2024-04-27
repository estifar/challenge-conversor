import com.google.gson.Gson;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        while (true){
            Scanner lectura = new Scanner(System.in);
            ConsultaAPI consulta = new ConsultaAPI();
            Operaciones operaciones = new Operaciones();
            System.out.println("\nSeleccione la conversion que desea hacer:");

            System.out.println("******************************************\n" +
                    "1) Dólar => Peso argentino\n" +
                    "2) Peso argentino => Dólar\n" +
                    "3) Dólar => Real brasileño\n" +
                    "4) Real brasileño => Dólar\n" +
                    "5) Dólar => Peso colombiano\n" +
                    "6) Peso colombiano => Dólar\n" +
                    "7) Salir\n" +
                    "*****************************************************");
            var opcionSeleccionada = lectura.nextLine();
            var opcionInvalida = Integer.parseInt(opcionSeleccionada);
            if (opcionInvalida < 7 && opcionInvalida != 0){

                Valores resultado = operaciones.seleccion(opcionSeleccionada);
                System.out.println("Ingrese la cantidad que desea convertir: ");

                Scanner entrada = new Scanner(System.in);
                double cantidad = Double.parseDouble(entrada.nextLine());

                try {

                    Listas listas = consulta.buscarMoneda(resultado.getValue(), cantidad, opcionSeleccionada);
                    String listajson = new Gson().toJson(listas);
                    System.out.println("El resultado de la conversión es: " + listajson);
                }catch (RuntimeException e){
                    System.out.println(e.getMessage());
                    System.out.println("Finalizando la aplicacion.");
                }
            }else {
                System.out.println("Aplicacion finalizada.");
                break;
            }
        }
    }
}