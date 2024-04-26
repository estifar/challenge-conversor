import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaAPI {
    public Conversor buscarMoneda(String tipoDeMoneda){

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/0fe1ced8fd70536355ef4f6b/latest/" + tipoDeMoneda);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        //System.out.println(response.body());
        var prueba = response.body();
        //System.out.println("Esto es una prueba: " + prueba);
        return new Gson().fromJson(response.body(), Conversor.class);
    }
}
