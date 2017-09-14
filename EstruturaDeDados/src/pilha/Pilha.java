/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilha;

import estruturadedados.EstruturaEstatica;
/**
 *
 * @author luiz
 */
public class Pilha<T> extends EstruturaEstatica<T> {
	
	public Pilha(){
		super();
	}
	
	public Pilha(int capacidade){
		super(capacidade);
	}
	
        public int retornarOTamanho(){
            return this.tamanho();
        }
        
	public void empilha(T elemento){
		super.adiciona(elemento);
	}
	
	public T topo(){
		
		if (this.estaVazia()){
                    System.out.println("A pilha está vazia.");
			return null;
		} 
		
		return this.elementos[tamanho-1];
	}
	
	public T desempilha(){
		
		if (this.estaVazia()){
			return null;
		}
		
		T elemento = this.elementos[tamanho-1];
		tamanho--;
		
		return elemento;
		
		//return this.elementos[--tamanho];
	}
	
}