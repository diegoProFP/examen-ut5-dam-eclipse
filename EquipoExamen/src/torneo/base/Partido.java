package torneo.base;

import java.util.Date;

public class Partido {
    private String equipoLocal;
    private String equipoVisitante;
    private Date fechaPartido;
    private String resultado;

    public String getEquipoLocal() {
        return equipoLocal;
    }
    public void setEquipoLocal(String equipoLocal) {
        this.equipoLocal = equipoLocal;
    }
    public String getEquipoVisitante() {
        return equipoVisitante;
    }
    public void setEquipoVisitante(String equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }
    public Date getFechaPartido() {
        return fechaPartido;
    }
    public void setFechaPartido(Date fechaPartido) {
        this.fechaPartido = fechaPartido;
    }
    public String getResultado() {
        return resultado;
    }
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
