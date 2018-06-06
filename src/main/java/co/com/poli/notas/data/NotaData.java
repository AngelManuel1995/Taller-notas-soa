package co.com.poli.notas.data;

import co.com.poli.notas.model.Nota;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author angel
 */
public class NotaData {

    private static List<Nota> listaNotas;

    static {
        listaNotas = new ArrayList<Nota>() {
            {
                add(new Nota("1010","SOA",3D, 5D, 0D));
                add(new Nota("1112","PDP",3D, 3D, 0D));
            }
        };
    }

    public static List<Nota> getListaNotas() {
        return listaNotas;
    }

    public static void setListaNotas(List<Nota> listaNotas) {
        NotaData.listaNotas = listaNotas;
    }

  

}
