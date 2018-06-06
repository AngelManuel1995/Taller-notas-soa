package co.com.poli.notas.dao;

import co.com.poli.notas.model.Nota;
import java.util.List;

/**
 *
 * @author angel
 */
public interface INotaDao {
    
    List<Nota> obtenerNotas();

    Nota obtenerNota(String documento);

    String crearNota(Nota nota);

    String eliminarNota(String documento);

    String modificarNota(Nota nota);
    
    
}
