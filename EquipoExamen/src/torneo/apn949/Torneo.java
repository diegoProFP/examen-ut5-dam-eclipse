package torneo.apn949;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase encargada almacenar y gestionar partidos para crear un torneo
 * @author apn949@educa.madrid.org
 * @version 1.5
 * @since 1.0
 */
public class Torneo {
	
    private String nombre;
    private List<Partido> partidos = new ArrayList<>();

    /**
     * Verifica los datos de un partido y lo añade a la lista de partidos
     * @param nuevo Partido a añadir
     * @return boolean - True si se ha añadido correctamente el partido y false si no
     * @throws DatosInvalidosException
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
     * Busca en la lista de partidos si existe algún partido en el cual jueguen los dos equipos especivicados
     * @param local Equipo local
     * @param visitante Equipo visitante
     * @return boolean - True si existe el partido, flase si no existe
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
     * @deprecated Sistituido por {@link encontrarPartidos(Date, String, String)}
     * @param fecha Fecha partido
     * @return boolean - True si se ha encontrado el partido, false si no se ha encontrado
     * @since 1.2
     * @see encontrarPartidos(Date, String, String)
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
     * Busca en la lista de partidos si existe un partido con la fecha y los equipos participantes correspondientes
     * @param fecha Fecha del partido
     * @param equipoLocal Equipo local
     * @param equipoVisitante Equipo visitante
     * @return Devuelve un objeto Partido con el partido encontrado
     * @since 1.5
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
