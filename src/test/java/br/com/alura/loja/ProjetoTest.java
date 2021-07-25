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

import br.com.alura.loja.modelo.Projeto;

public class ProjetoTest {
    
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
    public void testaGetProjeto(){
        WebTarget target = client.target(URI.create("http://localhost:8080"));
        Projeto projeto = (Projeto) new XStream().fromXML(target.path("/projetos/1").request().get(String.class));
        Assert.assertEquals(projeto.getNome(), "Minha loja");
    }
}
