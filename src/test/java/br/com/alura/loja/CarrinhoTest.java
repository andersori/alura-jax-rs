package br.com.alura.loja;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.thoughtworks.xstream.XStream;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.alura.loja.modelo.Carrinho;
import br.com.alura.loja.modelo.Produto;

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

    @Test
    public void testaCriacaoDoCarrinho(){
        WebTarget target = client.target("http://localhost:8080");

        Carrinho carrinho = new Carrinho();
        carrinho.setRua("Rua Vergueiro");
        carrinho.setCidade("Sao Paulo");
        carrinho.adiciona(new Produto(314l, "Tablet", 999, 1));

        Entity<String> entity = Entity.entity(carrinho.toXML(), MediaType.APPLICATION_XML);

        Response res = target.path("/carrinhos").request().post(entity);

        Assert.assertEquals("<status>Sucesso</status>", res.readEntity(String.class));
    }
}
