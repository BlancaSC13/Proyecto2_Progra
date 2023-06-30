package test;

import cr.ac.ucr.paraiso.ie.progra2.webapp.session.data.AutorXMLDAO;
import cr.ac.ucr.paraiso.ie.progra2.webapp.session.models.Autor;
import org.jdom2.JDOMException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class AutoresXMLDAOTest {
    AutorXMLDAO autoresXMLDAO;


    @Before
    public void init() throws IOException, JDOMException {
        AutorXMLDAO.crearDocumento("autores.xml");
        autoresXMLDAO = AutorXMLDAO.abrirDocumento("autores.xml");

        autoresXMLDAO.insertarAutores( new Autor(1, "J.k", "Rowilling"));
        autoresXMLDAO.insertarAutores( new Autor(2, "Gabriel", "García"));



    }

    @Test
    public void probarXML(){


    }



}