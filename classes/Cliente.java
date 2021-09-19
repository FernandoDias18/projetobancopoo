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


import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;



public class Cliente {
    private String nome;
    private ArrayList<ContaCorrente> contaCorrente;

    public Cliente(String nome) {
        this.nome = nome;
        this.contaCorrente = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<ContaCorrente> getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(ContaCorrente contaCorrente) {
        this.contaCorrente.add(contaCorrente);
    }

    public void operar()  {
        for (ContaCorrente c:contaCorrente){
            System.out.println("--------------------------------------");
            System.out.println("Olá " + this.getNome());
            pause(1000);
            for (int i = 0; i < 3; i++) {
                Scanner scanner = new Scanner(System.in);
                Scanner entrada = new Scanner(System.in);
                System.out.println("--------------------------------------");
                System.out.println("Informações conta Agência: " + c.getAgencia() + " Conta: " + c.getNumero());
                System.out.println("--------------------------------------");
                System.out.println("Escolha uma operação:");
                System.out.println("[1] - Depositar");
                System.out.println("[2] - Sacar");
                System.out.println("[3] - Imprimir dados da conta");
                System.out.println("Esolha uma opção: ");
                int escolha = scanner.nextInt();
                if (escolha == 1) {
                    System.out.println("Digite o valor: ");
                    float valor = scanner.nextFloat();
                    System.out.println("Digite a descrição: ");
                    String descricao = entrada.nextLine();
                    System.out.println("Deseja escolher uma data? [S/N]");
                    String data = entrada.nextLine();
                    if (Objects.equals(data, "S") || Objects.equals(data, "s")) {
                        System.out.println("Dia: ");
                        int dia = scanner.nextInt();
                        System.out.println("Mes: ");
                        int mes = scanner.nextInt();
                        System.out.println("Ano: ");
                        int ano = scanner.nextInt();
                        c.depositar(new Transacao(descricao, dia, mes, ano, valor));
                        System.out.println("Transação realizada");
                        pause(1000);
                    } else {
                        c.depositar(new Transacao(descricao, valor));
                        System.out.println("Transação realizada");
                        pause(1000);
                    }

                } else if (escolha == 2) {
                    System.out.println("Digite o valor: ");
                    float valor = scanner.nextFloat();
                    System.out.println("Digite a descrição: ");
                    String descricao = entrada.nextLine();
                    System.out.println("Deseja escolher uma data? [S/N]");
                    String data = entrada.nextLine();
                    if (Objects.equals(data, "S") || Objects.equals(data, "s")) {
                        System.out.println("Dia: ");
                        int dia = scanner.nextInt();
                        System.out.println("Mes: ");
                        int mes = scanner.nextInt();
                        System.out.println("Ano: ");
                        int ano = scanner.nextInt();
                        c.sacar(new Transacao(descricao, dia, mes, ano, valor));
                        System.out.println("Transação realizada");
                    } else {
                        c.sacar(new Transacao(descricao, valor));
                        System.out.println("Transação realizada");
                        pause(1000);
                    }
                } else if (escolha == 3 || escolha != 2 || escolha != 1) {
                    imprimir();
                    System.out.println("--------------------------------------");
                    System.out.print("O saldo das suas contas é R$ ");
                    System.out.printf(Locale.FRANCE, "%.2f", this.saldoTotal());
                    System.out.println(" ");
                }
            }
        }
        System.out.println("--------------------------------------");
        System.out.println("Olá " + this.getNome()+"!! ");
        System.out.print("O saldo das suas contas é R$ ");
        System.out.printf(Locale.FRANCE, "%.2f", this.saldoTotal());
        System.out.println(" ");
    }
    public float saldoTotal() {
        float saldo = 0.0f;
        for (ContaCorrente c:contaCorrente) {
            saldo += c.totalconta();
        }
        return saldo;
    }

    public void imprimir() {
        for (ContaCorrente c : contaCorrente) {
            System.out.println("--------------------------------------");
            System.out.println("Nome: " + this.getNome());
            c.extrato();
        }
    }

    public static void pause(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
}

