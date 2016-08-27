package mx.com.comr.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mx.com.comr.capadatos.IPersonaDao;
import mx.com.comr.capadatos.domain.Persona;
import mx.com.comr.servicios.IPersonaService;


//@ContextConfiguration(locations = {"classpath:datasource-test.xml", "classpath:applicationContext.xml"})
@Controller
public class HolaController {
	
	private static Log log = LogFactory.getLog(HolaController.class);
	
	@Autowired 
	private IPersonaService personaService;
	
	
	
	@RequestMapping("irHola")
	public ModelAndView redireccion(){
		log.info("Entro al metodo mapeado con irHola");
		ModelAndView mv = new ModelAndView();
		try{
			mv.setViewName("hola-mvc");
			mv.addObject("msg", "This a message made by controller of spring mvc, Omar Munguia");
						
		}catch(Exception e){
			log.error(e);
			mv = redireccionarError(mv, e.getMessage());
		}
		log.info("Redireccionando a hola-mvc");			
		return mv;
	}
	
	@RequestMapping("datosPersona")
	public ModelAndView listarPersonas(){
		log.info("Entro al metodo mapeado con listarPersonas");
		ModelAndView mv = new ModelAndView();
		try{
			mv.setViewName("datosPersona");
			Persona p = personaService.recuperarPersona(new Persona(17));
			log.info(p);
			mv.addObject("msg", "Nombre:" + p.getNombre());
						
		}catch(Exception e){
			log.error(e);
			mv = redireccionarError(mv, e.getMessage());
		}
		log.info("Redireccionando");			
		return mv;
	}
	
	
	public ModelAndView redireccionarError(ModelAndView mv, String msg){				
		try{
			mv.setViewName("error");
			mv.addObject("msg", msg);
						
		}catch(Exception e){
			log.error(e);
			mv.setViewName("error");
		}			
		return mv;
	} 
}
