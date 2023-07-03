package cr.ac.ucr.paraiso.ie.progra2.webapp.session.service;


import cr.ac.ucr.paraiso.ie.progra2.webapp.session.data.EditorialesXMLDAO;
import cr.ac.ucr.paraiso.ie.progra2.webapp.session.models.Editorial;
import org.jdom2.JDOMException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EditorialServiceImp implements EditorialService{
    private EditorialesXMLDAO editorialesXMLDAO;
    @Override
    public List<Editorial> listar() throws IOException, JDOMException {
        editorialesXMLDAO = EditorialesXMLDAO.abrirDocumento("editoriales.xml");
        ArrayList<Editorial> editoriales = editorialesXMLDAO.getEditoriales();
        return editoriales;
    }
}
