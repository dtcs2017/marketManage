package dao;

import java.util.*;

import domain.Commodity;

public interface CommodityDao extends BaseDao<Commodity> 
{	
	//��ѯ������Ʒ��Ϣ
	List<Commodity> findAllComm();
	//��ҳ��ѯ������Ʒ
	List<Commodity> findAllCommByPaging(int page,int limit);
	//��ҳ�������ƣ�
	List<Commodity> findByName(String name,int page,int limit);
	//��ҳ�������ƣ�����
	List<Commodity> findByNameType(String name, int typeid,int page,int limit);
	//��ҳ�������ƣ����࣬�������Ҳ�ѯ������Ʒ
	List<Commodity> findByNameTypeManu(String name, int typeid,String manu,int page,int limit);
	//��ҳ�����ѯ
	List<Commodity> findByType(int typeid,int page,int limit);
	//��ҳ�������࣬�������Ҳ�ѯ������Ʒ
	List<Commodity> findByTypeManu(int typeid,String manu,int page,int limit);
	//��ҳ��������ѯ
	List<Commodity> findByManu(String manu,int page,int limit);
	//��ҳ �����ƺ��������Ҳ�ѯ
	List<Commodity> findByNameManu(String name, String manu,int page,int limit);
	//������Ʒ�����������ڸ���������µ���Ʒ�����߸���ԭ�еĿ��������
	void addComm(Commodity commodity) throws Exception;
	//�ж�ʵ���Ƿ��Ѿ�����,���ظ�ʵ���id,��������ڷ���0
	int isExist(Commodity commodity);
	//���ݲ�Ʒid��ѯ��Ʒʵ��
	Commodity findById(int id);
}
