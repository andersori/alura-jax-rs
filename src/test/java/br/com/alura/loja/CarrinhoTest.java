package br.com.alura.loja;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import com.thoughtworks.xstream.XStream;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.alura.loja.modelo.Carrinho;

public class CarrinhoTest {
    
    Client client = ClientBuilder.newClient();
    static HttpServer server;

    @BeforeClass
    public static void beforeClass(){
        server = Servidor.startaServidor();
    }

    @AfterClass
    public static void afterClass(){
        server.stop();
    }

    @Test
    public void testaQueBuscarUmCarrinhoTrazOCarrinhoEsperado(){
        WebTarget target = client.target(URI.create("http://localhost:8080"));

        Carrinho carrinho = (Carrinho) new XStream().fromXML(target.path("/carrinhos/1").request().get(String.class));
        Assert.assertEquals(carrinho.getRua(), "Rua Vergueiro 3185, 8 andar");
    }
}
