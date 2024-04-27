import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsultaAPI{
    public Listas buscarMoneda(String tipoDeMoneda, double cantidad, String opcionSeleccionada){

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/0fe1ced8fd70536355ef4f6b/latest/" + tipoDeMoneda);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            var prueba = response.body();
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(prueba, JsonObject.class);
            JsonObject conversion_rates = jsonObject.getAsJsonObject("conversion_rates");
            Conversor conversor = new Conversor();
            Map<String, Double> valores = gson.fromJson(conversion_rates, HashMap.class);
            Map.Entry<String, Double>[] array = valores.entrySet().toArray(new Map.Entry[0]);

            Listas listas = new Listas();
            ArrayList<Coin> coinList = new ArrayList<Coin>();
            for (Map.Entry<String, Double> coin: array) {
                Coin singleCoin = new Coin();

                if (opcionSeleccionada.equals("1") && coin.getKey().equals("ARS")){
                    singleCoin.setName(coin.getKey());
                    singleCoin.setValue(coin.getValue() * cantidad);
                    coinList.add(singleCoin);

                } else if (opcionSeleccionada.equals("2") && coin.getKey().equals("USD")) {
                    singleCoin.setName(coin.getKey());
                    singleCoin.setValue(coin.getValue() * cantidad);
                    coinList.add(singleCoin);
                } else if (opcionSeleccionada.equals("3") && coin.getKey().equals("BRL")) {
                    singleCoin.setName(coin.getKey());
                    singleCoin.setValue(coin.getValue() * cantidad);
                    coinList.add(singleCoin);
                } else if (opcionSeleccionada.equals("4") && coin.getKey().equals("USD")) {
                    singleCoin.setName(coin.getKey());
                    singleCoin.setValue(coin.getValue() * cantidad);
                    coinList.add(singleCoin);
                } else if (opcionSeleccionada.equals("5") && coin.getKey().equals("COP")) {
                    singleCoin.setName(coin.getKey());
                    singleCoin.setValue(coin.getValue() * cantidad);
                    coinList.add(singleCoin);
                } else if (opcionSeleccionada.equals("6") && coin.getKey().equals("USD")) {
                    singleCoin.setName(coin.getKey());
                    singleCoin.setValue(coin.getValue() * cantidad);
                    coinList.add(singleCoin);
                }
            }
            listas.setCoin(coinList);
            return listas;

        } catch (Exception e) {
            throw new RuntimeException("Seleccion no valida.");
        }
    }
}
