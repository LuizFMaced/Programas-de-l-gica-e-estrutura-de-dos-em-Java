
public class XeroxVO {
    
    public static float xeroxPb,xeroxColorida,ampliacao ;
    public static float reducao, encardenacao;
    public static int totalImpressoes;
    public static float totalLucro, totalPb, totalCo, totalAm, totalRe,totalEn; 
    public static int totalClientes,clientePb, clienteCo, clienteAm, clienteRe, clienteEn;

  public XeroxVO(){
      xeroxPb = 0.10f;
      xeroxColorida = 1.00f;
      ampliacao = 0.50f;
      reducao = 2.50f;
      encardenacao = 5.00f;
      totalLucro= 0;
      totalPb =0; 
      totalCo=0;
      totalAm=0;
      totalRe=0;
      totalEn=0; 
      totalClientes= 0;
      clientePb = 0;
      clienteCo = 0;
      clienteAm = 0;
      clienteRe = 0;
      clienteEn = 0;
      totalImpressoes = 0;
  }
  
    public static void impressaoNormal(int tmpQtdFolhas){
     totalPb+= (tmpQtdFolhas*xeroxPb);
       totalImpressoes+= tmpQtdFolhas;
        clientePb ++;     
    }
    
     public static void impressaoColorida(int tmpQtdFolhas){
      totalCo+= (xeroxColorida*tmpQtdFolhas);
      totalImpressoes+= tmpQtdFolhas;
        clienteCo ++;
      
    }
     public static void ampliacao(int tmpQtdFolhas){
      totalAm+= (ampliacao*tmpQtdFolhas);
      totalImpressoes+= tmpQtdFolhas;
        clienteAm ++; 
    
    }
      public static void reducao(int tmpQtdFolhas){
     totalRe+= (reducao*tmpQtdFolhas);
     totalImpressoes+= tmpQtdFolhas;
       clienteRe++;
    }
     public static void encardenacao(int tmpQtdFolhas){
      totalEn+= (encardenacao*tmpQtdFolhas);
      totalImpressoes+= tmpQtdFolhas;
        clienteEn ++;
    }
     public static String visualizarRelatorioClientes(){
       String relatorio= "";
        
       relatorio+= "Relatório de serviço\n";
       relatorio+= "Clientes atendidos em\n";
       relatorio+= "\n Xerox Preto&Branco: "+clientePb;
       relatorio+= "\n Xerox Colorida: " + clienteCo;
       relatorio+= "\n Ampliação: "+clienteAm;
       relatorio+= "\n Redução: "+clienteRe;
       relatorio+= "\n Encardenação: "+clienteEn;
       relatorio+= "\n Total: "+(totalClientes = clientePb+clienteCo+
       clienteAm+clienteRe+clienteEn)+" clientes";
       
     
       return relatorio;   
    }
    public static String visualizarRelatorioDeGanhos(){
       String relatorio= "";
        
       relatorio+= "Relatório de serviço\n";
       relatorio+= "Dinheiro recebido em\n";
       relatorio+= "\n Xerox Preto/Branco: " +totalPb;
       relatorio+= "\n Xerox Colorida: " +totalCo;
       relatorio+= "\n Ampliação: "+totalAm;
       relatorio+= "\n Redução: "+totalRe;
       relatorio+= "\n Encardenação: "+totalEn;
       relatorio+= "\n Total de R$"+(totalLucro=totalPb+totalCo+totalAm+
               totalRe+totalEn);
       
       
       return relatorio;   
    }
    public static String visualizarRelatoriosImpressoes(){
        String relatorio= "";
        
        relatorio+= "Relatório de serviço\n";
        relatorio+= "\n Total: "+totalImpressoes+" impressões";
        
        return relatorio;
    }
}    
  














