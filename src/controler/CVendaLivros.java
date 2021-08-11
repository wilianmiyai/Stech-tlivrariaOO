/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.util.ArrayList;
import model.vendaLivro;

/**
 *
 * @author wilian
 */
public class CVendaLivros {

    ArrayList<vendaLivro> vendaLivros = new ArrayList<>();

    public void addVendaLivros(vendaLivro vl) {
        this.vendaLivros.add(vl);
    }

    public ArrayList<vendaLivro> getVendaLivro() {
        return vendaLivros;
    }

}
