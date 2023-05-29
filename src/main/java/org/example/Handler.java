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

            } else if ("POST".equals(exchange.getRequestMethod())){

            } else if ("PUT".equals(exchange.getRequestMethod())){

            } else if ("DELETE".equals(exchange.getRequestMethod())) {

            } else{

            }
        }
    }
}
