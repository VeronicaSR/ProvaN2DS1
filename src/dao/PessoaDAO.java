/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Pessoa;

/**
 *
 * @author veronica
 */

public class PessoaDAO {
    
    public EntityManager getEM(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("n2PU");
        return factory.createEntityManager();
    }
    
    public Pessoa salvar (Pessoa pessoa) throws Exception{
        EntityManager em = getEM();
        try{
            em.getTransaction().begin();
            em.persist(pessoa);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally{
            em.close();
        }
        
        return pessoa;
    }
    
    public Pessoa atualizar (Pessoa pessoa) throws Exception{
        EntityManager em = getEM();
        try{
            em.getTransaction().begin();
            em.merge(pessoa);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
        
        return pessoa;
    }
    
    public Pessoa consultaPorId (long id) throws Exception{
        EntityManager em = getEM();
        Pessoa pessoa = null;
        try{
            pessoa = em.find(Pessoa.class, id);
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
        
        return pessoa;
    }
    
    public String excluir (long id) throws Exception{
        EntityManager em = getEM();
        Pessoa pessoa = em.find(Pessoa.class, id);
        try{
            em.getTransaction().begin();
            em.remove(pessoa);
            em.getTransaction().commit();    
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
        
        return "Excluido com Sucesso";
    }
    
}
