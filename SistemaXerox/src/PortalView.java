

import javax.swing.JOptionPane;


public class PortalView {
    public static XeroxVO irAteMetodos = new XeroxVO();
    public static int iLink;


 public PortalView(){
String strMsgMenu = "";
    strMsgMenu+= "Bem-Vindo a Xerox LTDA\n\n";
    strMsgMenu+= "1 - Selecionar Serviço\n";
    strMsgMenu+= "2 - Relatório de Clientes\n";
    strMsgMenu+= "3 - Relatório de Folhas\n";
    strMsgMenu+= "4 - Relatório de Caixa\n";
    strMsgMenu+= "5 - Sair\n";
   
 do{//não fechar o programar enquanto não selecionar opção 5
    try{// tentar rodar sem erros nas variaveis 
    /*covertendo a informação digitada em um numero inteiro
    e armazenando na variavel iOpcao*/
        iLink = Integer.parseInt(JOptionPane.showInputDialog(strMsgMenu));
         if (iLink == 1){
         XeroxView irAteServicos = new XeroxView();
        }else if (iLink == 2){ 
          clientes();   
        }else if (iLink == 3){
          impressoes();
        }
        else if (iLink == 4){
          ganhos();
        }
        else{//Opção Inválida
        }//fechando if...else
    }catch(Exception erro){ //se digitar caracteres invalidos ex:"khfgsdlkfh"
        JOptionPane.showMessageDialog(null, 
        "Caracter inválido!\n Erro orig:" + erro.getMessage(), 
        "ERRO",JOptionPane.ERROR_MESSAGE);
    }//fechando catch
    }while(iLink!=5);//fechando Do
    }//fechando construtor

    public static void clientes(){
       JOptionPane.showMessageDialog(null, 
               irAteMetodos.visualizarRelatorioClientes());
      }
        
       public static void ganhos(){
        JOptionPane.showMessageDialog(null, 
                irAteMetodos.visualizarRelatorioDeGanhos());
      }
    public static void impressoes(){
        JOptionPane.showMessageDialog(null, 
                irAteMetodos.visualizarRelatoriosImpressoes());
    
    }
 
 
 }







