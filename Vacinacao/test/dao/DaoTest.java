package dao;

import java.util.List;
import usuario.Administrador;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import usuario.Animal;

/**
 *
 * @author Rodrigo
 */
public class DaoTest {
    
    public DaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /*@Test
    public void testInserir() 
    {
       Dao<Administrador> gerenciador = new Dao(Administrador.class);
       Administrador teste = new Administrador("admin", "Administrador", "4343");
       gerenciador.inserir(teste);
    }*/
    
    /*@Test
    public void testInserirA() 
    {
       Dao<Animal> gerenciador = new Dao(Animal.class);
       Animal teste = new Animal("teste", 105.5f);
       gerenciador.inserir(teste);
    }*/
    
    /*@Test
    public void testExcluir() 
    {
       Dao<Administrador> gerenciador = new Dao(Administrador.class);
       gerenciador.excluir(7);
    }*/
    
    /*@Test
    public void testExcluirA() 
    {
       Dao<Animal> gerenciador = new Dao(Animal.class);
       gerenciador.excluir(1);
    }*/
    
    /*@Test
    public void testConsultar() 
    {
       Dao<Administrador> gerenciador = new Dao(Administrador.class);
       Administrador teste = new Administrador();
       teste = gerenciador.buscarPorCodigo(4);
       System.out.println(teste.toString());
    }*/
    
    @Test
    public void testConsultar() 
    {
       Dao<Animal> gerenciador = new Dao(Animal.class);
       Animal teste = new Animal();
       teste = gerenciador.buscarAnimal(2);
       System.out.println(teste.toString());
    }
   
}
