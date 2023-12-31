package cr.ac.ucr.paraiso.ie.progra2.webapp.session.service;

import cr.ac.ucr.paraiso.ie.progra2.webapp.session.models.Curso;
import cr.ac.ucr.paraiso.ie.progra2.webapp.session.models.Profesor;
import org.jdom2.JDOMException;

import java.io.IOException;
import java.util.List;

public interface ProfesorService {
    List<Profesor> listar() throws IOException, JDOMException;
}
