package co.com.poli.notas.model;

import java.util.Objects;

/**
 *
 * @author angel
 */
public class Nota {
    
    private String documento;
    private String materia;
    private Double notaParcial;
    private Double notaFinal;
    private Double seguimiento;

    public Nota(String documento, String materia, Double notaParcial, Double notaFinal, Double seguimiento) {
        this.documento = documento;
        this.materia = materia;
        this.notaParcial = notaParcial;
        this.notaFinal = notaFinal;
        this.seguimiento = seguimiento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public Double getNotaParcial() {
        return notaParcial;
    }

    public void setNotaParcial(Double notaParcial) {
        this.notaParcial = notaParcial;
    }

    public Double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(Double notaFinal) {
        this.notaFinal = notaFinal;
    }

    public Double getSeguimiento() {
        return seguimiento;
    }

    public void setSeguimiento(Double seguimiento) {
        this.seguimiento = seguimiento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.documento);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Nota other = (Nota) obj;
        if (!Objects.equals(this.documento, other.documento)) {
            return false;
        }
        return true;
    }
    
    
    
}
