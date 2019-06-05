package Classes;

import java.util.Scanner;

public class CarrinhoDeCompra {

    private Produto itens[];
    private Produto produto;
    private double totalCompra;
    //private Nota nota_fiscal;
        
    //Construtor
    

    //Get
    /*public Produtos[] getItens() {
    	return itens;
    }*/
    
    public Produto getProduto() {
        return produto;
    }

    public double getTotalCompra() {
        return totalCompra;
    }
    
    /*public Nota getNota_fiscal() {
        return nota_fiscal;
    }*/

    //Set
    /*public void setItens(Produtos[] itens) {
        this.itens = itens;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }*/

    /*public void setNota_fiscal(Nota nota_fiscal) {        
        this.nota_fiscal = nota_fiscal;
    }*/    
    public void setTotalCompra(double totalCompra){
        if(totalCompra > 0){
            this.totalCompra = totalCompra;
        }
    }

    //Metodos
    public void FecharCompra() throws InterruptedException {
        Scanner ler = new Scanner(System.in);
        int resposta3;
        int quantidade;
        //double total = 0;
        CarrinhoDeCompra C1 = new CarrinhoDeCompra();
        do{
            System.out.println("Para Encerrar a compra digite 0;");
            System.out.println("Digite o codigo de Barras do Produto: ");
            resposta3 = ler.nextInt();
            switch(resposta3){
                case 8533:
                    System.out.println("Coca-cola - R$5,00");
                    System.out.printf("Quantidade: ");
                    quantidade = ler.nextInt();
                    C1.TotalCompra(5.00*quantidade);
                    //total += 5.00*quantidade;
                    break;
                case 1845:
                    System.out.println("Miojo Nissin - R$1,50");
                    System.out.printf("Quantidade: ");
                    quantidade = ler.nextInt();
                    C1.TotalCompra(1.50*quantidade);
                    //total += 1.50*quantidade;
                    break;
                case 3889:
                    System.out.println("Batata Pif-Paf - R$5,00");
                    System.out.println("Quantidade: ");
                    quantidade = ler.nextInt();
                    C1.TotalCompra(5.00*quantidade);
                    //total += 5.00*quantidade;
                    break;
                case 2676:
                    System.out.println("Biscoito Maria - R$2,00");
                    System.out.println("Quantidade: ");
                    quantidade = ler.nextInt();
                    C1.TotalCompra(2.00*quantidade);
                    //total += 2.00*quantidade;
                    break;
                case 6237:
                    System.out.println("Sabonete Lux - R$1,00");
                    System.out.println("Quantidade: ");
                    quantidade = ler.nextInt();
                    C1.TotalCompra(1.00*quantidade);
                    //total += quantidade*1.00;
                    break;
                case 0:
                    System.out.println("Fechando a Compra...");
                    Thread.sleep(2000);
                    break;
                default:
                    System.out.println("CODIGO DE PRODUTO INVALIDO!");
                    Thread.sleep(2000);
            }
        }while(resposta3 != 0);
        System.out.println("Total a Pagar: R$" + C1.TotalCompra(0));
        int opcao;
        double valor, troco;
        do{
            System.out.println("Qual a forma de pagamento?");
            System.out.println("1 - Cartão de Crédito");
            System.out.println("2 - Cartão de Débito");
            System.out.println("3 - Dinheiro");
            opcao = ler.nextInt();
            switch(opcao){
                case 1:
                    System.out.println("Pagamento com Cartão de Crédito Selecionado.");
                    System.out.println("Pagamento efetuado com sucesso!");
                    break;
                case 2:
                    System.out.println("Pagamento com Cartão de Débito Selecionado.");
                    System.out.println("Pagamento efetuado com sucesso!");
                    break;
                case 3:
                    System.out.println("Pagamento com Dinheiro Selecionado");
                    System.out.println("Informe o valor dado pelo cliente em Reais: ");
                    do{
                        valor = ler.nextDouble();
                        if(valor < C1.getTotalCompra()){
                            System.out.println("Valor Menor que o total da Compra!");
                            System.out.println("Solicite um valor maior: ");
                        }
                    }while(valor < C1.getTotalCompra());
                    troco = valor - C1.getTotalCompra();
                    System.out.println("Troco do Cliente: R$" + troco);
                    break;
                default:
                    System.out.println("OPCAO INVALIDA!");
            }
        }while(opcao<0 || opcao>3);
    }

    public void ExibeCarrinho() {
        
    }

    public double TotalCompra(double valor){
        CarrinhoDeCompra C1 = new CarrinhoDeCompra();
        double total = C1.getTotalCompra();
        total += valor;
        C1.setTotalCompra(total);
    	return C1.getTotalCompra();
    }

}
