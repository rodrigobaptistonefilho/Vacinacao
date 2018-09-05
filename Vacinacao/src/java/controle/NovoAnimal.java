package controle;

import dao.Dao;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import usuario.Animal;

@ManagedBean (name="novoAnimal")
@ViewScoped
public class NovoAnimal implements Serializable 
{
    private Animal animal;
    private Dao<Animal> dao;  
    
    public NovoAnimal()
    {
        animal = new Animal();
        dao = new Dao(Animal.class);
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    
    public void cadastrar()
    {
        dao.inserir(animal);
        FacesContext contexto = FacesContext.getCurrentInstance();
        contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Animal cadastrado", null));
        animal = new Animal();
    }
    
     public void consultar()
    {
        Animal temp = dao.buscarAnimal(getAnimal().getId());
        FacesContext contexto = FacesContext.getCurrentInstance();
        
        if(temp != null)
        {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, temp.toString(), null));
        }else
        {
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ID não existe", null));
        }
    }
   
    public Dao<Animal> getDao() {
        return dao;
    }

    public void setDao(Dao<Animal> dao) {
        this.dao = dao;
    }
    
    
}