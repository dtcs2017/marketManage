package service;

import java.util.List;

import bean.OrderListBean;

public interface OrderListService 
{
	//����orderlistid�������еĶ�������
	List<OrderListBean> findByFormid(int orderformid) throws Exception;
	//���Ӷ�������
	void addOrderList(int orderformid, int commodityid, int amount);
	//���¶�������
	void updateList(int orderlistid,int orderformid, int commodityid, int amount);
	//ɾ����������ķ���
	void deleteList(int orderlistid);
}
