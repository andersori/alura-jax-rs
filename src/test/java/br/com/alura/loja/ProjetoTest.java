package br.com.alura.loja;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Configuration;

import org.junit.Assert;
import org.junit.Test;

public class ProjetoTest {
    
    Client client = ClientBuilder.newClient();

    @Test
    public void testaGetProdutos(){
        WebTarget target = client.target(URI.create("http://localhost:8080"));
        Assert.assertTrue(target.path("/projetos").request().get(String.class).contains("<nome>Minha loja</nome>"));
    }
}
