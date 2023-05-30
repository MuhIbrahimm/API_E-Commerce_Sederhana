package org.example;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;

public class Handler {
    public static class handler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = null;
            if ("GET".equals(exchange.getRequestMethod())){
                response = "ini get";
            } else if ("POST".equals(exchange.getRequestMethod())){
                response = "ini post";
            } else if ("PUT".equals(exchange.getRequestMethod())){
                response = "ini put";
            } else if ("DELETE".equals(exchange.getRequestMethod())) {
                response = "ini delete";
            } else{

            }
            exchange.sendResponseHeaders(200, response.length());
            OutputStream outputStream = exchange.getResponseBody();
            outputStream.write(response.getBytes());
            outputStream.close();
        }
    }
}