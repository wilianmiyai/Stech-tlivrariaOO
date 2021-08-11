/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.util.ArrayList;
import model.cliente;

/**
 *
 * @author wilian
 */
public class CClientes {

    ArrayList<cliente> clientes = new ArrayList<>();
    
    public void mokClientes() {
        cliente cli = new cliente();
        cli.setIdCliente(1);
        cli.setNomeCliente("wilian leal");
        cli.setCpf("123");
        cli.setCnpj(null);
        cli.setEndereco("rua maria");
        cli.setTelefone("51 12345678");
        this.addCliente(cli);
        cliente cli2 = new cliente();
        cli2.setIdCliente(2);
        cli2.setNomeCliente("cintia leal");
        cli2.setCpf(null);
        cli2.setCnpj("1221");
        cli2.setEndereco("irineu");
        cli2.setTelefone("51 1111222333");
        this.addCliente(cli2);

    }
    
    public void addCliente(cliente c) {
        this.clientes.add(c);
    }

    public ArrayList<cliente> getClientes() {
        return clientes;
    }

    public Boolean verificaCliente(int idCliente) {
        boolean verCliente = false;
        for (cliente cli : clientes) {
            if (cli.getIdCliente() == idCliente) {
                verCliente = true;
                System.out.println("Cliente: " + cli.getNomeCliente());
            }
        }
        return verCliente;
    }

    public Boolean verificarCPF(String cpf) {
        boolean verCPF = false;
        for (cliente cli : clientes) {
            if (cli.getCpf().equals(cpf)) {
                verCPF = true;
                System.out.println("Cliente: " + cli.getCpf());
            }
        }
        return verCPF;
    }
    public cliente pesqCli(int cpfCNPJ, String pesq) {
        cliente c = new cliente();
        switch (cpfCNPJ) {
            case 1:
                for (cliente cli : clientes) {
                    if (cli.getCpf() != null && cli.getCpf().equals(pesq)) {
                        c=cli;
                        break;
                    }
                }
                break;
            case 2:
                for (cliente cli : clientes) {
                    if (cli.getCnpj()!= null && cli.getCnpj().equals(pesq)) {
                        c=cli;
                        break;
                    }
                }
                break;
            default:
                c = null;
                System.out.println("Cliente não encontrado!");
                break;
        }

        return c;
    }
    
    public void gerarId () {
        int contadorDeId =3;
        cliente cli = new cliente();
        cli.setIdCliente(contadorDeId++);
    }
}
