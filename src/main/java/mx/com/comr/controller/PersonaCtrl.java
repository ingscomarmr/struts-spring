package mx.com.comr.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import mx.com.comr.capadatos.IPersonaDao;
import mx.com.comr.capadatos.domain.Persona;
import mx.com.comr.servicios.IPersonaService;
import org.springframework.util.StringUtils;

@Controller
public class PersonaCtrl {
	private static Log log = LogFactory.getLog(HolaController.class);

	@Autowired
	private IPersonaService personaService;

	@RequestMapping(value="/altaPersona", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView altaPersona(Persona p, ModelAndView model) {
		log.info("Alta de persona:" + p.toString());
		ModelAndView mv = new ModelAndView();
		try {
			
			if(p==null || StringUtils.isEmpty(p.getNombre()) 
			|| StringUtils.isEmpty(p.getApeMaterno()) || StringUtils.isEmpty(p.getApePaterno())
			|| StringUtils.isEmpty(p.getEmail())){
				throw new Exception("Datos incompletos");				
			}
			
			Persona p2 = personaService.recuperarPersonaEmail(p);
			if(p2!=null && p2.getEmail().equals(p.getEmail())){
				throw new Exception("Otra persona ya esta utilizando los mismos datos de correo..");
			}
			
			personaService.agregarPersona(p);
					
			mv.setViewName("datosPersona");			
			mv.addObject("p", p);
						
		} catch (Exception e) {
			log.error(e);
			mv = redireccionarError(mv, e.getMessage());
		}
		log.info("Redireccionando");
		return mv;
	}

	@RequestMapping("agregarPeronaForm")
	public ModelAndView agregarPeronaForm() {
		log.info("Redirigir al form de alta");
		ModelAndView mv = new ModelAndView();
		try {
			mv.setViewName("agregarUsuario");			
		} catch (Exception e) {
			log.error(e);
			mv = redireccionarError(mv, e.getMessage());
		}
		log.info("Redireccionando");
		return mv;
	}
	
	@ModelAttribute("persona")
	public Persona createModel() {
	    return new Persona();
	}
	
	public ModelAndView redireccionarError(ModelAndView mv, String msg) {
		try {
			mv.setViewName("error");
			mv.addObject("msg", msg);

		} catch (Exception e) {
			log.error(e);
			mv.setViewName("error");
		}
		return mv;
	}
}
