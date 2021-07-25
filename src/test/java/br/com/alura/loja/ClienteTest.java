package br.com.alura.loja;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.junit.Assert;
import org.junit.Test;

public class ClienteTest {
    
    @Test
    public void testaConexao(){
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://www.mocky.io");
        String response = target.path("/v2/52aaf5deee7ba8c70329fb7d").request().get(String.class);

        Assert.assertTrue(response.contains("<rua>Rua Vergueiro 3185"));
    }
}
