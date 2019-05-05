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

    public void setLer(Scanner ler) {
        this.ler = ler;
    }

    public void setOpcao(int opcao) {
        this.opcao = opcao;
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

    public Scanner getLer() {
        return ler;
    }

    public int getOpcao() {
        return opcao;
    }
    
  
    Scanner ler = new Scanner(System.in);
    int opcao;
    public void RealizarPagamento()
    {
        
        do{
        System.out.println("Qual a forma de pagamento?");
        System.out.println("1 - Cartão de Crédito");
        System.out.println("2 - Cartão de Débito");
        System.out.println("3 - Dinheiro");
        opcao = ler.nextInt();
        if(opcao==1 || opcao==2 || opcao==3)
        {
            System.out.println("Pagamento efetuado com sucesso!");
        }
        else
        {
            System.out.println("Forma de pagamento inválida");
        }
        }while(opcao<0 || opcao>3);

    }
    
}
