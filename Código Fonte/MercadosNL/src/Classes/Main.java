package Classes;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author nadia
 */

public class Main {
    public static void cls()
    {
            for(int i = 0; i < 50; i++)
            System.out.println("");
    }
    public static void imprimeMenu(){
        System.out.println("-- Menu do Usuário -- ");
        System.out.println("1. Abrir Vendas.");
        System.out.println("2. Ver seus dados cadastrais.");
        System.out.println("0. Sair do sistema.");
        System.out.printf("Digite a opção desejada: ");
    }
        
    public static double passarCompras() throws InterruptedException{
        Scanner ler = new Scanner(System.in);
        int resposta3 = 0;
        int quantidade;
        double total = 0;
        do{
            cls();
            System.out.println("Para Encerrar a compra digite 0;");
            System.out.println("Digite o codigo de Barras do Produto: ");
            resposta3 = ler.nextInt();
            switch(resposta3){
                case 8533:
                    System.out.println("Coca-cola - R$5,00");
                    System.out.printf("Quantidade: ");
                    quantidade = ler.nextInt();
                    total += 5.00*quantidade;
                    break;
                case 1845:
                    System.out.println("Miojo Nissin - R$1,50");
                    System.out.printf("Quantidade: ");
                    quantidade = ler.nextInt();
                    total += quantidade*1.50;
                    break;
                case 3889:
                    System.out.println("Batata Pif-Paf - R$5,00");
                    System.out.println("Quantidade: ");
                    quantidade = ler.nextInt();
                    total += quantidade*5.00;
                    break;
                case 2676:
                    System.out.println("Biscoito Maria - R$2,00");
                    System.out.println("Quantidade: ");
                    quantidade = ler.nextInt();
                    total += quantidade*2.00;
                    break;
                case 6237:
                    System.out.println("Sabonete Lux - R$1,00");
                    System.out.println("Quantidade: ");
                    quantidade = ler.nextInt();
                    total += quantidade*1.00;
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
        return total;
    }
    
    public static void main(String[] args) throws InterruptedException{
        
        Funcionario F1 = new Funcionario();
        Endereco EndF1 = new Endereco();
        Cliente C1 = new Cliente();
        
        Scanner ler = new Scanner(System.in);
        String usuario;
        String senha;
        int resposta1, resposta2;
        double total = 0.0;
        
        C1.setComprovante_de_renda("R$ 1000");
        C1.setComprovante_de_residencia("Rua Joao Mariano da Rocha");
        C1.setTotal_das_compras_realizadas(3000);
        
        
        EndF1.setBairro("Centro");
        EndF1.setCep(45678900);
        EndF1.setNumero_casa(89);
        EndF1.setCidade("Rio Paranaíba");
        EndF1.setRua("Narcísio Cândido");
        F1.setIdentidade("MG 12345");
        F1.setEnd(EndF1);
        F1.setCpf(123456789);
        F1.setNcarteiratrabalho("MG-18456789");
        F1.setIdade(20);
        F1.setSexo("Masculino");
        F1.setNome("Joao Batista");
        F1.setUsuario_cadastrado("JoaoBatista");
        F1.setSenha_cadastrada("516281");
        
        
        do{
            cls();
            System.out.println("Bem vindo ao TEC VENDAS");
            System.out.println("Usuário: ");
            usuario = ler.nextLine();
            F1.setNomeUser(usuario);
        
            System.out.println("Senha: ");
            senha = ler.nextLine();
            F1.setSenha(senha);
            if(F1.FazerLogin()==false){
                System.out.println("Usuário invalido! Digite Novamente.");
                Thread.sleep(2000);
            }
        }while(F1.FazerLogin()==false);
        
        if(F1.FazerLogin()==true)
        {
            do{
                cls();
                System.out.println("Bem vindo ao sistema!");
                imprimeMenu();
                resposta1 = ler.nextInt();
                switch(resposta1){
                    case 1:
                        cls();
                        System.out.println("CAIXA ABERTO!");
                        System.out.println("Cliente passando produtos....");
                        Thread.sleep(4000);
                        total = passarCompras();
                        cls();
                        System.out.println("Total a Pagar: R$" + total);
                        C1.RealizarPagamento();
                        System.out.println("Obrigado por utilizar o sistema!");
                        Thread.sleep(5000);
                        break;
                    case 2:
                        do{
                            cls();
                            F1.VerDadosCadastrais();
                            System.out.println("Deseja voltar ao menu anterior? (1 - SIM/0 - NÃO)");
                            resposta2 = ler.nextInt();
                        }while(resposta2 != 1);
                        break;
                    case 0:
                        cls();
                        System.out.println("Saindo do Sistema...");
                        Thread.sleep(2000);
                        break;
                    default:
                        System.out.println("OPÇÃO INVALIDA!");
                }
            }while(resposta1 != 0);
        }        
    }
}
