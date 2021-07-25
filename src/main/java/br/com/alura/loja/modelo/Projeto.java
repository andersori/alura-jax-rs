package br.com.alura.loja.modelo;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

public class Projeto {
    @SuppressWarnings("unused")
    private long id;
    private String nome;
    @SuppressWarnings("unused")
    private int anoDeInicio;

    public Projeto(){

    }

    public Projeto(long id, String nome, int anoDeInicio){
        this.id = id;
        this.nome = nome;
        this.anoDeInicio = anoDeInicio;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public String toXML(){
        return new XStream().toXML(this);
    }
    public String toJson(){
        return new Gson().toJson(this);
    }
}
