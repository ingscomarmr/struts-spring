package mx.com.comr.capadatos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.com.comr.capadatos.domain.Persona;

@Repository
@Transactional
public class PersonaDaoImpl  implements IPersonaDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	public PersonaDaoImpl(@Qualifier(value = "sessionFactory")SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * * Se necesita de una transaccion activa por ello la prueba unitaria
	 * utiliza @Transactional
	 */
	
	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void insertPersona(Persona persona) {
		currentSession().saveOrUpdate(persona);
	}

	@Transactional
	public void insert(Persona persona) {
		currentSession().saveOrUpdate(persona);
	}

	@Transactional
	public void update(Persona oUpdate) {
		currentSession().update(oUpdate);
	}

	@Transactional
	public void delete(Persona oDelete) {		
		currentSession().delete(oDelete);
	}

	@Transactional(readOnly = true)
	public Persona findById(long idPersona) {
		return (Persona) currentSession().get(Persona.class, idPersona);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Persona> findAll() {
		return currentSession().createQuery("from Persona").list();
	}

	@Transactional(readOnly = true)
	public long contador() {
		// TODO Auto-generated method stub
		int count = ((Long)currentSession().createQuery("select count(*) from Persona").uniqueResult()).intValue();
		return count;
	}

	@Transactional(readOnly = true)
	public Persona getByEmail(Persona persona) {
		Persona p = ((Persona)currentSession().createQuery("from Persona p where p.email='"+persona.getEmail()+"'").uniqueResult());
		return p;
	}

}
