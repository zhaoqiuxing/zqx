package named;

import org.hibernate.event.internal.DefaultSaveOrUpdateEventListener;
import org.hibernate.event.spi.SaveOrUpdateEvent;

import entity.zqx;

public class SaveOrUpdateListener extends DefaultSaveOrUpdateEventListener {

	@Override
	public void onSaveOrUpdate(SaveOrUpdateEvent event) {
		zqx z = null;
		System.out.println("�¼�!");
        if(event.getObject() instanceof zqx)
        {
            z = (zqx)event.getObject();
        }
        
        z.setName("�����¼�");
        z.setAge(1);
        System.out.println("�¼�!");
        
        /*һ��Ҫ���ø����ṩ�Ĺ��ܣ���Ȼ�ͺͼ̳нӿ�һ����*/
		//super.onSaveOrUpdate(event);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -4056668773901464239L;

}
