/*
    Classe ContaCorrente
    
Contém os seguintes atributos privados:
i.	agencia, do tipo int
ii.	numero, do tipo int
iii.	array do tipo ArrayList de Transacao
iv.	cliente, do tipo Cliente

Contém os seguintes métodos públicos:
i.	Construtor, getters e setters (verificando se os dados estão validos)
ii.	depositar um valor na conta (adicionar uma transação)
iii.	retirar um valor da conta (adicionar uma transação), desde que o saldo não fique negativo; deve retornar o valor efetivamente retirado. 
Ex. Saldo R$10,00 – retirar $25,00 – Transação criada vai ser de $-10. Saldo ficar 0
iv.	retornar o saldo da conta (somando todas as transações)
v.	extrato todos os dados da conta corrente, suas transações 

Possui a seguinte invariante: o saldo nunca é negativo.

*/

package com.aula.poo.classes;

import java.util.ArrayList;
import java.util.Locale;

public class ContaCorrente {
    private ArrayList<Transacao> array;
    private int numero;
    private int agencia;
    private Cliente cliente;

    public ContaCorrente(int numero, int agencia) {
        this.array = new ArrayList<>();
        this.cliente = cliente;
        assert (agencia > 0 && numero >0);
        this.numero = numero;
        this.agencia = agencia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
       this.cliente = cliente;
    }

    public ArrayList<Transacao> getArray() {
        return array;
    }

    public void setArray(ArrayList<Transacao> array) {
        this.array = array;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public void depositar(Transacao transacao) {
        this.array.add(transacao);
    }
    public void sacar(Transacao transacao){
        float contador = 0.0f;
        for (int i = 0; i <= (array.size() - 1); i++) {
            contador += array.get(i).getValor();
        }
        if(array.isEmpty()) {
            this.array.add(transacao);
            float valor = (transacao.getValor()) * -1;
            transacao.setValor(valor);
        }else if (transacao.getValor() > contador){
            this.array.add(transacao);
            float valor = (transacao.getValor()) * -1;
            transacao.setValor(valor);
        }else {
            this.array.add(transacao);
            transacao.setValor(transacao.getValor());
        }
    }
    public float totalconta(){
        float totalconta = 0.0f;
        for(Transacao t:array){
            totalconta += t.getValor();
            if (t.getValor() < 0){
                totalconta = 0;
            }
        }
        return totalconta;
    }
    public void extrato(){
        System.out.println("Dados conta: ");
        System.out.println("Número: " + this.getNumero() + " Agência: " + this.getAgencia());
        System.out.println("--------------------------------------");
        System.out.println("Lista de transações:");
        if (array.size() == 0) {
            System.out.println("Ainda não foi realizado transação");
        }else {
            for(Transacao t:array) {
                t.status();
            }
        }
        System.out.println("--------------------------------------");
        System.out.print("Saldo: R$ ");
        System.out.printf(Locale.FRANCE,"%.2f", this.totalconta());
        System.out.println(" ");
    }
}
