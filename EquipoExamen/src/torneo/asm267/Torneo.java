package torneo.asm267;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase que almacena los partidos jugados en cada torneo
 * @author asm267@educa.madrid.org
 * @version 1.5
 * @since 1.0
 */
public class Torneo {
	/**
	 * Nombre del torneo
	 */
    private String nombre;
    /**
     * Lista con los partidos del torneo
     */
    private List<Partido> partidos = new ArrayList<>();
    
    /**
     * Método para añadir Partidos al array
     * @param nuevo objeto de tipo Partido
     * @return devuelve true si se ha realizado correctamente
     * @throws DatosInvalidosException si alguno de los datos del Partido son nulos
     * @since 1.0
     */
    public boolean agregarPartido(Partido nuevo) throws DatosInvalidosException {
        if (nuevo == null || nuevo.getEquipoLocal() == null || nuevo.getEquipoVisitante() == null) {
            throw new DatosInvalidosException("El partido o alguno de los equipos es nulo");
        }

        boolean existePartido = this.encontrarPartidoPorEquipos(nuevo.getEquipoLocal(), nuevo.getEquipoVisitante());
        if (!existePartido) {
            return partidos.add(nuevo);
        }

        return false;
    }

    /**
     * Busca un partido mediante los equipos que lo jugaron
     * @param local nombre del equipo local (String)
     * @param visitante nombre del equipo visitante (String)
     * @return devuelve true si encuentra el partido o false si no lo encuentra
     * @since 1.0
     */
    public boolean encontrarPartidoPorEquipos(String local, String visitante) {
        for (Partido partido : partidos) {
            if (partido.getEquipoLocal().equalsIgnoreCase(local) && partido.getEquipoVisitante().equalsIgnoreCase(visitante)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para encontrar partidos por fecha de realización
     * @since 1.2
     * @deprecated replaced by {@link #encontrarPartidos(Date, String, String)}
     * @param fecha fecha de realizacion del partido (tipo Date)
     * @return true si lo encuentra y false si no
     */
    public boolean encontrarPartidoPorFecha(Date fecha) {
        for (Partido partido : partidos) {
            if (partido.getFechaPartido().equals(fecha)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para encontrar partidos
     * @since 1.5
     * @param fecha Fecha de realizacion del partido (tipo Date)
     * @param equipoLocal Nombre del equipo local (String)
     * @param equipoVisitante Nombre del equipo visitante (String)
     * @return ArrayList con los resultados obtenidos
     */
    public List<Partido> encontrarPartidos(Date fecha, String equipoLocal, String equipoVisitante) {
        List<Partido> resultados = new ArrayList<>();
        for (Partido partido : partidos) {
            if (partido.getFechaPartido().equals(fecha) &&
                partido.getEquipoLocal().equalsIgnoreCase(equipoLocal) &&
                partido.getEquipoVisitante().equalsIgnoreCase(equipoVisitante)) {
                resultados.add(partido);
            }
        }
        return resultados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }
}
