package funcionalidades;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversorapp {
    private double resultado;
    private double tasa;

    public Conversorapp() {
        this.resultado = 0;
        this.tasa = 0;
    }

    public double getResultado() {
        return resultado;
    }

    public double getTasa() {
        return tasa;
    }

    public double valorDeCambio(String monedaBase, String monedaAConvertir) {
        String url = "https://v6.exchangerate-api.com/v6/e16c52d4d8fc43326e46a5e2/pair/";

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url + monedaBase + "/" + monedaAConvertir))
                    .GET()
                    .build();

            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject objeto = JsonParser.parseString(response.body())
                    .getAsJsonObject();

            return objeto.get("conversion_rate").getAsDouble();

        } catch (IllegalArgumentException e) {
            System.err.println("Ocurrió un error con la URI, verificar excepción");
            throw new RuntimeException("URI inválida", e);
        } catch (Exception e) {
            System.err.println("Ocurrió un error inesperado: " + e);
            throw new RuntimeException("Error al obtener tasa de cambio", e);
        }
    }

    public void convertir(String monedaBase, String monedaAConvertir, double cantidad) {
        this.tasa = valorDeCambio(monedaBase, monedaAConvertir);
        this.resultado = cantidad * tasa;
    }
}