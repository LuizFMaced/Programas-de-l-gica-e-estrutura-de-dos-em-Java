import javax.swing.*;

public class XeroxView {
 public static XeroxVO irAteMetodos = new XeroxVO();    
 public static int iOpcao, iQtdEscolhida; //guarda a opção escolhida no menu
   
    public XeroxView(){
    String strMsgMenu = "";
    strMsgMenu+= "Entre com a opção desejada:\n\n";
    strMsgMenu+= "1 - Xerox Preto e Branco\n";
    strMsgMenu+= "2 - Xerox Colorida\n";
    strMsgMenu+= "3 - Ampliação\n";
    strMsgMenu+= "4 - Redução\n";
    strMsgMenu+= "5 - Encardenação\n";
    strMsgMenu+= "6 - Voltar";
    
    do{//não fechar o programar enquanto não selecionar opção 9
    try{// tentar rodar sem erros nas variaveis 
    /*covertendo a informação digitada em um numero inteiro
    e armazenando na variavel iOpcao*/
        iOpcao = Integer.parseInt(JOptionPane.showInputDialog(strMsgMenu));
         if (iOpcao == 1){
           pretoEBranco();
        }else if (iOpcao == 2){ 
          colorida();
        }else if (iOpcao == 3){
          ampliar();
        }else if (iOpcao == 4){ 
          reduzir();
        }else if (iOpcao == 5){ 
          encardenar();
        }else{//Opção Inválida
        }//fechando if...else
    }catch(Exception erro){ //se digitar caracteres invalidos ex:"khfgsdlkfh"
        JOptionPane.showMessageDialog(null, 
        "Caracter inválido!\n Erro orig:" + erro.getMessage(), 
        "ERRO",JOptionPane.ERROR_MESSAGE);
    }//fechando catch
    }while(iOpcao!=6);//fechando Do
    PortalView voltarPortal = new PortalView();
    }//fechando construtor

    public static void pretoEBranco(){
       String iQtd= JOptionPane.showInputDialog(null,"Quantidade a ser impressa:");
        iQtdEscolhida= Integer.parseInt(iQtd);
          irAteMetodos.impressaoNormal(iQtdEscolhida); 
    }
     public static void colorida(){
       String iQtd= JOptionPane.showInputDialog(null,"Quantidade a ser impressa:");
         iQtdEscolhida= Integer.parseInt(iQtd);
           irAteMetodos.impressaoColorida(iQtdEscolhida); 
     }
     public static void ampliar(){
       String iQtd= JOptionPane.showInputDialog(null,"Quantidade a ser impressa:");
         iQtdEscolhida= Integer.parseInt(iQtd);
           irAteMetodos.ampliacao(iQtdEscolhida); 
     }
     public static void reduzir(){
        String iQtd= JOptionPane.showInputDialog(null,"Quantidade a ser impressa:");
         iQtdEscolhida= Integer.parseInt(iQtd);
           irAteMetodos.reducao(iQtdEscolhida); 
     }
      public static void encardenar(){
        String iQtd= JOptionPane.showInputDialog(null,"Quantidade a ser impressa:");
         iQtdEscolhida= Integer.parseInt(iQtd);
           irAteMetodos.encardenacao(iQtdEscolhida);      
      }
       
    
}    
