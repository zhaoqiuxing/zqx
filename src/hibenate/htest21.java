package hibenate;

import named.intercetr;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.zqx1;

public class htest21 {
	private static Logger log = Logger.getLogger(htest21.class);
	public static void main(String[] args) {
		Session s = basetest.sf.withOptions().interceptor(new intercetr())
				.openSession();
		System.out.println("session´ò¿ª");
		Transaction tx = s.beginTransaction();

		try {
			basetest.sf.evict(zqx1.class);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();

			log.error("£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤£¤", e);
		} finally {
			if (s.isOpen()) {
				s.close();

				basetest.sf.close();
				log.info("session¹Ø±Õ");
			}
			
		}
	}
}
