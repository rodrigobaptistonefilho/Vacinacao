package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import usuario.Administrador;
import usuario.Animal;
import util.JpaUtil;

/**
* Classe genérica para persistir objetos. 
 */
public class Dao <T> implements Serializable 
{

    private final Class<T> classe;
    EntityManager manager;

    public Dao(Class<T> classe) {
        this.classe = classe;
    }

    public T buscarPorCodigo(Object id) {
        T objeto;
        manager = JpaUtil.getEntityManager();
        objeto = manager.find(classe, id);
        manager.close();
        return objeto;
    }

    public boolean excluir(Integer id) {
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try
        {
            T temp = manager.find(classe, id);
            manager.remove(temp);
            tx.commit();
            manager.close();
            return true;
        }catch(Exception e)
        {
            manager.close();
            return false;
        }
    }

    public void inserir(T objeto) {
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(objeto);
        tx.commit();       
        return;
    }

    public List<T> listarTodos() {        
        manager = JpaUtil.getEntityManager();
        CriteriaQuery<T> query = manager.getCriteriaBuilder().createQuery(classe);
        query.select(query.from(classe));
        List<T> lista = manager.createQuery(query).getResultList();
        manager.close();      
        return lista;
    }
    
public Administrador validarLogin(String login, String senha)
    {
        Administrador temp = null;
        manager = JpaUtil.getEntityManager();
        String sql = "SELECT a FROM Administrador a WHERE a.login = :login AND a.senha =:senha";
        TypedQuery<Administrador> query = manager.createQuery(sql, Administrador.class);
        query.setParameter("login", login);
        query.setParameter("senha", senha);
        try 
        {
            temp = query.getSingleResult();
        } catch(Exception e) 
        {  
            return null;
        }finally 
        {
            manager.close();
        }
        
        return temp;
        
    }
 public Animal buscarAnimal(Integer id)
    {
        Animal temp = null;
        manager = JpaUtil.getEntityManager();
        String sql = "SELECT a FROM Animal a WHERE a.id = :n";
        TypedQuery<Animal> query = manager.createQuery(sql, Animal.class);
        query.setParameter("n", id);
        
        try 
        {
            temp = query.getSingleResult();
        } catch (Exception e) 
        {  
            return null;
        }finally 
        {
            manager.close();
        }
        
        return temp;
        
    }
}
