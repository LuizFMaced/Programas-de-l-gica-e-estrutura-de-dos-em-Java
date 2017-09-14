//Classe responsavel pela criação da interface de login com o usuario
import javax.swing.*; //pacote de classes de elementos graficos

public class LoginView {
    
    /****DECLARAÇÃO DAS VARIÁVEIS*****/
    
    /*Construindo objeto da classe COntaVO para acesso
    a seus métodos e atributos*/
    public static ContaVO dadosConta = new ContaVO();    
    
    //variaveis que armazenam os dados do usuario
    public static String strNumConta, strSenha;
    
    //variavel que controla a qtde de erros no login
    public static int iErros = 0;
    
    //método construtor
    public LoginView(){
    
        do{
        
        strNumConta = JOptionPane.showInputDialog
                        ("Entre com o número da conta:");
        
        strSenha = JOptionPane.showInputDialog
                        ("Entre com a senha:");
        
        if(dadosConta.acessarConta(strNumConta, strSenha) == true){
            //Acesso ao sistema
            JOptionPane.showMessageDialog(null, "Acesso ao Sistema.");
            //Aqui vai a construção da tela principal
            PrincipalView telaPrincipal = new PrincipalView();
            break;//saindo da repetição
            
            
        }else{
            //Dados Inválidos
            JOptionPane.showMessageDialog(null, "Dados Inválidos",
                        "Falha no Login", JOptionPane.WARNING_MESSAGE);
            iErros++; //acrescentando 1 erro
        }//fechando if...else
        
        }while(iErros < 3); //fechando do...while
        
        if(iErros == 3){
            JOptionPane.showMessageDialog(null, "Sistema Bloqueado",
                            "Erro de Segurança", JOptionPane.ERROR_MESSAGE);
        }
        
    }//fechando construtor
    
}//fechando classe
