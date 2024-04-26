public class Main {
    public static void main(String[] args) {
        ConsultaAPI consulta = new ConsultaAPI();
        Conversor conversor = consulta.buscarMoneda("cop");
        System.out.println(conversor);

    }
}