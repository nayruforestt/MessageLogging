package logging;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Logging {

    private final String webhookUrl;

    public Logging(String webhookUrl) {
        this.webhookUrl = webhookUrl;
    }

    // the said logToDiscord method
    public void logToDiscord(String player, String message) {
        // final loggedmsg string, using the playerName and message
        String loggedmsg = String.format("{\"content\":\"**%s**: %s\"}", player, message);

        try {
            // creating url
            URL url = new URL(webhookUrl);
            // http connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // requestmethod, requestproperty, output
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            // final stuff before sending request to discord
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = loggedmsg.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            // sending request to discord, meaning we log the message
            connection.getResponseCode();
            // some error handling
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}