import javax.swing.*; //importanto pacote de elem.gráf.

public class CarroView {

    //declaração das variaveis
    public static int iTipo;
    
    public CarroView(){
        
        String sMensagem = "";
        sMensagem += "Entre com o tipo de veículo:\n\n";
        sMensagem += "1 - Econômico\n";
        sMensagem += "2 - Esportivo\n";
        sMensagem += "3 - SUV\n";
        sMensagem += "4 - Outros\n";
        
        iTipo = Integer.parseInt(JOptionPane.showInputDialog(sMensagem));
         
        //construindo objeto da classe Carro
        CarroVO novoCarro = new CarroVO(iTipo);
        
        int iAceleracao = 0;
        
        do{
            //tela que solicita a aceleração
           sMensagem = "Velocidade Atual: " + novoCarro.velocidadeAtual + "km/h\n\n";
           sMensagem += "Entre com o valor da aceleração (acima de 300, encerra o programa):";
           
           iAceleracao = Integer.parseInt(JOptionPane.showInputDialog(sMensagem));
           
           if(novoCarro.acelerarCarro(iAceleracao) == 0){
               JOptionPane.showMessageDialog(null,"Velocidade Máxima excedida!");
           } else {          
               JOptionPane.showMessageDialog(null, "O carro foi acelerado a " + iAceleracao + 
                           "km/h. Velocidade Atual: "  + novoCarro.velocidadeAtual + "km/h");
           }
            
        }while(iAceleracao < 300);
        
        JOptionPane.showMessageDialog(null, "Aplicação finalizada...");
        
        
    }   //fechando construtor
    
}//fechando classe
