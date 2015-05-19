package hibenate;


import named.intercetr;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.type.Type;

import entity.zqx;

public class htest10 {

	public static void main(String[] args) {
		Session s = basetest.sf.withOptions().interceptor(new intercetr())
				.openSession();
//		EventListenerRegistry registry = ((SessionFactoryImpl) sessionFactory).getServiceRegistry().getService(
//	            EventListenerRegistry.class)
		System.out.println("session´ò¿ª");
		Transaction tx = s.beginTransaction();
		try {
			zqx z=(zqx)s.get(zqx.class, new Long(2));
			ClassMetadata c=	basetest.sf.getClassMetadata(zqx.class);
			String[] sa=c.getPropertyNames();
			Type[] ta=c.getPropertyTypes();
			System.out.println("---------------");
			for(String s1 : sa)
				System.out.println(s1);
			System.out.println("---------------");
			for(Type t :ta)
				System.out.println(t.getName());
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
