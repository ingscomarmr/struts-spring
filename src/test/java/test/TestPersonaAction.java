package test;

import servletunit.struts.MockStrutsTestCase;

public class TestPersonaAction extends MockStrutsTestCase {
	public void testListar() {		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		logger.info("Iniciando test Listar con Struts");
		System.out.println();
		
		setRequestPathInfo("/inicio");
		addRequestParameter("metodo", "accionListar");
		actionPerform();		
		verifyForward("listar");
		
		System.out.println();System.out.println();System.out.println();
		logger.info("Se redireccion� exitosamente");
		
		verifyNoActionErrors();
		System.out.println();System.out.println();
		logger.info("T�rmino test Listar con Struts");
		System.out.println();
	}
	
}
