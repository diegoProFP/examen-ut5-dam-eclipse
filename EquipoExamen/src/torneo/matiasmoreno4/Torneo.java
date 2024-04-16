package torneo.matiasmoreno4;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


//Poner comentario de la clase, con la descripción de qué es lo que hace  
//De autor poned vuestro email de educaMadrid. 
//La version de la clase es la 1.5, y existe desde la 1.0
/**
 * Esta clase permite agregar partidos, y encontrarlos por equipos o por fecha
 * @author matias.moreno4@educa.madrid.org
 * @version 1.5
 * @since 1.0
 * */
public class Torneo {
	
    private String nombre;
    private List<Partido> partidos = new ArrayList<>();

    // Poner descripcion, parametros de entrada, valor de retorno, y en qué condiciones se produce la excepción. Además que pueda
 	// referenciar tanto a las clases Partido y DatosInvalidosException
 	//Existe desde la version 1.0
    /**
     * Este metodo permite agregar partidos.
     * Se produce una excepcion si insertamos un dato que sea nulo
     * @param nuevo Este objeto es el partido que agregaremos
     * @return Nos devuelve la agregacion de un partido a un ArrayList de partidos
     * @see Partido
     * @see DatosInvalidosException
     * @since 1.0
     * */
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
     * Este metodo permite encontrar partidos por equipos
     * @param local Este string es el equipo que juega en local
     * @param visitante Este string es el equipo que juega en visitante
     * @return Nos devuelve un booleano si ha encontrado el partido o no
     * @since 1.0
     * */
    // Poner descripcion, parametros de entrada, valor de retorno.
   	//Existe desde la version 1.0
    
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
     * @deprecated El nuevo metodo que lo sustituye es encontrarPartidos
     * @since 1.2
     * */
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
     * Este metodo permite encontrar partidos por fecha
     * @param fecha Este dato es la fecha en la que se jugo el partido
     * @param equipoLocal Este string es el equipo que juega en local
     * @param equipoVisitante Este string es el equipo que juega en visitante
     * @return Nos devuelve un ArrayList de los resultados que se han encontrado
     * @since 1.5
     * */
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
