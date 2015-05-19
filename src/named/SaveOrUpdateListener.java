package named;

import org.hibernate.event.internal.DefaultSaveOrUpdateEventListener;
import org.hibernate.event.spi.SaveOrUpdateEvent;

import entity.zqx;

public class SaveOrUpdateListener extends DefaultSaveOrUpdateEventListener {

	@Override
	public void onSaveOrUpdate(SaveOrUpdateEvent event) {
		zqx z = null;
		System.out.println("事件!");
        if(event.getObject() instanceof zqx)
        {
            z = (zqx)event.getObject();
        }
        
        z.setName("保存事件");
        z.setAge(1);
        System.out.println("事件!");
        
        /*一定要调用父类提供的功能，不然就和继承接口一样了*/
		//super.onSaveOrUpdate(event);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -4056668773901464239L;

}
