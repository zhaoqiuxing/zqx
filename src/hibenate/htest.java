package hibenate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.zqx;
import entity.zqx1;

public class htest {

	public static void main(String[] args) {

		Session s = basetest.sf.openSession();
		System.out.println("session´ò¿ª");
		Transaction tx = s.beginTransaction();
		try {
			/*zqx z=new zqx();
			z.setAge(1);
			z.setName("zqx");
			//s.save(z);
			
			zqx1 z1=new zqx1();
			z1.setName("zqx1");
			z1.setZqxid(z);
			zqx1 z11=new zqx1();
			z11.setName("zqx11");
			z11.setZqxid(z);
			System.out.println(z.getId());
			s.save(z);
			s.save(z1);
			s.save(z11);*/
			zqx1 z11=(zqx1)s.get(zqx1.class, new Long(1));
			System.out.println("------------"+z11.getZqxid().getName());
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
