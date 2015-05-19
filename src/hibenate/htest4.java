package hibenate;

import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.zqx;
import entity.zqx1;

public class htest4 {

	public static void main(String[] args) {

		Session s = basetest.sf.openSession();
		System.out.println("session´ò¿ª");
		Transaction tx = s.beginTransaction();
		try {
			
			zqx z = (zqx) s.get(zqx.class, new Long(3));
			zqx1 z1=(zqx1) z.getSet().iterator().next();
			z.getSet().remove(z1);
			z1.setZqxid(null);
//			Iterator<zqx1> i = z.getSet().iterator();
//			while(i.hasNext()){
//				zqx1 z1=(zqx1)i.next();
//				i.remove();
//			}
			
			/*zqx1 z1 = (zqx1) s.get(zqx1.class, new Long(1));
			z.getSet().remove(z1);
			z1.setZqxid(null);*/
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
