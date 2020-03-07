package com.utes.spring.web.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utes.spring.web.app.dto.PersonaDTO;
import com.utes.spring.web.app.dto.SysUsuarioDTO;
import com.utes.spring.web.app.entity.SysUsuario;

@Service
public interface SysUsuarioService extends IParsable<SysUsuarioDTO, SysUsuario> {

	public boolean create(SysUsuarioDTO obj);

	public boolean update(SysUsuarioDTO obj);

	public boolean delete(Integer id);

	public List<SysUsuarioDTO> obtenerListadoUsuario();

	public SysUsuarioDTO loginUsuario(SysUsuarioDTO auxobj);

	public SysUsuarioDTO obtenerUsuarioPorId(Integer pk);

	public SysUsuarioDTO obtenerUsuarioPorNombreUsuario(String nombreusuario);

	public List<SysUsuarioDTO> obtenerListadoUsuarioPorNombre(String nombreusuario);

	public List<SysUsuarioDTO> obtenerListadoUsuarioPorUsuarioNombre(String nombreusuario);

	public SysUsuarioDTO obtenerUsuarioPorPersona(PersonaDTO objpersona);

	public SysUsuarioDTO obtenerUsuarioPorPersonaId(Integer idpersona);

	public List<SysUsuarioDTO> obtenerListadoUsuarioPorPerfil(String perfilnombre);

	public List<SysUsuarioDTO> obtenerListadoUsuarioPorPerfilPresolicitud(String perfilnombre, String preslestados,
			String preslopciones);

	public List<SysUsuarioDTO> obtenerListadoUsuarioPorPerfilAsignado(String perfilnombre, Integer idtem,
			Integer idperiodo);

	public List<SysUsuarioDTO> obtenerListadoUsuarioPorPerfilAsignado(String perfilnombre);

	public List<SysUsuarioDTO> obtenerListadoUsuarioPorPerfilSeleccion(String perfilnombre, Integer periodo);

	public List<SysUsuarioDTO> obtenerListadoUsuarioPorPerfil(String perfilnombre, Integer idpersonatutor);

	public List<SysUsuarioDTO> obtenerListadoUsuarioPorUsuarioId(Integer idusuario);

	public List<SysUsuarioDTO> obtenerListadoUsuarioPorTemaPorPerfil(String perfilnombre, Integer idusuario,
			String estados);

	public SysUsuarioDTO obtenerUsuarioPorCorreo(String correo);

	public List<SysUsuarioDTO> obtenerListadoUsuarioPorPerfilPresolicitud(String perfilnombre, String preslestados,
			String preslopciones, Integer idinscripcion);

	public List<SysUsuarioDTO> obtenerListadoUsuarioPorTemaPorPerfil(String perfilnombre, Integer idusuario,
			String estados, String idperiodo);

}
