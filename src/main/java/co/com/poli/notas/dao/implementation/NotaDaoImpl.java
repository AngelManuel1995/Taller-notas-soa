/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.notas.dao.implementation;
import co.com.poli.notas.dao.INotaDao;
import co.com.poli.notas.data.NotaData;
import co.com.poli.notas.model.Nota;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author angel
 */

@Repository
public class NotaDaoImpl implements INotaDao{

    @Override
    public List<Nota> obtenerNotas() {
        return NotaData.getListaNotas();
    }

    @Override
    public Nota obtenerNota(String documento) {
        Nota nota = null;
        List<Nota> listaNotas = NotaData.getListaNotas();
        for (Nota prod : listaNotas) {
            if(prod.getDocumento().equals(documento)){
                nota = prod;
            }
        }
        
        return nota;
    }

    @Override
    public String crearNota(Nota nota) {
        List<Nota> listaNotas = NotaData.getListaNotas();
        listaNotas.add(nota);
        NotaData.setListaNotas(listaNotas);
        return "Nota creado exitosamente";
    }

    @Override
    public String eliminarNota(String documento) {
        List<Nota> listaNotas = NotaData.getListaNotas();
        Nota nota = obtenerNota(documento);
        listaNotas.remove(nota);
        NotaData.setListaNotas(listaNotas);
        return "Nota eliminado exitosamente";
    }

    @Override
    public String modificarNota(Nota nota) {
        List<Nota> listaNotas = NotaData.getListaNotas();
        listaNotas.set(listaNotas.indexOf(nota), nota);
        NotaData.setListaNotas(listaNotas);
        
        return "Nota modificado exitosamente";
    }
    
}
