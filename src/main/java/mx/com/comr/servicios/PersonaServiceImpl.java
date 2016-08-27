package mx.com.comr.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.comr.capadatos.IPersonaDao;
import mx.com.comr.capadatos.domain.Persona;

@Service("personaService")
@Transactional
public class PersonaServiceImpl implements IPersonaService{

	@Autowired
	IPersonaDao personaDao;
	
	public List<Persona> listarPersonas() {
		return personaDao.findAll();
	}

	public Persona recuperarPersona(Persona persona) {
		return personaDao.findById(persona.getIdPersona());
	}

	public void agregarPersona(Persona persona) {
		personaDao.insert(persona);
		
	}

	public void modificarPersona(Persona persona) {
		personaDao.update(persona);
		
	}

	public void eliminarPersona(Persona persona) {
		personaDao.delete(persona);
		
	}

	public Persona recuperarPersonaEmail(Persona p) {
		return personaDao.getByEmail(p);
	}

}
