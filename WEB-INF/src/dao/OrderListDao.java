package dao;

import java.util.List;

import domain.OrderList;

public interface OrderListDao extends BaseDao<OrderList> 
{
	//���尴��orderformid��ѯ������
	List<OrderList> findListByformid(int orderformid);
	//�������Ӷ����б�ķ���
	void addList(OrderList list);
	//�����޸ĵķ���
	void updateList(OrderList list);
	//����ɾ�������
	void deleteList(OrderList list);
}
