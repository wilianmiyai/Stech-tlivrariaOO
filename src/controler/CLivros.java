/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.util.ArrayList;
import model.livro;

/**
 *
 * @author wilian
 */
public class CLivros {

    ArrayList<livro> livros = new ArrayList<>();

    public void mkLivros() {
        livro liv = new livro();
        liv.setIdLivro(1);
        liv.setIdEditora(1);
        liv.setAssunto("liz");
        liv.setAutor("maria");
        liv.setTitulo("maria braga");
        liv.setIsbn("12345678");
        liv.setEstoque(10);
        liv.setPreco((float) 30);
        this.addLivro(liv);

        livro liv2 = new livro();
        liv2.setIdLivro(2);
        liv2.setIdEditora(2);
        liv2.setAssunto("odio");
        liv2.setAutor("sandra");
        liv2.setTitulo("maria luiz");
        liv2.setIsbn("1112221");
        liv2.setEstoque(6);
        liv2.setPreco((float) 1.5);
        this.addLivro(liv2);

        livro liv3 = new livro();
        liv3.setIdLivro(3);
        liv3.setIdEditora(1);
        liv3.setAssunto("vassoura");
        liv3.setAutor("edu");
        liv3.setTitulo("mar");
        liv3.setIsbn("11-1234-12-17899-11");
        liv3.setEstoque(20);
        liv3.setPreco((float) 50);
        this.addLivro(liv3);

    }

    public void addLivro(livro l) {
        this.livros.add(l);
    }

    public ArrayList<livro> getLivros() {
        return livros;
    }

    public Boolean verificaLivro(int idLivro) {
        Boolean verLivro = false;
        for (livro livro1 : livros) {
            if (livro1.getIdLivro() == idLivro) {
                verLivro = true;
                System.out.println("Livro: " + livro1.getTitulo());
            }
        }
        return verLivro;
    }

    public Boolean verEstoqueLivro(int idLivro, int qtd) {
        boolean verEstoqueLivro = false;
        for (livro Estoqueliv : livros) {
            if (Estoqueliv.getIdLivro() == idLivro && Estoqueliv.getEstoque() >= qtd) {
                verEstoqueLivro = true;

            } else if (Estoqueliv.getIdLivro() == idLivro) {
                System.out.println("Estoque atual: " + Estoqueliv.getEstoque());
            }
        }
        return verEstoqueLivro;
    }

    public void atualizaEstoqueLivro(int idLivro, int qtd) {
        for (livro upEstoqueLivro : livros) {
            if (upEstoqueLivro.getIdLivro() == idLivro) {
                int upEstoque = upEstoqueLivro.getEstoque() - qtd;
                upEstoqueLivro.setEstoque(upEstoque);
                System.out.println("Estoque novo " + upEstoqueLivro.getEstoque());
            }
        }
    }

    public float verPrecoLivro(int idLivro) {
        float preco = 0;
        for (livro prLivro : livros) {
            if (prLivro.getIdLivro() == idLivro) {
                preco = prLivro.getPreco();

            }

        }
        return preco;

    }

    public int verificaEstoque(int idLivro) {
        int estoqueAtual = 0;
        for (livro esLivro : livros) {
            if (esLivro.getIdLivro() == idLivro) {
                estoqueAtual = esLivro.getEstoque();

            }
        }
        return estoqueAtual;

    }
    public void gerarId () {
        int contadorDeId =4;
        livro liv = new livro();
        liv.setIdLivro(contadorDeId++);
    }
    
}
