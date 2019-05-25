package com.dolist.web.servicio;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.management.RuntimeErrorException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.dolist.modelo.dtos.UsuarioDTO;
import com.dolist.modelo.entidades.UsuarioPK;
import com.dolist.modelo.excepciones.InvalidParameterException;
import com.dolist.negocio.NegocioUsuario;
import com.dolist.web.servicio.utils.ConstantesServicios;

/**
 * Servicios REST para operaciones CRUD y de negocio sobre la entidad Usuario
 * 
 * @author JGALVEZ
 *
 */
@Stateless
@Path("servicios/usuario")
public class ServicioUsuario {

	@EJB
	private NegocioUsuario negocioUsuario;

	/**
	 * Variable estatica para imprimir logs...
	 */
	private static final Logger logger = Logger.getLogger(ServicioUsuario.class.getName());

	/**
	 * Método para consultar usuarios aplicando filtros opcionales
	 * 
	 * @param filterBy
	 * @param orderBy
	 * @param from
	 * @param to
	 * @return
	 * @throws InvalidParameterException
	 */
	@GET
	@Produces({ APPLICATION_JSON })
	public List<UsuarioDTO> consultar(@QueryParam("filterBy") String filterBy, @QueryParam("orderBy") String orderBy,
			@QueryParam("from") Integer from, @QueryParam("to") Integer to) throws InvalidParameterException {

		return negocioUsuario.consultar(filterBy, orderBy, from, to);
	}

	/**
	 * Crea el usuario que se pasa como parámetro en la base de datos.
	 * 
	 * @param usuarioDTO
	 * @return
	 */
	@POST
	@Consumes({ APPLICATION_JSON })
	@Produces({ APPLICATION_JSON })
	public Response crear(UsuarioDTO usuarioDTO) {

		Response response = null;
		try {
			negocioUsuario.crear(usuarioDTO);
			response = Response.status(Response.Status.OK).header(ConstantesServicios.ACCESS_CONTROL_ALLOW_HEADERS, ConstantesServicios.X_EXTRA_HEADER)
					.build();
		} catch (Exception e) {
			logger.error(ConstantesServicios.ERROR_CREAR_USUARIO, e);
			throw new RuntimeErrorException(null, ConstantesServicios.ERROR_CREAR_USUARIO);
		}
		return response;

	}

	/**
	 * Actualiza en la base de datos el usuario que se pasa como parámetro.
	 * 
	 * @param usuarioDTO
	 * @return
	 */
	@PUT
	@Consumes({ APPLICATION_JSON })
	@Produces({ APPLICATION_JSON })
	public Response actualizar(UsuarioDTO usuarioDTO) {

		Response response = null;
		try {
			negocioUsuario.actualizar(usuarioDTO);
			response = Response.status(Response.Status.OK).header(ConstantesServicios.ACCESS_CONTROL_ALLOW_HEADERS, ConstantesServicios.X_EXTRA_HEADER)
					.build();
		} catch (Exception e) {
			logger.error(ConstantesServicios.ERROR_ACTUALIZAR_USUARIO, e);
			throw new RuntimeErrorException(null, ConstantesServicios.ERROR_ACTUALIZAR_USUARIO);
		}
		return response;
	}

	/**
	 * Elimina el usuario con el identificador que se pasa como parámetro.
	 * 
	 * @param tipoDocumento
	 * @param numeroDocumento
	 * @return
	 */
	@DELETE
	public Response eliminar(UsuarioPK usuarioPK) {

		Response response = null;
		try {
			negocioUsuario.eliminar(usuarioPK);
			response = Response.status(Response.Status.OK).header(ConstantesServicios.ACCESS_CONTROL_ALLOW_HEADERS, ConstantesServicios.X_EXTRA_HEADER)
					.build();
		} catch (Exception e) {
			logger.error(ConstantesServicios.ERROR_ELIMINAR_USUARIO, e);
			throw new RuntimeErrorException(null, ConstantesServicios.ERROR_ELIMINAR_USUARIO);
		}
		return response;

	}

}
