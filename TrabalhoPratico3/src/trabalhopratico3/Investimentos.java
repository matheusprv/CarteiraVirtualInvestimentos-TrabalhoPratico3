/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopratico3;

import java.time.LocalDate;

/**
 *
 * @author Matheus
 */
public class Investimentos {
    private String nome, data;
    private double valorAporte, valorAtual, lucro, retorno;

    public Investimentos(String nome, double valorAporte, double valorAtual, double lucro, double retorno, String data) {
        this.nome = nome;
        this.valorAporte = valorAporte;
        this.valorAtual = valorAtual;
        this.lucro = lucro;
        this.retorno = retorno;
        this.data = data;
    }

    public String getNome() {
        return nome;
    }
    public double getValorAporte() {
        return valorAporte;
    }
    public double getValorAtual() {
        return valorAtual;
    }
    public double getLucro() {
        return lucro;
    }
    public double getRetorno() {
        return retorno;
    }
    public String getData() {
        return data;
    }

    public void setValorAtual(double valorAtual) {
        this.valorAtual = valorAtual;
    }
    public void setLucro(double lucro) {
        this.lucro = lucro;
    }
    public void setRetorno(double retorno) {
        this.retorno = retorno;
    }
    
    
    
    
}
