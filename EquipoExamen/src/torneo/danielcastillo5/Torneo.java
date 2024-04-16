package torneo.danielcastillo5;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


//Poner comentario de la clase, con la descripción de qué es lo que hace  
//De autor poned vuestro email de educaMadrid. 
//La version de la clase es la 1.5, y existe desde la 1.0
/**
 * Clase para gestionar los partido del torneo
 * @author danielcastillo5
 * @version 1.5
 * @since 1.0
 */
public class Torneo {
	
    private String nombre;
    private List<Partido> partidos = new ArrayList<>();

    // Poner descripcion, parametros de entrada, valor de retorno, y en qué condiciones se produce la excepción. Además que pueda
 	// referenciar tanto a las clases Partido y DatosInvalidosException
 	//Existe desde la version 1.0
    /**
     * Método para agregar partidos a una lista segun si han tenido lugar o no
     * @param nuevo : instancia de la clase partido
     * @return falso si no existe el partido o algun equipo del mismo, y si existe lo añade al ArrayList de partidos
     * @throws DatosInvalidosException si el partido no se a celebrado
     * @see
     * {@link Partido}
     * {@link DatosInvalidosException}
     * @since 1.0
     * 
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

    // Poner descripcion, parametros de entrada, valor de retorno.
   	//Existe desde la version 1.0
    /**
     * Método para saber si dos equipos se han enfrentado entre si
     * @param local : dato de tipo String
     * @param visitante : dato de tipo String
     * @return true si los dos equipos se han enfrentado
     */
    public boolean encontrarPartidoPorEquipos(String local, String visitante) {
        for (Partido partido : partidos) {
            if (partido.getEquipoLocal().equalsIgnoreCase(local) && partido.getEquipoVisitante().equalsIgnoreCase(visitante)) {
                return true;
            }
        }
        return false;
    }

    // Este metodo está deprecado porque se ha hecho uno mejor, y el que lo sustituye es el
   	// encontrarPartidos(Date fecha, String equipoLocal, String equipoVisitante)
   	//Existe desde la version 1.2
    /**
     * 
     * @param fecha : dato de tipo Date
     * @return true si el partido existe
     * @since 1.2
     * @deprecated
     * @see encontrarPartidos
     */
    public boolean encontrarPartidoPorFecha(Date fecha) {
        for (Partido partido : partidos) {
            if (partido.getFechaPartido().equals(fecha)) {
                return true;
            }
        }
        return false;
    }

    // Poner descripcion, parametros de entrada, valor de retorno.
 	//Existe desde la version 1.5
    /**
     * Metodo para encontrar un partido segun el dia y los participantes
     * @param fecha : dato de tipo Date
     * @param equipoLocal : dato de tipo String
     * @param equipoVisitante : dato de tipo String
     * @return ArrayList con los resultados
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
