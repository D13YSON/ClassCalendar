package dao;

import dao.exceptions.NonexistentEntityException;
import dao.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Aluno;

public class AlunoJpaController implements Serializable {
    
     private EntityManagerFactory emf = null;
     
    public AlunoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
 
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Aluno aluno) throws PreexistingEntityException, Exception {
        
         aluno.setIdAluno(this.generatedNextId());
        
        EntityManager em = null;
        try {
            em = this.emf.createEntityManager();
            
            em.getTransaction().begin();
            
            em.persist(aluno);
            
            em.getTransaction().commit();
            
        } catch (Exception ex) {
            if (findAluno(aluno.getIdAluno()) != null) {
                throw new PreexistingEntityException("Aluno " + aluno + " já existe.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Aluno aluno) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            
            em = getEntityManager();
            
            em.getTransaction().begin();
            
            aluno = em.merge(aluno);
            
            em.getTransaction().commit();
            
        } catch (Exception ex) {
            
            String msg = ex.getLocalizedMessage();
            
            if (msg == null || msg.length() == 0) {
                
                int id = aluno.getIdAluno();
                
                if (findAluno(id) == null) {
                    
                    throw new NonexistentEntityException("O aluno com o id=" + id + " não existe mais.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Aluno aluno;
            
            try {
                aluno = em.getReference(Aluno.class, id);
                aluno.getIdAluno();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("O aluno com o id=" + id + " não existe mais." );
            }
            em.remove(aluno);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Aluno findAluno(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Aluno.class, id);
        } finally {
            em.close();
        }
    }
    
    public List<Aluno> findAllAluno() {
        
        EntityManager em = this.emf.createEntityManager();
        
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Aluno.class));
            Query q = em.createQuery(cq);
            
            return q.getResultList();

        } catch (Exception e) {
            
            System.out.println(e);
            return null;
            
        } finally {
            em.close();
        }
    }
    
    private int generatedNextId(){
        EntityManager em = this.emf.createEntityManager();
        
        try {
            int nextId = (int) em.createNativeQuery("SELECT alunos.idaluno FROM alunos alunos ORDER BY alunos.idaluno DESC").getResultList().get(0) + 1;
            return nextId;
            
        } catch (java.lang.ArrayIndexOutOfBoundsException e){
            
            return 1;
        }
    } 
}
