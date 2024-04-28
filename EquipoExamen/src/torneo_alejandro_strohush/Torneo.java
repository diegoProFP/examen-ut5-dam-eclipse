package torneo_alejandro_strohush;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * Esta clase organiza los torneos, encuentra partidos y si se juegan los agrega
 * 
 * @author Alex
 * @version 1.5.0
 * @since 1.0
 * 
 */

public class Torneo {

	private String nombre;
	private List<Partido> partidos = new ArrayList<>();

	/**
	 * Agrega el partido en caso de que haya ocurrido sino devolvera un error
	 * 
	 * @param nuevo
	 * @return Devuelve si se ha añadido o no un partido
	 * @throws DatosInvalidosException Si no hay un partido, o no esta el equipo
	 *                                 local / visitante devuelve este error
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
	 * Hace el emperejamiento de los partidos, te dice si ha encontrado un partido o
	 * no
	 * 
	 * @param local
	 * @param visitante
	 * @return Devuelve true si ha encontrado partido y false si no lo ha encontrado
	 * @since 1.0
	 * 
	 */

	public boolean encontrarPartidoPorEquipos(String local, String visitante) {
		for (Partido partido : partidos) {
			if (partido.getEquipoLocal().equalsIgnoreCase(local)
					&& partido.getEquipoVisitante().equalsIgnoreCase(visitante)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Busca si hay partidos disponibles en una fecha
	 * 
	 * @param fecha
	 * @return
	 * @since 1.2
	 * @deprecated No hay que usar mas este metodo porque hay uno mejor que es
	 * @see #encontrarPartidos(Date, String, String)
	 */
	// encontrarPartidos

	public boolean encontrarPartidoPorFecha(Date fecha) {
		for (Partido partido : partidos) {
			if (partido.getFechaPartido().equals(fecha)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Esta clase encuentra los partidos y te devuelve el resultado de los mismos
	 * 
	 * @param fecha
	 * @param equipoLocal
	 * @param equipoVisitante
	 * @return Resultado de los partidos
	 * @since 1.5
	 */

	public List<Partido> encontrarPartidos(Date fecha, String equipoLocal, String equipoVisitante) {
		List<Partido> resultados = new ArrayList<>();
		for (Partido partido : partidos) {
			if (partido.getFechaPartido().equals(fecha) && partido.getEquipoLocal().equalsIgnoreCase(equipoLocal)
					&& partido.getEquipoVisitante().equalsIgnoreCase(equipoVisitante)) {
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
