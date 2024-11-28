package aplicacao;

import dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Programa {
    public static void main(String[] args) {

        //Instancia objetos para gerenciar acesso a dados com jpa
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-maven");
        EntityManager em = emf.createEntityManager();

        /* Operação insert na base de dados
        Pessoa p1 = new Pessoa(null, "Maria", "maria@gmail.com");
        em.getTransaction().begin();
        em.persist(p1);
        em.getTransaction().commit();
        */

        /* Operação select na base de dados
        Pessoa p = em.find(Pessoa.class, 2);
         */

        //Operação delete na base de dados
        Pessoa p = em.find(Pessoa.class, 2);
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();

        System.out.println("Pronto");

        //Fechando conexões
        em.close();
        emf.close();
    }
}
