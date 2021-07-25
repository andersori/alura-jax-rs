package br.com.alura.loja;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Servidor {

    public static HttpServer startaServidor(){
        ResourceConfig config = new ResourceConfig().packages("br.com.alura.loja");
        URI uri = URI.create("http://localhost:8080");
        return GrizzlyHttpServerFactory.createHttpServer(uri, config);
    }
    public static void main(String[] args) throws IOException {
        HttpServer server = startaServidor();

        System.out.println("Servidor Rodando");
        System.in.read();
        server.stop();
    }
}
