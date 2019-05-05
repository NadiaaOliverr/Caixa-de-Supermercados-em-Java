package Classes;
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
        /*System.out.println("3. Menu do Gerente.");*/
        System.out.println("0. Sair do sistema.");
        System.out.printf("Digite a opção desejada: ");
    }
    
    public static void main(String[] args) throws InterruptedException {
        
        Funcionario F1 = new Funcionario();
        Endereco EndF1 = new Endereco();
        Cliente C1 = new Cliente();
        
        Scanner ler = new Scanner(System.in);
        String usuario;
        String senha;
        int resposta1, resposta2, meta = 0;
        
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
        F1.setNome("José Augusto");
        F1.setUsuario_cadastrado("JoseSilva");
        F1.setSenha_cadastrada("45678");
        
        
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
                        for(meta = 0; meta < 2; meta++){//Meta representa meta de vendas diaria
                            cls();
                            System.out.println("CAIXA ABERTO!");
                            System.out.println("Cliente passando produtos....");
                            C1.RealizarPagamento();
                            System.out.println("Obrigado por utilizar o sistema!");
                            Thread.sleep(5000);
                        }
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
                }
            }while(resposta1 != 0);
        }        
    }
}
