/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.util.ArrayList;
import model.editora;

/**
 *
 * @author wilian
 */
public class CEditoras {

    public ArrayList<editora> editora = new ArrayList<>();
    
    public void mokEditora() {
        editora edi = new editora();
        edi.setIdEditora(1);
        edi.setNmEditora("luiza");
        edi.setEndereco("rua leal");
        edi.setTelefone("11 12345");
        edi.setGerente("mario");
        this.addEditora(edi);
        editora edi2 = new editora();
        edi2.setIdEditora(2);
        edi2.setNmEditora("luana");
        edi2.setEndereco("rua lis");
        edi2.setTelefone("21 3332");
        edi2.setGerente("leandro");
        this.addEditora(edi2);
        
    }
    

    public void addEditora(editora e) {
        this.editora.add(e);
    }

    public ArrayList<editora> getEditora() {
        return editora;
    }

    public Boolean verificaEditora(int idEditora) {
        Boolean verEditora = false;
        for (editora edit : editora) {
            if (edit.getIdEditora() == idEditora) {
                verEditora = true;
                System.out.println("Editora: " + edit.getNmEditora());
            }
        }
        return verEditora;

    }
    public void gerarId () {
        int contadorDeId =3;
        editora edit = new editora();
        edit.setIdEditora(contadorDeId++);
    }
}
