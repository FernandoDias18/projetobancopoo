/*
    Classe Transacao
    
Contém os seguintes atributos privados:
i.	descricao, do tipo String
ii.	data, do tipo LocalDate
iii.	valor, do tipo float (que pode ser positivo ou negativo)

Contém os seguintes métodos públicos:
i.	Construtor, getters e setters (verificando se os dados estão validos)
ii.	imprimir todos os dados da transação

*/

package com.aula.poo.classes;

import java.time.LocalDate;
import java.util.Locale;

public class Transacao {
    private String descricao;
    private LocalDate data;
    private float valor;

    public Transacao(String descricao, float valor) {
        this.descricao = descricao;
        this.data = LocalDate.now();
        this.valor = valor;
    }
    public Transacao(String descricao, int dia, int mes, int ano, float valor) {
        String diaformatado = "" + dia;
        String mesformatado = "" + mes;
        this.descricao = descricao;
        assert (ano >= LocalDate.now().getYear() && mes <=12 && mes > 0 && dia > 0 && dia <=31);
        if (mes == LocalDate.now().getMonthValue() && dia < LocalDate.now().getDayOfMonth()) {
            System.out.println("ERRO!");
        } else {
            if (dia < 10) {
                diaformatado = "0" + dia;
            }
            if (mes < 10) {
                mesformatado = "0" + mes;
            }
            this.data = LocalDate.parse(ano + "-" + mesformatado + "-" + diaformatado);
            this.valor = valor;
        }
    }

    public int getDia() {
        return data.getDayOfMonth();
    }

    public void setDia(int dia) {
        data = LocalDate.parse(getAno()+"-"+getMes()+"-"+dia);
    }

    public int getMes() {
        return data.getMonthValue();
    }

    public void setMes(int mes) {
        data = LocalDate.parse(getAno()+"-"+mes+"-"+getDia());
    }

    public int getAno() {
        return data.getYear();
    }

    public void setAno(int ano) {
        data = LocalDate.parse(ano + "-" + getMes() + "-" + getDia());

    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public void status() {
        System.out.println("--------------------------------------");
        System.out.println("Dados transação:");
        System.out.println("Descrição: "+ this.getDescricao());
        System.out.println("Data: " + this.getDia() +"/" + this.getMes()+ "/" + this.getAno());
        System.out.print("Valor: R$ ");
        System.out.printf(Locale.FRANCE,"%.2f", this.getValor());
        System.out.println(" ");
    }
}
