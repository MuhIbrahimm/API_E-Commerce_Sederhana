package org.example;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress("localhost", 8083), 0);
        httpServer.createContext("/e-commerce", new Handler.handler());
        httpServer.setExecutor(Executors.newSingleThreadExecutor());
        httpServer.start();
    }


}