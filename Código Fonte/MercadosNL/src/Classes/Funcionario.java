package Classes;

/**
 *
 * @author nadia
 */
public class Funcionario extends Pessoa {

    private String usuario_cadastrado;
    private String senha_cadastrada;
    private String nome_user; //Torna uma constante
    private String senha;
    private String ncarteiratrabalho;
    private date HoraDeEntrada;
    private date HoraDeSaida;

    
    //Construtor padrão
    public Funcionario()
    {
        this.usuario_cadastrado = " ";
        this.senha_cadastrada = " ";
        this.nome_user = " ";
        this.senha = " ";
        this.ncarteiratrabalho = " ";
    }

    //Construtor
    public Funcionario(String usuario_cadastrado, String senha_cadastrada, String nome_user, String senha, String ncarteiratrabalho, String nome, String sexo, int idade, String identidade, int cpf, Endereco end) {
        super(nome, sexo, identidade, cpf, end);
        this.usuario_cadastrado = usuario_cadastrado;
        this.senha_cadastrada = senha_cadastrada;
        this.nome_user = nome_user;
        this.senha = senha;
        this.ncarteiratrabalho = ncarteiratrabalho;
    }

    //Gets
    public String getUsuario_cadastrado() {
        return usuario_cadastrado;
    }

    public String getSenha_cadastrada() {
        return senha_cadastrada;
    }

    public String getNomeUser() {
        return nome_user;
    }

    public String getSenha() {
        return senha;
    }

    public String getNcarteiratrabalho() {
        return ncarteiratrabalho;
    }
    
    public String getNome_user() {
        return nome_user;
    }

    public date getHoraDeEntrada() {
        return HoraDeEntrada;
    }

    public date getHoraDeSaida() {
        return HoraDeSaida;
    }


    //Sets
    public void setUsuario_cadastrado(String usuario_cadastrado) {
        this.usuario_cadastrado = usuario_cadastrado;
    }

    public void setSenha_cadastrada(String senha_cadastrada) {
        this.senha_cadastrada = senha_cadastrada;
    }

    public void setNomeUser(String nome_user) {
        this.nome_user = nome_user;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNcarteiratrabalho(String ncarteiratrabalho) {
        this.ncarteiratrabalho = ncarteiratrabalho;
    }
  
    public boolean FazerLogin1()
    {
       return this.usuario_cadastrado.equals(this.nome_user) && this.senha_cadastrada.equals(this.senha);
    }
   
    public void setHoraDeSaida(date HoraDeSaida) {
        this.HoraDeSaida = HoraDeSaida;
    }
   
   
    public void setNome_user(String nome_user) {
        this.nome_user = nome_user;
    }
    
    public void setHoraDeEntrada(date HoraDeEntrada) {
        this.HoraDeEntrada = HoraDeEntrada;
    }

   //Métodos
   public void VerDadosCadastrais()
   {
       System.out.println("---------------------------------------");
       System.out.println("Nome do funcionário: " + super.getNome());
       System.out.println("Sexo: " + super.getSexo());
       System.out.println("Carteira de Identidade: " + super.getIdentidade());
       System.out.println("CPF: " + super.getCpf());
       System.out.println("Rua: " + super.getEnd().getRua());
       System.out.println("Número da casa: " + super.getEnd().getNumero_casa());
       System.out.println("Cidade: " + super.getEnd().getCidade());
       System.out.println("Cep: " + super.getEnd().getCep());
       System.out.println("Bairro: " + super.getEnd().getBairro());
       System.out.println("------------------------------------------");
   }
   
   public void PesquisarProdutos(){
       
   }
    
}
