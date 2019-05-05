/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author nadia
 */
public class Endereco {

    protected String rua;
    protected String cidade;
    protected String bairro;
    protected int cep;
    protected int numero_casa;

    public Endereco()
    {
        super();
    }
    public String getRua() {
        return rua;
    }

    public String getCidade() {
        return cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public int getCep() {
        return cep;
    }

    public int getNumero_casa() {
        return numero_casa;
    }
    
    
    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public void setNumero_casa(int numero_casa) {
        this.numero_casa = numero_casa;
    }
   
}
