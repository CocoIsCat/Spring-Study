package hellojpa;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");

//            Member findMember1 = em.find(Member.class, 100L);
//            Member findMember2 = em.find(Member.class, 100L);
//            System.out.println("findMember.getName() = " + findMember.getName());
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println(findMember1 == findMember2);
//            em.persist(member1);
//            em.persist(member2);

            Member member = em.find(Member.class, 150L);
            member.setName("ZZZZZZZ");

//            em.persist(member);

            System.out.println("=============================");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
