package co.com.poli.notas.business.implementation;

import co.com.poli.notas.business.INotaBusiness;
import co.com.poli.notas.dao.INotaDao;
import co.com.poli.notas.data.NotaData;
import co.com.poli.notas.model.Nota;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author angel
 */
@Service
public class NotaBusinessImpl implements INotaBusiness {

    @Autowired
    private INotaDao notaDao;

    @Override
    public List<Nota> obtenerNotas() {
        return notaDao.obtenerNotas();
    }

    @Override
    public Nota obtenerNota(String documento) {
        return notaDao.obtenerNota(documento);
    }

    @Override
    public String crearNota(Nota nota) {
        String respuesta = "";
        List<Nota> listaNotas = NotaData.getListaNotas();
        if (listaNotas.contains(nota)) {
            respuesta = "Nota ya está registrado";
        } else {
            if (nota.getNotaFinal() >= 0 && nota.getNotaFinal() <= 5) {
                if (nota.getNotaParcial() >= 0 && nota.getNotaParcial() <= 5) {
                    if (nota.getSeguimiento() >= 0 && nota.getSeguimiento() <= 5) {
                        respuesta = notaDao.crearNota(nota);
                    }else{
                        respuesta = "Seguimiento no válido";
                    }

                }else{
                    respuesta = "Parcial no válido";
                }
            }else{
                respuesta = "Final no válido";
            }
        }
        return respuesta;
    }

    @Override
    public String eliminarNota(String documento) {
        String respuesta = "Nota no existe";
        List<Nota> listaNotas = NotaData.getListaNotas();
        if (listaNotas.contains(notaDao.obtenerNota(documento))) {
            respuesta = notaDao.eliminarNota(documento);
        }
        return respuesta;
    }

    @Override
    public String modificarNota(Nota nota) {
        String respuesta = "";
        List<Nota> listaNotas = NotaData.getListaNotas();
        if (listaNotas.contains(nota)) {
            respuesta = notaDao.modificarNota(nota);
        } else {
            respuesta = "No existe";
        }
        return respuesta;
    }
    
    @Override
    public String estudiante() {
        List<Nota> listaNotas = NotaData.getListaNotas();
        int eGanados = 0;
        int ePerdidos = 0;
        Double valor = 0D;
        
        for (Nota nota : listaNotas) {
            valor = nota.getNotaFinal() * 0.25 + nota.getNotaParcial() * 0.25 + nota.getSeguimiento() * 0.5;
            if( valor >= 3){
                eGanados ++;
            }else{
                ePerdidos ++;
            }
        }
        
        return "N° estudiantes ganados: " + eGanados + " N° estudiantes perdidos: " + ePerdidos ;
    }

}
