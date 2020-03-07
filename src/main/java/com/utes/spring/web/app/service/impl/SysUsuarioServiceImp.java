package com.utes.spring.web.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utes.spring.web.app.dto.PersonaDTO;
import com.utes.spring.web.app.dto.SysUsuarioDTO;
import com.utes.spring.web.app.entity.Persona;
import com.utes.spring.web.app.entity.SysPerfil;
import com.utes.spring.web.app.entity.SysUsuario;
import com.utes.spring.web.app.repository.PersonaRepository;
import com.utes.spring.web.app.repository.SysPerfilRepository;
import com.utes.spring.web.app.repository.SysUsuarioRepository;
import com.utes.spring.web.app.service.PersonaService;
import com.utes.spring.web.app.service.SysPerfilService;
import com.utes.spring.web.app.util.Seguridad;

@Service("SysUsuarioService")
public class SysUsuarioServiceImp implements com.utes.spring.web.app.service.SysUsuarioService {

	@Autowired
	private SysUsuarioRepository sysUsuarioRepository;
	@Autowired
	private PersonaRepository personaRepository;
	@Autowired
	private SysPerfilRepository sysPerfilRepository;
	@Autowired
	private PersonaService personaService;
	@Autowired
	private SysPerfilService sysPerfilService;
	private final String key = "92AE31A79FEEB2A3"; // llave
	private final String iv = "0123456789ABCDEF";

	@Override
	@Transactional
	public boolean create(SysUsuarioDTO obj) {
		boolean success = false;
		try {
			SysUsuario sysUsuarioBD = new SysUsuario();
			this.convertirDtoToEntity(obj, sysUsuarioBD);
			this.sysUsuarioRepository.save(sysUsuarioBD);
			success = true;
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional
	public boolean update(SysUsuarioDTO obj) {
		boolean success = false;
		try {
			SysUsuario sysUsuarioBD = this.sysUsuarioRepository.findById(obj.getIdUsr()).orElse(null);
			if (sysUsuarioBD != null) {
				this.convertirDtoToEntity(obj, sysUsuarioBD);
				this.sysUsuarioRepository.save(sysUsuarioBD);
				success = true;
			}
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional
	public boolean delete(Integer id) {
		boolean success = false;
		try {
			SysUsuario sysUsuarioBD = this.sysUsuarioRepository.findById(id).orElse(null);
			if (sysUsuarioBD != null) {
				this.sysUsuarioRepository.delete(sysUsuarioBD);
				success = true;
			}
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional(readOnly = true)
	public List<SysUsuarioDTO> obtenerListadoUsuario() {
		final List<SysUsuario> listSysUsuariosBD = this.sysUsuarioRepository.findAll();
		final List<SysUsuarioDTO> resultado = new ArrayList<SysUsuarioDTO>();
		if (listSysUsuariosBD != null && !listSysUsuariosBD.isEmpty()) {
			for (final SysUsuario sysUsuario : listSysUsuariosBD) {
				resultado.add(this.convertirEntityToDto(sysUsuario, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public SysUsuarioDTO loginUsuario(SysUsuarioDTO auxobj) {
		String password = auxobj.getUsrClave();
		try {
			auxobj.setUsrClave(Seguridad.encrypt(this.key, this.iv, password));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		SysUsuario sysUsuarioBD = this.sysUsuarioRepository
				.findByUsrUsuarioAndUsrClaveAndUsrActivo(auxobj.getUsrUsuario(), auxobj.getUsrClave(), true);
		if (sysUsuarioBD != null) {
			return this.convertirEntityToDto(sysUsuarioBD, true, true);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public SysUsuarioDTO obtenerUsuarioPorId(Integer pk) {
		SysUsuario sysUsuarioBD = this.sysUsuarioRepository.findById(pk).orElse(null);
		if (sysUsuarioBD != null) {
			return this.convertirEntityToDto(sysUsuarioBD, true, true);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public SysUsuarioDTO obtenerUsuarioPorNombreUsuario(String nombreusuario) {
		SysUsuario sysUsuarioBD = this.sysUsuarioRepository.findByUsrUsuarioAndUsrActivo(nombreusuario, true);
		if (sysUsuarioBD != null) {
			return this.convertirEntityToDto(sysUsuarioBD, true, true);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<SysUsuarioDTO> obtenerListadoUsuarioPorNombre(String nombreusuario) {
		final List<SysUsuario> listSysUsuariosBD = this.sysUsuarioRepository
				.findByUsrUsuarioLikeAndUsrActivo(nombreusuario, true);
		final List<SysUsuarioDTO> resultado = new ArrayList<SysUsuarioDTO>();
		if (listSysUsuariosBD != null && !listSysUsuariosBD.isEmpty()) {
			for (final SysUsuario sysUsuario : listSysUsuariosBD) {
				resultado.add(this.convertirEntityToDto(sysUsuario, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public List<SysUsuarioDTO> obtenerListadoUsuarioPorUsuarioNombre(String nombreusuario) {
		final List<SysUsuario> listSysUsuariosBD = this.sysUsuarioRepository
				.findByUsrUsuarioLikeAndUsrActivo(nombreusuario, true);
		final List<SysUsuarioDTO> resultado = new ArrayList<SysUsuarioDTO>();
		if (listSysUsuariosBD != null && !listSysUsuariosBD.isEmpty()) {
			for (final SysUsuario sysUsuario : listSysUsuariosBD) {
				resultado.add(this.convertirEntityToDto(sysUsuario, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public SysUsuarioDTO obtenerUsuarioPorPersona(PersonaDTO objpersona) {
		SysUsuario sysUsuarioBD = this.sysUsuarioRepository.findByPersonaIdPer(objpersona.getIdPer());
		if (sysUsuarioBD != null) {
			return this.convertirEntityToDto(sysUsuarioBD, true, true);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public SysUsuarioDTO obtenerUsuarioPorPersonaId(Integer idpersona) {
		SysUsuario sysUsuarioBD = this.sysUsuarioRepository.findByPersonaIdPer(idpersona);
		if (sysUsuarioBD != null) {
			return this.convertirEntityToDto(sysUsuarioBD, true, true);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<SysUsuarioDTO> obtenerListadoUsuarioPorPerfil(String perfilnombre) {
		final List<SysUsuario> listSysUsuariosBD = this.sysUsuarioRepository.findBySysPerfilPrfNombre(perfilnombre);
		final List<SysUsuarioDTO> resultado = new ArrayList<SysUsuarioDTO>();
		if (listSysUsuariosBD != null && !listSysUsuariosBD.isEmpty()) {
			for (final SysUsuario sysUsuario : listSysUsuariosBD) {
				resultado.add(this.convertirEntityToDto(sysUsuario, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public List<SysUsuarioDTO> obtenerListadoUsuarioPorPerfilPresolicitud(String perfilnombre, String preslestados,
			String preslopciones) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<SysUsuarioDTO> obtenerListadoUsuarioPorPerfilAsignado(String perfilnombre, Integer idtem,
			Integer idperiodo) {
		final List<SysUsuario> listSysUsuariosBD = this.sysUsuarioRepository
				.obtenerListadoUsuarioPorPerfilAsignadoIdTema(perfilnombre, idtem, idperiodo);
		final List<SysUsuarioDTO> resultado = new ArrayList<SysUsuarioDTO>();
		if (listSysUsuariosBD != null && !listSysUsuariosBD.isEmpty()) {
			for (final SysUsuario sysUsuario : listSysUsuariosBD) {
				resultado.add(this.convertirEntityToDto(sysUsuario, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public List<SysUsuarioDTO> obtenerListadoUsuarioPorPerfilAsignado(String perfilnombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<SysUsuarioDTO> obtenerListadoUsuarioPorPerfilSeleccion(String perfilnombre, Integer periodo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<SysUsuarioDTO> obtenerListadoUsuarioPorPerfil(String perfilnombre, Integer idpersonatutor) {
		final List<SysUsuario> listSysUsuariosBD = this.sysUsuarioRepository
				.findBySysPerfilPrfNombreAndPersonaIdPerNot(perfilnombre, idpersonatutor);
		final List<SysUsuarioDTO> resultado = new ArrayList<SysUsuarioDTO>();
		if (listSysUsuariosBD != null && !listSysUsuariosBD.isEmpty()) {
			for (final SysUsuario sysUsuario : listSysUsuariosBD) {
				resultado.add(this.convertirEntityToDto(sysUsuario, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public List<SysUsuarioDTO> obtenerListadoUsuarioPorUsuarioId(Integer idusuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<SysUsuarioDTO> obtenerListadoUsuarioPorTemaPorPerfil(String perfilnombre, Integer idusuario,
			String estados) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public SysUsuarioDTO obtenerUsuarioPorCorreo(String correo) {
		SysUsuario sysUsuarioBD = this.sysUsuarioRepository.findByUsrCorreoAndUsrActivo(correo, true);
		if (sysUsuarioBD != null) {
			return this.convertirEntityToDto(sysUsuarioBD, true, true);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<SysUsuarioDTO> obtenerListadoUsuarioPorPerfilPresolicitud(String perfilnombre, String preslestados,
			String preslopciones, Integer idinscripcion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<SysUsuarioDTO> obtenerListadoUsuarioPorTemaPorPerfil(String perfilnombre, Integer idusuario,
			String estados, String idperiodo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void convertirDtoToEntity(SysUsuarioDTO objectDTO, SysUsuario objectEntity) {
		BeanUtils.copyProperties(objectDTO, objectEntity, "idUsr", "persona", "sysPerfil", "idPersona", "idSysPerfil");
		if (objectDTO.getIdPersona() != null) {
			Persona persona = this.personaRepository.findById(objectDTO.getIdPersona()).orElse(null);
			objectEntity.setPersona(persona);
		}
		if (objectDTO.getIdSysPerfil() != null) {
			SysPerfil sysPerfil = this.sysPerfilRepository.findById(objectDTO.getIdSysPerfil()).orElse(null);
			objectEntity.setSysPerfil(sysPerfil);
		}
	}

	@Override
	public SysUsuarioDTO convertirEntityToDto(SysUsuario objectEntity, boolean loadOneR, boolean loadAllList) {
		SysUsuarioDTO objectDTO = new SysUsuarioDTO();
		BeanUtils.copyProperties(objectEntity, objectDTO, "usrClave", "persona", "sysPerfil");
		if (loadOneR) {
			if (objectEntity.getPersona() != null) {
				objectDTO.setPersona(this.personaService.convertirEntityToDto(objectEntity.getPersona(), true, false));
				objectDTO.setIdPersona(objectEntity.getPersona().getIdPer());
			}
			if (objectEntity.getSysPerfil() != null) {
				objectDTO.setSysPerfil(
						this.sysPerfilService.convertirEntityToDto(objectEntity.getSysPerfil(), true, false));
				objectDTO.setIdSysPerfil(objectEntity.getSysPerfil().getIdPrf());
			}
		}
		return objectDTO;
	}

}
