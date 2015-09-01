package service;

import java.util.List;

import bean.CommodityClassBean;
import domain.CommodityClass;

public interface CommodityClassService 
{
	//�����Ʒ������Ϣ
	void addType(String typename,String typedesc) throws Exception;
	//��ѯ������Ʒ������Ϣ
	List<CommodityClassBean> findAllTypes();
	//��ѯ������Ʒ������Ϣ���ҷ�ҳ��ʾ
	List<CommodityClassBean> findAllTypeByPaging(int page,int limit);
	//������Ʒ��������ģ����ѯ��Ʒ������Ϣ
	List<CommodityClassBean> findTypeByName(String typename);
	//������Ʒ��������ģ����ѯ��Ʒ������Ϣ����ҳ��ʾ
	List<CommodityClassBean> findTypeByNamePaging(String typename,int page,int limit);
	//������Ʒ������Ϣ
	void updateType(int typeid,String typename,String typedesc) throws Exception;
	//ɾ����Ʒ������Ϣ
	void deleteTypes(int id,String typename) throws Exception;
}
