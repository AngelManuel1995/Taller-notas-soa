/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.notas.business;

import co.com.poli.notas.model.Nota;
import java.util.List;

/**
 *
 * @author angel
 */
public interface INotaBusiness {

    List<Nota> obtenerNotas();

    Nota obtenerNota(String documento);

    String crearNota(Nota nota);

    String eliminarNota(String documento);

    String modificarNota(Nota nota);

    String estudiante();
}
