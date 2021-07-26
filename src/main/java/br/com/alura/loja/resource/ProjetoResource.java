package br.com.alura.loja.resource;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.thoughtworks.xstream.XStream;

import br.com.alura.loja.dao.ProjetoDAO;
import br.com.alura.loja.modelo.Projeto;

@Path("projetos")
public class ProjetoResource {
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public String busca(@PathParam("id") long id){
        return new ProjetoDAO().busca(id).toXML();
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response adiciona(String conteudo){
        Projeto projeto = (Projeto) new XStream().fromXML(conteudo);
        new ProjetoDAO().adiciona(projeto);

        return Response.created(URI.create("/projetos/" + projeto.getId())).build();
    }


    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") long id){
        new ProjetoDAO().remove(id);

        return Response.ok().build();
    }
}
