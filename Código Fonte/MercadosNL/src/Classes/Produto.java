package Classes;

public class Produto {

    private String codigoDeBarras;
    private double preco;
    private int quantidade;
    private String marca;
    private String setor;
    private CarrinhoDeCompra carrinhoDeCompra;

    //Construtor

    public Produto(String codigoDeBarras, double preco, int quantidade, String marca, String setor) {
        this.codigoDeBarras = codigoDeBarras;
        this.preco = preco;
        this.quantidade = quantidade;
        this.marca = marca;
        this.setor = setor;
    }
        
    //Get
    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }
    
    public double getPreco() {
        return preco;
    }
    
    public int getQuantidade() {
        return quantidade;
    }
    
    public String getMarca() {
        return marca;
    }
    
    public String getSetor() {
        return setor;
    }
    
    public CarrinhoDeCompra getCarrinhoDeCompra() {
        return carrinhoDeCompra;
    }

    //Set
    public void setCodigoDeBarras(String codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public void setCarrinhoDeCompra(CarrinhoDeCompra carrinhoDeCompra) {
        this.carrinhoDeCompra = carrinhoDeCompra;
    }
        
        
        
    //Método
    public void ListarDados() {

    }

}
