import java.text.DecimalFormat;

public class ContaVO {

    //declaração dos atributos
     public static String numeroConta, senha, extrato;
     public static float saldo, limite;
     
     public static DecimalFormat fmtMoeda = new DecimalFormat("0.00");

    /*método construtor - define o estado inicial dos atributos
     Deve ter o mesmo nome da classe*/
     public ContaVO(){
         numeroConta = "112233-4";
         senha = "123456";
         saldo = 0;
         limite = -500;
         extrato = "";
     }//fechando construtor
     
    //demais métodos
     public static boolean acessarConta(String tmpConta, String tmpSenha){
         //tmpConta e tmpSenha são os dados digitados pelo usuario
         
         //compareTo - retorna 0 se as strings forem iguais
         if(tmpConta.compareTo(numeroConta) == 0 && tmpSenha.compareTo(senha)==0)
             return true; // ok
         else
             return false; // erro no login
             
     }//fechando acessarConta
     
     public static String consultarSaldo(){
         return fmtMoeda.format(saldo);
     }//fechando consultarSaldo
     
     public static void depositar(float tmpValor){
         //tmpValor é quanto o usuario deseja depositar
         saldo += tmpValor;  // somando deposito ao saldo
         extrato += "Depósito no valor de R$" + fmtMoeda.format(tmpValor) + "\n"; //atualizando extrato
         
     }
     
     public static float sacar(float tmpValor){
         //tmpValor é o quanto o usuario deseja sacar
         if(saldo - tmpValor >= limite){ //pode sacar             
             saldo-= tmpValor;
             extrato+= "Saque no valor de R$ " + fmtMoeda.format(tmpValor) + "\n";
             return tmpValor;
         }else{ //limite excedido             
             return 0; 
         }//fechando if...else
     }//fechando sacar
     
     public static String visualizarExtrato(){
         return extrato;
     }//fechando visualizarExtrato
     
}//fechando classe
