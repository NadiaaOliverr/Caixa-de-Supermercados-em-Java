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
    
    public static void main(String[] args) throws InterruptedException {
        
        Funcionario F1 = new Funcionario();
        Endereco EndF1 = new Endereco();
        Cliente C1 = new Cliente();
        
        Scanner ler = new Scanner(System.in);
        String usuario;
        String senha;
        int sim_ou_nao;
        
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
            cls();
            System.out.println("Bem vindo ao sistema!");
           
            System.out.println("Deseja ver seus dados cadastrais?");
            sim_ou_nao = ler.nextInt();
            
            
            if(sim_ou_nao==1)
            {
                cls();
                F1.VerDadosCadastrais();
            }else
            {
                cls();
                System.out.println("CAIXA ABERTO!");
                System.out.println("Cliente passando produtos....");
                C1.RealizarPagamento();
                System.out.println("Obrigado por utilizar o sistema!");
            }
            
        }else{
            System.out.println("Usuário ou senha incorretos.");
        }
        
    }
}
