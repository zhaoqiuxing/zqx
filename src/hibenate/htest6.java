package hibenate;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.zqx;
import entity.zqx1;

public class htest6 {

	public static void main(String[] args) {
		Session s = basetest.sf.openSession();
		System.out.println("session´ò¿ª");
		Transaction tx = s.beginTransaction();
		try {
			zqx z=new zqx();
			z.setAge(2);
			z.setName("f");
			s.saveOrUpdate(z);
			tx.commit();
			s.close();
			Session s1 = basetest.sf.openSession();
			Transaction tx1 = s1.beginTransaction();
			s1.saveOrUpdate(z);
			System.out.println(s1.contains(z));
			tx1.commit();
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
