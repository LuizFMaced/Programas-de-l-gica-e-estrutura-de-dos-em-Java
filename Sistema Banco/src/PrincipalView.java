//Classe responsavel pela criação da tela principal do sistema
import javax.swing.*; //pacote de classes de elementos graficos

public class PrincipalView {
  
    /****DECLARAÇÃO DE VARIÁVEIS****/
    public static int iOpcao; //guarda a opção escolhida no menu
    //COnstrução de objeto da classe ContaVO para acesso a seus atributos e metodos
    public static ContaVO dadosConta = new ContaVO();    
    
    /******MÉTODO CONSTRUTOR******/
    public PrincipalView(){
    
        String strMsgMenu = "";
        
        strMsgMenu+= "Entre com a opção desejada:\n\n";
        strMsgMenu+= "1 - Consultar Saldo\n";
        strMsgMenu+= "2 - Efetuar Depósito\n";
        strMsgMenu+= "3 - Efetuar Saque\n";
        strMsgMenu+= "4 - Visualizar Extrato\n";
        strMsgMenu+= "5 - Sair";
        
        do{
        /*Convertendo a informação digitada em um numero inteiro
          e armazenando na variavel iOpcao*/
        
        try{ //tentar
        
        iOpcao = Integer.parseInt(
                JOptionPane.showInputDialog(strMsgMenu));
                
        if(iOpcao == 1){
            //Consultar Saldo
            exibirSaldo();
        }else if(iOpcao == 2){
            //Efetuar Depósito
            exibirDeposito();
        }else if(iOpcao == 3){
            //Efetuar Saque
            exibirSaque();
        }else if(iOpcao == 4){
            //Ver Extrato
            exibirExtrato();
        }else if (iOpcao == 5){
            //Sair
        }else{
            //Opção Inválida
        }
        
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null,
                    "Caracter inválido\n Erro orig:" + erro.getMessage(),"ERRO",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        }while(iOpcao!=5);       
    }//fechando construtor
    
    public static void exibirSaldo(){
        JOptionPane.showMessageDialog(null,
                "Saldo atual: R$: " + 
                        dadosConta.consultarSaldo());
    }//fechando exibirSaldo
    
    public static void exibirDeposito(){
        
        float fDeposito;
        
        fDeposito = Float.parseFloat(JOptionPane.showInputDialog(
                "Entre com o valor do depósito:"));
        dadosConta.depositar(fDeposito);
        JOptionPane.showMessageDialog(null, 
                "Depósito efetuado de: R$ " + dadosConta.fmtMoeda.format(fDeposito));        
    }//fechando exibirDeposito
    
    public static void exibirSaque(){
      
        float fSaque, status;
        
        fSaque = Float.parseFloat(
            JOptionPane.showInputDialog("Entre com o valor: "));
        
        status = dadosConta.sacar(fSaque);
        
        if(status == 0){
            JOptionPane.showMessageDialog(null,
                   "Limite Excedido!");
        }else{
            JOptionPane.showMessageDialog(null,
                   "Saque efetuado de R$ " + dadosConta.fmtMoeda.format(fSaque));
        }
    }//fechando exibirSaque
    
    public static void exibirExtrato(){
        String msgSaldo = "\n\nSaldo atual: R$ " + 
                           dadosConta.consultarSaldo();
        
        JOptionPane.showMessageDialog(
                null, dadosConta.visualizarExtrato() + msgSaldo);
    }
    
}//fechando classe
