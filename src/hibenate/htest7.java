package hibenate;

import named.SaveOrUpdateListener;
import named.intercetr;

import org.hibernate.CacheMode;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;

import entity.zqx;

public class htest7 {

	public static void main(String[] args) {
		Session s = basetest.sf.withOptions().interceptor(new intercetr())
				.openSession();
		EventListenerRegistry registry = ((SessionFactoryImpl) basetest.sf).getServiceRegistry().getService(
		        EventListenerRegistry.class);
		        registry.getEventListenerGroup(EventType.SAVE_UPDATE).appendListener(new SaveOrUpdateListener());
//		EventListenerRegistry registry = ((SessionFactoryImpl) sessionFactory).getServiceRegistry().getService(
//	            EventListenerRegistry.class)
		System.out.println("session´ò¿ª");
		Transaction tx = s.beginTransaction();
		try {
			/*ScrollableResults cu= s.createQuery("from zqx").setCacheMode(CacheMode.IGNORE).scroll(ScrollMode.FORWARD_ONLY);
			int i=0;
			while (cu.next()){
				zqx z=(zqx)cu.get(0);
				z.setAge(1);
				if(++i%5==0){
					s.flush();
					s.clear();
				}
			}*/
			
			zqx z=new zqx();
			z.setAge(2);
			z.setName("f");
			s.saveOrUpdate(z);
			s.flush();
			s.clear();
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
