/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fila;

import estruturadedados.EstruturaEstatica;

/**
 *
 * @author luiz
 */
public class Fila<T> extends EstruturaEstatica<T> {
    final int pos = 0;
   
    public Fila(){
        super();
    }
    
    public Fila(int capacidade){
        super(capacidade);
    }
    
    public int retornarOTamanho(){
        return this.tamanho();
    }
    
    public void enfileirar(T elemento){
      /* this.elementos[this.tamanho] = elemento;
        this.tamanho++;*/
      this.adiciona(elemento);
    }
    
    public T espiar(){
        if(this.estaVazia()){
            System.out.println("A fila está vazia.");
            return null;
        }
       return this.elementos[pos]; 
    }
    
    public T desenfileirar(){
        if(this.estaVazia()){
            return null;
        }
        
        T elementoASerRemovido = this.elementos[pos];
        this.remove(pos);
        return elementoASerRemovido;
    }
}
