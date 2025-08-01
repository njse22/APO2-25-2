package ui;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {

        Properties properties = new Properties();
        String apiKey = "";
        try {
            properties.load(Main.class.getClassLoader().getResourceAsStream("config.properties"));
            apiKey = properties.getProperty("GEMINI_API_KEY");
        } catch (IOException e) {
            System.out.println("File not Found");
        }

        Client client = Client.builder().apiKey(apiKey).build();



        GenerateContentResponse respose =
                client.models.generateContent("gemini-2.0-flash-001",
                        "Dame una descripción del proyecto googleapis/java-genai", null);


        System.out.println(respose.text());

    }
}
