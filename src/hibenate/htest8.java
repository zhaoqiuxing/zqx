package hibenate;

import java.math.BigInteger;

import named.intercetr;

import org.hibernate.CacheMode;
import org.hibernate.Query;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.zqx;

public class htest8 {

	public static void main(String[] args) {
		Session s = basetest.sf.withOptions().interceptor(new intercetr())
				.openSession();
//		EventListenerRegistry registry = ((SessionFactoryImpl) sessionFactory).getServiceRegistry().getService(
//	            EventListenerRegistry.class)
		System.out.println("session´ò¿ª");
		Transaction tx = s.beginTransaction();
		try {
			String hql ="update zqx set age= :zqx2,name=:zqx where id=:id";
			Query q=s.createQuery(hql).setString("zqx", "zqxaa").setInteger("zqx2",11).setInteger("id",new Integer(3));
			q.executeUpdate();
			
			/*zqx z=new zqx();
			z.setAge(2);
			z.setName("f");
			s.saveOrUpdate(z);
			s.flush();
			s.clear();*/
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
