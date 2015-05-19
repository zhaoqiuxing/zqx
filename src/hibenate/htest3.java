package hibenate;

import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.zqx;
import entity.zqx1;

public class htest3 {

	public static void main(String[] args) {

		Session s = basetest.sf.openSession();
		System.out.println("session´ò¿ª");
		Transaction tx = s.beginTransaction();
		try {
			
			zqx z = (zqx) s.load(zqx.class, new Long(6));
			System.out.println(z.getName()+z.getId());
		s.delete(z);
		System.out.println(s.contains(z));
			
			/*zqx1 z1 = (zqx1) s.get(zqx1.class, new Long(1));
			z.getSet().remove(z1);
			z1.setZqxid(null);*/
			tx.commit();
			System.out.println(z.getName()+z.getId());
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
