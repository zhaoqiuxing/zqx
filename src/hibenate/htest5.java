package hibenate;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.zqx;

public class htest5 {

	public static void main(String[] args) {
		Session s = basetest.sf.openSession();
		System.out.println("session´ò¿ª");
		Transaction tx = s.beginTransaction();
		try {
			zqx z =new zqx();
			
			z.setName("ag");
			s.save(z);
			s.flush();
			s.refresh(z);
			Long id=z.getId();
			
			
		
			//s.close();
			z.setName("ff");
			System.out.println(z.getName()+z.getId()+z.getAge());
			tx.commit();
			
			//z=null;
			/*zqx z1 =new zqx();
			z1.setName("ag");
			zqx z =new zqx();
			z.setName("ag");
			s.save(z);
			/*s.setFlushMode(FlushMode.COMMIT);
			zqx z3=(zqx)s.get(zqx.class, new Long(1));
			z3.setAge(3);
			boolean b=s.contains(z3);
			zqx z2=(zqx)s.get(zqx.class, new Long(2));
			System.out.println(z2.getAge());*/
			
			/*zqx z =new zqx();
			z.setName("ag");
			s.save(z);*/

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
