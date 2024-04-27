public class Operaciones{
    public Valores seleccion(String seleccion){
        Valores valores = new Valores();
        String value = "";
        if (seleccion.equals("1") || seleccion.equals("3") || seleccion.equals("5")){
            value = "USD";
        } else if (seleccion.equals("2")) {
            value = "ARS";
        } else if (seleccion.equals("4")) {
            value = "BRL";
        } else if (seleccion.equals("6")) {
            value = "COP";
        }
        valores.setValue(value);
        return valores;
    }
}
