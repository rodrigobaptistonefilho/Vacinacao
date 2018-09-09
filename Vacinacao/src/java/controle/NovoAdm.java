package controle;

import dao.Dao;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import usuario.Administrador;

@ManagedBean (name="novoAdm")
@ViewScoped
public class NovoAdm implements Serializable 
{
    private Administrador usuario;
    private Dao<Administrador> dao; 
    
    public NovoAdm()
    {
        usuario = new Administrador();
        dao = new Dao(Administrador.class);
    }
    
    public String logar()
    {
        Administrador temp = dao.validarLogin(getUsuario().getLogin(), getUsuario().getSenha());
        FacesContext contexto = FacesContext.getCurrentInstance();
        
        if(temp == null)
        {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Não foi possível logar", null));
            return null;
        }
        
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        HttpSession session = (HttpSession) ectx.getSession(true);
        session.setAttribute("usuarioLogado", temp);
        return "/menu";
    }  
    public void deslogar()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        HttpSession session = (HttpSession) ectx.getSession(false);
        session.setAttribute("usuarioLogado", null);
    }
    
    public Administrador getUsuario() {
        return usuario;
    }

    public void setUsuario(Administrador usuario) {
        this.usuario = usuario;
    }

    public Dao<Administrador> getDao() {
        return dao;
    }

    public void setDao(Dao<Administrador> dao) {
        this.dao = dao;
    }
}
