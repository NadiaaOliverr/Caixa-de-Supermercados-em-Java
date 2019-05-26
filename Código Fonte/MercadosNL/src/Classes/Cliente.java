package Classes;
import java.util.Scanner;
/**
 *
 * @author nadia
 */
public class Cliente extends Pessoa {

    
    private String comprovante_de_renda;
    private String comprovante_de_residencia;
    private double total_das_compras_realizadas;
    
    public void setComprovante_de_renda(String comprovante_de_renda) {
        this.comprovante_de_renda = comprovante_de_renda;
    }

    public void setComprovante_de_residencia(String comprovante_de_residencia) {
        this.comprovante_de_residencia = comprovante_de_residencia;
    }

    public void setTotal_das_compras_realizadas(double total_das_compras_realizadas) {
        this.total_das_compras_realizadas = total_das_compras_realizadas;
    }

    public String getComprovante_de_renda() {
        return comprovante_de_renda;
    }

    public String getComprovante_de_residencia() {
        return comprovante_de_residencia;
    }

    public double getTotal_das_compras_realizadas() {
        return total_das_compras_realizadas;
    }

    public void RealizarPagamento(double totalCompra)
    {
        Scanner ler = new Scanner(System.in);
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
                        if(valor < totalCompra){
                            System.out.println("Valor Menor que o total da Compra!");
                            System.out.println("Solicite um valor: ");
                        }
                    }while(valor < totalCompra);
                    troco = valor - totalCompra;
                    System.out.println("Troco do Cliente: R$" + troco);
                    break;
                default:
                    System.out.println("OPCAO INVALIDA!");
            }
        }while(opcao<0 || opcao>3);

    }
    
}
