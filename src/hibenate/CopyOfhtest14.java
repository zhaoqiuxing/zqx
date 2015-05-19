package hibenate;

import java.util.Iterator;
import java.util.List;

import named.intercetr;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.zqx;
import entity.zqx1;

public class CopyOfhtest14 {

	public static void main(String[] args) {
		Session s = basetest.sf.withOptions().interceptor(new intercetr())
				.openSession();
//		EventListenerRegistry registry = ((SessionFactoryImpl) sessionFactory).getServiceRegistry().getService(
//	            EventListenerRegistry.class)
		System.out.println("session´ò¿ª");
		Transaction tx = s.beginTransaction();
		try {
			//zqx w=(zqx) s.load(zqx.class, new Long(1));
			Query q= s.createQuery("from zqx as c");
			List<zqx> l=q.list();
			Iterator<zqx> iz=l.iterator();
			zqx z1=iz.next();
			zqx z2=iz.next();
			zqx1 zz=(zqx1) z1.getSet().iterator().next();
			zqx1 zzz=(zqx1)z2.getSet().iterator().next();
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
