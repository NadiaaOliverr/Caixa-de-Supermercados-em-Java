package Classes;

public class DadosSupermercado {

    private int cnpj;
    private Endereco endereco;
    private int telefone;
    private NotaFiscal nota_fiscal;
        
    //Construtor

    public DadosSupermercado(int cnpj, Endereco endereco, int telefone) {
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.telefone = telefone;
    }
    
    
    //Get
    public int getCnpj() {
        return cnpj;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public int getTelefone() {
        return telefone;
    }

    public NotaFiscal getNota_fiscal() {
        return nota_fiscal;
    }
    
    //Set
    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public void setNota_fiscal(NotaFiscal nota_fiscal) {
        this.nota_fiscal = nota_fiscal;
    }
    //Metodo

}
