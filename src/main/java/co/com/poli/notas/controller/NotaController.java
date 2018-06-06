package co.com.poli.notas.controller;

import co.com.poli.notas.business.INotaBusiness;
import co.com.poli.notas.model.Nota;
import co.com.poli.notas.path.Path.PathNota;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author angel
 */
@RestController
@RequestMapping(value = "/")
public class NotaController {
    
    @Autowired
    private INotaBusiness notaBusiness;
    
    @GetMapping(PathNota.NOTA)
    public List<Nota> obtenerNotas(HttpServletResponse hsr){
        return  notaBusiness.obtenerNotas();
    };
    
    @GetMapping(PathNota.ESTUDIANTE)
    public String estudiantes(HttpServletResponse hsr){
        return  notaBusiness.estudiante();
    };
    
    @GetMapping(PathNota.DOCUMENTO)
    public Nota obtenerNota(@PathVariable String documento, HttpServletResponse hsr){
        return notaBusiness.obtenerNota(documento);
    }
    
    @PostMapping("/nota")
    public String crearNota(@RequestBody Nota nota, HttpServletResponse hsr){
      return notaBusiness.crearNota(nota);
    }
    
    @PutMapping("/nota")
    public String modificarNota(@RequestBody Nota nota, HttpServletResponse hsr){
        return  notaBusiness.modificarNota(nota);
    }

    @DeleteMapping("/nota/{documento}")
    public String eliminarNota(@PathVariable String documento, HttpServletResponse hsr){
        return notaBusiness.eliminarNota(documento);
    }
}

