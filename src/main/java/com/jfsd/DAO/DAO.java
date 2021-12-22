package com.jfsd.DAO;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.jfsd.BEAN.subscriber;

public class DAO 
{

	HibernateTemplate temp;
	public void setTemp(HibernateTemplate temp) {
		this.temp=temp;
	}
	
	public int insertSubscriber(subscriber sub)
	{
		return (int) temp.save(sub);
	}

}
