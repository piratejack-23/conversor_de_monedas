import  com.google.gson.JsonElement;
import  com.google.gson.JsonObject;
import  com.google.gson.JsonParser;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversorapp {
    public Conversorapp() {
    }

    public double valorDeCambio(String moneda_base , String moneda_a_convertir) throws IOException, InterruptedException {
        String url ="https://v6.exchangerate-api.com/v6/e16c52d4d8fc43326e46a5e2/pair/";
        //crea el cliente
        HttpClient cliente = HttpClient.newHttpClient();
        //se crea la peticion
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url+moneda_base+"/"+moneda_a_convertir))
                .GET()
                .build();
        //se envia la peticion y llega una respuesta
        HttpResponse<String> response =cliente.send(request,HttpResponse.BodyHandlers.ofString());
        //la respuesta del http la vuelve un texto sin estructura
        String json = response.body();
        //convierte el string en un archivo tipo json
        JsonElement elemento =JsonParser.parseString(json);
        //castea el json en objeto para poder manipularlo
        JsonObject objeto = elemento.getAsJsonObject();
        //obtenemos la tasa de conversion
        return double tasa = objeto.get("conversion_rate").getAsDouble();
    }
    public double convertir(String moneda_base,String moneda_a_convertir , double cantidad){
        double tasa = valorDeCambio(String moneda_base,moneda_a_convertir);
        double resultado = cantidad*tasa;
        return resultado;
    }
}
