package service;

import java.sql.Date;
import java.util.List;

import domain.OrderForm;
import bean.OrderFormBean;


public interface OrderFormService 
{
	//����orderform�ķ���
	void addOrderForm(int userid,Date submittime,double totalprice,double ispayoff);
	//���ݵ绰����������ڲ��Ҷ���
	List<OrderFormBean> findByTimeOPhone(Date time,int userid) throws Exception;
	//���¶���״��
	void updateOrderForm(int orderform,double ispayoff);
}
