package tlivrariaOO;

import model.cliente;
import controler.CClientes;
import controler.CEditoras;
import controler.CLivros;
import controler.CVendaLivros;
import java.util.Date;
import java.util.Scanner;
import model.editora;
import model.livro;
import model.vendaLivro;

/**
 *
 * @author wilian
 */
public class TLivraria {
    
    public static int menu() {
        Scanner ler = new Scanner(System.in);
        System.out.println("-- Menu Livraria --");
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Listar Clientes");
        System.out.println("3 - Cadastrar Editora");
        System.out.println("4 - Listar Editoras");
        System.out.println("5 - Cadastrar Livro");
        System.out.println("6 - Listar Livros");
        System.out.println("7 - Venda Livro");
        System.out.println("8 - Listar Vendas");
        System.out.println("9 - Atualizar cliente");
        System.out.println("10 - Sair");
        System.out.println("Escolha um opção acima");
        return Integer.parseInt(ler.nextLine());
    }

    /**
     * Projeto Livraria com Orientação a Objetos
     *
     * @param args
     */
    public static void main(String[] args) {
        
        Scanner ler = new Scanner(System.in);
        CClientes cadClientes = new CClientes();// Repositório de Clientes
        CEditoras cadEditoras = new CEditoras();// Repositório de Editora
        CLivros cadLivros = new CLivros();
        CVendaLivros cadVendaLivros = new CVendaLivros();
        
        cadClientes.mokClientes();
        cadEditoras.mokEditora();
        cadLivros.mkLivros();
        
        Boolean sys = true, opC;
        int opM = 0;
        
        while (sys) {
            try {
                opM = menu();
            } catch (Exception e) {
                System.out.println("erro: " + e + "\nOpção Inválida!");
            }
            switch (opM) {
                case 1:
                    System.out.println("-- Cadastro de Clientes --");
                    opC = true;
                    while (opC) {
                        cliente cli = new cliente();
                        cadClientes.gerarId();
                        System.out.println("Informe o Nome: ");
                        cli.setNomeCliente(ler.nextLine());
                        boolean doc = false;
                        do {
                            System.out.println("É pessoa física? \n1 - Sim\n2 - Não");
                            int tPessoa = ler.nextInt();
                            System.out.println("Informe o documento: ");
                            String cpfCNPJ = ler.next();
                            cliente cliCpfCnpj;
                            cliCpfCnpj = cadClientes.pesqCli(tPessoa, cpfCNPJ);
                            
                            if (tPessoa == 1 && cliCpfCnpj.getCpf() == null) {
                                cli.setCpf(cpfCNPJ);
                                cli.setCnpj(null);
                                doc = false;
                            } else if (tPessoa == 2 && cliCpfCnpj.getCnpj() == null) {
                                cli.setCpf(null);
                                cli.setCnpj(cpfCNPJ);
                                doc = false;
                            }                            
                            if (cadClientes.verificaCliente(cliCpfCnpj.getIdCliente())) {
                                System.out.println("Este documneto ja existe!");
                                doc = true;
                            }
                        } while (doc);
                        
                        System.out.println("Informe o telefone: ");
                        cli.setTelefone(ler.next());
                        System.out.println("Informe o endereço: ");
                        cli.setEndereco(ler.next());
                        cadClientes.addCliente(cli);
                        System.out.println("Cliente " + cli.getNomeCliente() + " foi cadastro com sucesso!");
                        
                        System.out.println("Deseja continuar cadastrando?\n1 - Sim\n2 - Não");
                        int opCC;
                        opCC = ler.nextInt();
                        opC = opCC == 1;
                    }
                    break;
                case 2:
                    System.out.println("Lista de Clientes");
                    for (int i = 0; i < cadClientes.getClientes().size(); i++) {
                        System.out.println("Clientes: " + (i + 1) + " | "
                                + cadClientes.getClientes().get(i).getNomeCliente());
                    }
                    break;
                case 3:
                    System.out.println("-- Cadastro de Editoras --");
                    opC = true;
                    while (opC) {
                        editora edit = new editora();
                        cadEditoras.gerarId();
                        System.out.println("Informe o nome da Editora");
                        edit.setNmEditora(ler.next());
                        System.out.println("Informe o endereço");
                        edit.setEndereco(ler.next());
                        System.out.println("Informe o telefone");
                        edit.setTelefone(ler.next());
                        System.out.println("Informe o gerente");
                        edit.setGerente(ler.next());
                        cadEditoras.addEditora(edit);
                        System.out.println("Editora " + edit.getNmEditora() + " cadastrada com sucesso!");
                        
                        System.out.println("Deseja continuar cadastrando?\n1 - Sim\n2 - Não");
                        int opCC;
                        opCC = ler.nextInt();
                        opC = opCC == 1;
                    }
                    break;
                case 4:
                    System.out.println("Lista de Editoras");
                    for (int i = 0; i < cadEditoras.getEditora().size(); i++) {
                        System.out.println("Editoras: " + (i + 1) + " | "
                                + cadEditoras.getEditora().get(i).getNmEditora());
                    }
                    break;
                case 5:
                    System.out.println("-- Cadastro de Livros --");
                    opC = true;
                    while (opC) {
                        livro liv = new livro();
                        cadLivros.gerarId();
                        System.out.println("Informe o título do livro: ");
                        liv.setTitulo(ler.next());
                        System.out.println("Informe o  Assunto: ");
                        liv.setAssunto(ler.next());
                        System.out.println("Informe o Autor: ");
                        liv.setAutor(ler.next());
                        System.out.println("Informe o ISBN: ");
                        liv.setIsbn(ler.next());
                        System.out.println("Informe o Estoque ");
                        liv.setEstoque(ler.nextInt());
                        System.out.println("Informe o preço ");
                        liv.setPreco(ler.nextFloat());
                        boolean edtLivroOk = true;
                        do {
                            System.out.println("Informe o ID da Editora");
                            int edtLivro = ler.nextInt();
                            if (cadEditoras.verificaEditora(edtLivro)) {
                                edtLivroOk = false;
                                liv.setIdEditora(edtLivro);
                            } else {
                                System.out.println("Editora inválida, tente novamente!");
                            }
                            
                        } while (edtLivroOk);
                        cadLivros.addLivro(liv);
                        System.out.println("livro " + liv.getTitulo()
                                + " cadastrada com sucesso!");
                        
                        System.out.println("Deseja continuar cadastrando?\n1 - Sim\n2 - Não");
                        int opCC;
                        opCC = ler.nextInt();
                        opC = opCC == 1;
                    }
                    break;
                case 6:
                    System.out.println("-- Lista de livros --");
                    for (int i = 0; i < cadLivros.getLivros().size(); i++) {
                        System.out.println("Livro: " + (i + 1) + " | "
                                + cadLivros.getLivros().get(i));
                    }
                    break;
                case 7:
                    System.out.println("-- Cadastro de Vendas --");
                    opC = true;
                    while (opC) {
                        int idCliente, idLivro, qtd;
                        float subTotal;
                        Date dataVenda = new Date(System.currentTimeMillis());
                        
                        boolean verIdCli = true;
                        do {
                            System.out.println("Informe o id do Cliente: ");
                            idCliente = ler.nextInt();
                            if (cadClientes.verificaCliente(idCliente)) {
                                verIdCli = false;
                            } else {
                                System.out.println("Cliente inválido, tente novamente!");
                            }
                        } while (verIdCli);
                        
                        boolean verIdLiv = true;
                        do {
                            System.out.println("Informe o id do Livro: ");
                            idLivro = ler.nextInt();
                            if (cadLivros.verificaLivro(idLivro) && cadLivros.verificaEstoque(idLivro) > 0) {
                                verIdLiv = false;
                            } else {
                                System.out.println("Livro incorreto, tente novamente!");
                            }
                        } while (verIdLiv);
                        
                        boolean verEstLiv = true;
                        do {
                            System.out.println("Informe a quantidade comprada de livros: ");
                            qtd = ler.nextInt();
                            if (cadLivros.verEstoqueLivro(idLivro, qtd) && qtd > 0) {
                                verEstLiv = false;
                                cadLivros.atualizaEstoqueLivro(idLivro, qtd);
                            } else {
                                System.out.println("Estoque insuficiente para esta compra." + "\nTente novamente! ");
                            }
                        } while (verEstLiv);
                        subTotal = (float) cadLivros.verPrecoLivro(idLivro) * qtd;
                        System.out.println("Valor da venda : " + subTotal);
                        
                        vendaLivro vendaLivro = new vendaLivro(idCliente, idLivro, qtd, subTotal, dataVenda);
                        cadVendaLivros.addVendaLivros(vendaLivro);
                        System.out.println("Venda concluída com sucesso!");
                        
                        System.out.println("Deseja continuar cadastrando?\n1 - Sim\n2 - Não");
                        int opCC;
                        opCC = ler.nextInt();
                        opC = opCC == 1;
                    }
                    break;
                case 8:
                    System.out.println("-- Lista de venda de livros --");
                    for (int i = 0; i < cadVendaLivros.getVendaLivro().size(); i++) {
                        System.out.println("Livro: " + (i + 1) + " | "
                                + cadVendaLivros.getVendaLivro().get(i));
                    }
                    
                    break;
                case 9:
                    boolean uptade = false;
                     {
                        do {
                            System.out.println("-- Atualizar --");
                            System.out.println("Pesquisa por : \n1 - CPF\n2 - CNPJ");
                            int cpfCNPJ = ler.nextInt();
                            System.out.println("Informe o valor de pesquisa :");
                            String pesq = ler.next();
                            cliente cliUp;
                            cliUp = cadClientes.pesqCli(cpfCNPJ, pesq);
                            if (cliUp.getCpf() != null || cliUp.getCnpj() != null) {
                                System.out.println("Cliente Selecionado");
                                System.out.println(cliUp.getNomeCliente());
                                System.out.println("Novo Nome");
                                ler.nextLine();
                                cliUp.setNomeCliente(ler.nextLine());
                                uptade = false;
                            } else {
                                System.out.println("Cliente não encontrado!\nTente novamente!");
                                uptade = true;
                            }
                        } while (uptade);
                    }
                    break;
                
                case 10:
                    System.out.println("Aplicação encerrada pelo usuário!");
                    sys = false;
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente!");
                    break;
            }//fim switch
        }//fim while

    }
    
}
