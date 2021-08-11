/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author wilian
 */
public class livro {
        private int idLivro;
        private String titulo;
        private String autor;
        private String assunto;
        private String isbn;
        private int estoque;
        private float preco;
        private int idEditora;

    public livro() {
    }

    public livro(String titulo,int idLivro, String autor, String assunto, String isbn, int estoque, float preco,int idEditora) {
        this.titulo = titulo;
        this.idLivro = idLivro;
        this.autor = autor;
        this.assunto = assunto;
        this.isbn = isbn;
        this.estoque = estoque;
        this.preco = preco;
        this.idEditora = idEditora;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getIdEditora() {
        return idEditora;
    }

    public void setIdEditora(int idEditora) {
        this.idEditora = idEditora;
    }

    @Override
    public String toString() {
        return "livro{" + "idLivro =" + idLivro + ", titulo =" + titulo + ", autor =" + autor + ", assunto =" + assunto + ", isbn =" + isbn + ", estoque =" + estoque + ", preco =" + preco + ", idEditora =" + idEditora + '}';
    }

    

    
        
        
}
