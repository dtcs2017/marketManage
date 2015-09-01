package dao;

import java.sql.Date;
import java.util.List;

import domain.OrderForm;
import domain.User;

public interface OrderFormDao extends BaseDao<OrderForm>
{
	//���Ӷ����ķ���
	void addOrderForm(OrderForm of);
	
	//��ѯ���еĶ�����Ϣ
	List<OrderForm> findAllOrderForm();
	//����tagtime��ѯ�û���Ϣ
	List<OrderForm> findBySubmittime(Date time);
	//����phone��ѯ�û���Ϣ
	List<OrderForm> findByPhone(String phone);
	//����name��phone��ѯ�û���Ϣ
	List<OrderForm> findByTimePhone(Date time,String phone);
	OrderForm findByid(int orderformid);
}
