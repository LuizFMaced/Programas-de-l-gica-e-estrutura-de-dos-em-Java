
public class CarroVO {
   
    //declaração dos atributos
    public static int velocidadeInicial;
    public static int velocidadeAtual;
    public static int velocidadeMaxima;
    public static String tipo;
    
    //Método Construtor - definir o status inicial dos atributos
    public CarroVO(int tmpTipo){
        velocidadeInicial = 0;
        velocidadeAtual = 0;
                
        if(tmpTipo == 1){ 
            velocidadeMaxima = 180;
            tipo = "Econômico";
        }else if (tmpTipo == 2){ 
            velocidadeMaxima = 240;
            tipo = "Esportivo";
        }else if (tmpTipo == 3){
            velocidadeMaxima = 200;
            tipo = "SUV";
        }else{        
            velocidadeMaxima = 120;
            tipo = "Padrão";
        }//fechando if...else
        
    }//fechando construtor
    
    public static int acelerarCarro(int tmpAceleracao){
        
        if(velocidadeAtual + tmpAceleracao <= velocidadeMaxima)
           velocidadeAtual += tmpAceleracao;
        else
            return 0; //erro de limite de velocidade
        
        return velocidadeAtual; //aceleração efetuada       
    
    }//fechando acelerar
    
}//fechando classe
