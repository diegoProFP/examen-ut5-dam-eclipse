package torneo.adrianrodriguez134;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


//Poner comentario de la clase, con la descripción de qué es lo que hace  
//De autor poned vuestro email de educaMadrid. 
//La version de la clase es la 1.5, y existe desde la 1.0
/**
 * Clase torneo del proyecto torneo
 * @author adrianrodriguez134
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
     * 
     * Este método crea un partido nuevo recibiendo objetos de la clase partido
     * @param nuevo recibe como parámetro un nuevo objeto de la clase partido
     * @return boolean el método obtiene un boolean
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

    // Poner descripcion, parametros de entrada, valor de retorno.
   	//Existe desde la version 1.0
    /**
     * 
     * Este método sirve para encontrar los partidos ya jugados metiendo los equipos que se enfrentaron
     * @since 1.0
     * @param local recibe un string del equipo local
     * @param visitante recibe un string del equipo visitante
     * @return boolean devuelve un boolean
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
     * Este método sirve para encontrar los partidos jugados filtrando por fecha
     * @deprecated
     * @see encontrarPartidos(Date fecha, String equipoLocal,String equipoVisitante)
     * @param fecha recibe un parámetro de tipo date con la fecha del partido
     * @return boolean devuelve un boolean
     * @since 1.2
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
     * Este método es la versión mejorada del encontrarPartidoasporFecha, recibe la fecha y los equipos y encuentra el partido
     * 
     * @param fecha recibe un parámetro de tipo date
     * @param equipoLocal recibe un parámetro de tipo string del equipo local
     * @param equipoVisitante recibe un parámetro de tipo string del equipo visitante
     * @return
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
