/*
    Classe Banco
    
Contém o método main, que realiza os seguintes passos:
i.	cria três instâncias de Cliente (e, consequentemente, as respectivas instâncias de ContaCorrente com pelo menos 2 contas cada cliente)
ii.	chama o método operar para cada instância de Cliente
iii.	imprime os resultados

*/

import com.aula.poo.classes.Cliente;
import com.aula.poo.classes.ContaCorrente;

public class Banco {
    public static void main(String[] args) {
        Cliente c1 = new Cliente("Fernando");
        c1.setContaCorrente(new ContaCorrente(44665,6633));
        c1.setContaCorrente(new ContaCorrente(89667,6441));
        c1.operar();
        Cliente c2 = new Cliente("Lucas");
        c2.setContaCorrente(new ContaCorrente(37865,1375));
        c2.setContaCorrente(new ContaCorrente(46913,9543));
        c2.operar();
        Cliente c3 = new Cliente("Lucas");
        c3.setContaCorrente(new ContaCorrente(89633,4236));
        c3.setContaCorrente(new ContaCorrente(10983,6542));
        c3.operar();

    }
}
