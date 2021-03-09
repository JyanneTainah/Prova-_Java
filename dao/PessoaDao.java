/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Pessoa;

/**
 *
 * @author Jyanne
 */
public class PessoaDao {
    
    public void cadastrarPessoa(Pessoa pessoa){
        EntityManagerFactory factory = 
                Persistence.createEntityManagerFactory("PersistSpring");
        
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(pessoa);
        em.getTransaction().commit();
        em.close();
    }
    
    public List<Pessoa> listarPessoas(){
        
        EntityManagerFactory factory = 
        Persistence.createEntityManagerFactory("PersistSpring");
        
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
       
        List<Pessoa> listaDePessoas
        =em.createQuery("select p from Pessoa as p").getResultList();
        em.close();
        return listaDePessoas;
        
    }
}
