package named;



import java.io.Serializable;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import entity.zqx;

public class intercetr extends EmptyInterceptor
{
    @Override
	public boolean onSave(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {
    	 
        if (entity instanceof zqx)
        {
        	
            for (int index=0;index<propertyNames.length;index++)
            {
                
                if ("name".equals(propertyNames[index]))
                {
                    /*ʹ����������People�����"checkinTime"���Ը���ֵ*/
                    state[index] = "������";
                    System.out.println("������");
                    return true;
                }
            }
        }

        return false;
	}

	private static final long serialVersionUID = -8597658125309889388L;
    
   
} 