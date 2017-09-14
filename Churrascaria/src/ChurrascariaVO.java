
public class ChurrascariaVO {
    
    /**DECLARAÇÃO DOS ATRIBUTOS**/
        
        public static String NF = "";
    
        public static float valorRodizio, 
                            valorAdicionais, 
                            valorEstacionamento,
                            valorTotal;
        
        public static int qtdePessoas;
        public static String bebidas[] = {"Água","Suco","Refrigerante","Cerveja","Batida","Caipirinha","Vinho","Whisky"};
        public static float vBebidas[] = {(float)4,
                                          (float)7.5,  
                                          (float)5,  
                                          (float)7,  
                                          (float)12,  
                                          (float)15,  
                                          (float)78,  
                                          (float)36,  
                                         };
        
        public static String sobremesas[] = {"Gelatina","Sorvete","Petit Gateau","Pudim","Açaí","Torta","Mousse","Café"};
        public static float vSobremesas[] = {(float)5.5,
                                             (float)9,  
                                             (float)14.5,  
                                             (float)8,  
                                             (float)18,  
                                             (float)8,  
                                             (float)6,  
                                             (float)0.5,  
                                            };
            
    public ChurrascariaVO(){
    
        qtdePessoas = 0;
        valorRodizio = (float) 39.9;
        valorEstacionamento = 8;
        valorAdicionais = 0;
        valorTotal = 0;  
        
        NF+="*** RATOS FRITOS ***\r\n";
        NF+="Itaquaquecetuba - CNPJ: 001122/0001\r\n\r\n";
        NF+="Valor do rodizio: R$ " + ChurrascariaView.fmtMoeda.format(valorRodizio) + "\r\n"; 
                
    }//fechando construtor
    
    public static float calcularSubTotal(){
       return valorRodizio * qtdePessoas; 
    }
    
    public static float calcularServicos(){
        float txServico;
        txServico = (calcularSubTotal()+valorAdicionais)*(float)0.1;
        return txServico;
    }
    
    public static float calcularTotal(float tmpEstacionamento){
        float total;
        total = calcularSubTotal() + valorAdicionais + 
                calcularServicos() + tmpEstacionamento;
        return total;
        
    }   
    
    public static void zerarDados(){
        qtdePessoas = 0;
        valorRodizio = (float) 39.9;
        valorEstacionamento = 8;
        valorAdicionais = 0;
        valorTotal = 0;  
        
        NF="*** RATOS FRITOS ***\r\n";
        NF+="Itaquaquecetuba - CNPJ: 001122/0001\r\n\r\n";
        NF+="Valor do rodizio: R$ " + ChurrascariaView.fmtMoeda.format(valorRodizio) + "\r\n"; 
                
    }//fechando zerarDados
    
    
    
}//fechando class
