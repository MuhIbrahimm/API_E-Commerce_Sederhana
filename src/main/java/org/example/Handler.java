package org.example;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class Handler {
    public static class handlerUser implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = null;
            if ("GET".equals(exchange.getRequestMethod())) {
                response = Query.getAllUsers();
            } else if ("POST".equals(exchange.getRequestMethod())) {
                // Implementasi untuk permintaan POST
            } else if ("PUT".equals(exchange.getRequestMethod())) {
                // Implementasi untuk permintaan PUT
            } else if ("DELETE".equals(exchange.getRequestMethod())) {
                // Implementasi untuk permintaan DELETE
            } else {
                // Metode HTTP tidak dikenali
                response = "Metode HTTP tidak dikenali";
            }

            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream outputStream = exchange.getResponseBody();
            outputStream.write(response.getBytes());
            outputStream.close();
        }
    }
}
