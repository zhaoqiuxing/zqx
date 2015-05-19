package hibenate;

import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.zqx;
import entity.zqx1;

public class htest2 {

	public static void main(String[] args) {

		Session s = basetest.sf.openSession();
		System.out.println("session´ò¿ª");
		Transaction tx = s.beginTransaction();
		try {
			zqx z = new zqx();
			z.setAge(1);
			z.setName("zqx");

			zqx1 z1 = new zqx1();
			z1.setName("zqx1");

			zqx1 z11 = new zqx1();
			z11.setName("zqx11");

			z11.setZqxid(z);
			z1.setZqxid(z);
			z.getSet().add(z1);
			z.getSet().add(z11);

			s.save(z);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		if (s.isOpen()) {
			s.close();
			basetest.sf.close();
			System.out.println("session¹Ø±Õ");
		}
	}

}
