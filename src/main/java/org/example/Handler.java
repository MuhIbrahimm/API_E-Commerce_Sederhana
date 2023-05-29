package org.example;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;

public class Handler {
    public static class handler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if ("GET".equals(exchange.getRequestMethod())){
                OutputStream outputStream = exchange.getResponseBody();
                String responseToBeSentBack = "ini get";
                exchange.sendResponseHeaders(200, responseToBeSentBack.length());

                outputStream.write(responseToBeSentBack.getBytes());
                outputStream.flush();
                outputStream.close();
            }
            if ("POST".equals(exchange.getRequestMethod())){
                OutputStream outputStream = exchange.getResponseBody();
                String responseToBeSentBack = "ini post";
                exchange.sendResponseHeaders(200, responseToBeSentBack.length());

                outputStream.write(responseToBeSentBack.getBytes());
                outputStream.flush();
                outputStream.close();
            }
            if ("PUT".equals(exchange.getRequestMethod())){
                OutputStream outputStream = exchange.getResponseBody();
                String responseToBeSentBack = "ini put";
                exchange.sendResponseHeaders(200, responseToBeSentBack.length());

                outputStream.write(responseToBeSentBack.getBytes());
                outputStream.flush();
                outputStream.close();
            }
            if ("DELETE".equals(exchange.getRequestMethod())){
                OutputStream outputStream = exchange.getResponseBody();
                String responseToBeSentBack = "ini delete";
                exchange.sendResponseHeaders(200, responseToBeSentBack.length());

                outputStream.write(responseToBeSentBack.getBytes());
                outputStream.flush();
                outputStream.close();
            }
        }
    }
}
