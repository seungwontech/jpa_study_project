package jpamember.start;

import javax.persistence.*;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            logic(em);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

    public static void logic(EntityManager em) {
        Board board = new Board();
        em.persist(board);
        System.out.println("board.id = " + board.getId());

        /*
        String id = "id4";
        Member member = new Member();
        member.setId(id);
        member.setUsername("LEE");
        member.setAge(2);

        // 등록
        em.persist(member);
        // 수정
        member.setAge(20);

        // 한 건 조회
        Member findMember = em.find(Member.class, id);
        System.out.println("findMember : " + findMember.getUsername() + ", age : " + +findMember.getAge());

        // 목록 조회
        List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
        System.out.println("members : " + members.size());

        // 삭제
        em.remove(member);
        */
    }
}