package hibenate;

import named.SaveOrUpdateListener;
import named.intercetr;
import named.nameding;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.event.spi.SaveOrUpdateEventListener;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import entity.zqx;
import entity.zqx1;

public class basetest {
	public static SessionFactory sf;

	static {

		System.out.println(sf);

		if (sf == null) {
			Configuration cfg = new Configuration().configure();
			// cfg.setInterceptor(new intercetr());

			System.out.println("‘ÿ»Î≈‰÷√Œƒº˛");

			cfg.setNamingStrategy(new nameding());
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties())
					.build();
			// SaveOrUpdateEventListener[] l={new SaveOrUpdateListener()};

			// ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
			// .applySettings(cfg.getProperties()).buildServiceRegistry();
			sf = cfg.buildSessionFactory(serviceRegistry);
		}
	}
}
