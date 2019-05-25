package com.dolist.negocio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import com.dolist.modelo.dtos.UsuarioDTO;
import com.dolist.modelo.entidades.Usuario;
import com.dolist.modelo.entidades.UsuarioPK;
import com.dolist.modelo.excepciones.InvalidParameterException;
import com.dolist.modelo.manejadores.ManejadorUsuario;
import com.dolist.modelo.manejadores.utils.InformacionFiltro;
import com.dolist.modelo.manejadores.utils.InformacionOrdenamiento;
import com.dolist.modelo.manejadores.utils.RangoConsulta;

/**
 * Servicios para operaciones CRUD y de negocio sobre la entidad Usuario
 * 
 * @author JGALVEZ
 */
@Stateless
public class NegocioUsuario extends NegocioAbstracto<Usuario, UsuarioDTO> {

	@EJB
	private ManejadorUsuario manejadorUsuario;

	/**
	 * Variable estatica para imprimir logs...
	 */
	private static final Logger logger = Logger.getLogger(NegocioUsuario.class.getName());

	/**
	 * Consultar usuario
	 * 
	 * @param filterBy
	 * @param orderBy
	 * @param from
	 * @param to
	 * @return
	 * @throws InvalidParameterException
	 */
	public List<UsuarioDTO> consultar(String filterBy, String orderBy, Integer from, Integer to)
			throws InvalidParameterException {
		logService(this.getClass().getName(), "consultar", filterBy, orderBy, from, to);

		List<InformacionFiltro> filtros = invocarDecodificacionFiltro(filterBy);
		List<InformacionOrdenamiento> ordenamiento = invocarDecodificacionOrdenamiento(orderBy);
		RangoConsulta rango = validarParametrosBloque(from, to);

		return convertirListaEntidadesADao(manejadorUsuario.consultar(filtros, ordenamiento, rango));
	}

	/**
	 * Crear usuario
	 * 
	 * @param usuarioDTO
	 * @return
	 */
	public UsuarioDTO crear(UsuarioDTO usuarioDTO) {

		logService(this.getClass().getName(), "crear", usuarioDTO);

		Usuario usuario = new Usuario();
		copiarPropiedades(usuario, usuarioDTO);

		manejadorUsuario.crear(usuario);

		return usuarioDTO;
	}

	/**
	 * Actualizar usuario
	 * 
	 * @param usuarioDTO
	 * @return
	 */
	public UsuarioDTO actualizar(UsuarioDTO usuarioDTO) {

		logService(this.getClass().getName(), "actualizar", usuarioDTO);

		Usuario usuario = manejadorUsuario.buscar(usuarioDTO.getUsuarioPK());
		copiarPropiedades(usuario, usuarioDTO);

		manejadorUsuario.actualizar(usuario);

		return usuarioDTO;
	}

	/**
	 * Eliminar usuario
	 * 
	 * @param tipoDocumento
	 * @param numeroDocumento
	 * @return
	 */
	public void eliminar(UsuarioPK user) {

		logService(this.getClass().getName(), "eliminar", user);
		manejadorUsuario.eliminarPorId(user);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @param nombreAtributo {@inheritDoc}
	 * @return {@inheritDoc}
	 */
	@Override
	protected boolean entidadContieneAtributo(String nombreAtributo) {
		return Usuario.contieneAtributo(nombreAtributo);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @return {@inheritDoc}
	 */
	@Override
	protected Logger getLogger() {
		return logger;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @return {@inheritDoc}
	 */
	@Override
	protected UsuarioDTO instanciarDAO() {
		return new UsuarioDTO();
	}

}
