package dao;

import java.util.*;

import domain.CommodityClass;

public interface CommodityClassDao extends BaseDao<CommodityClass> {
	
	//��ѯ���е�ʵ��
	List<CommodityClass> findAll();
	//��ѯ���в�Ʒ����ʵ�岢�ҷ�ҳ��ʾ
	List<CommodityClass> findAllByPaging(int page,int pageSize);
	//ʵ��ͨ�����Ʋ�ѯ��Ʒ������Ϣ��ģ����ѯ
	List<CommodityClass> findByName(String name);
	//ʵ��ͨ�����Ʋ�ѯ��Ʒ������Ϣ,��ȷ��ѯ
	List<CommodityClass> findByNameAccurate(String name);
	//ͨ���������Ʋ�ѯ���в�Ʒ����ʵ�岢�ҷ�ҳ��ʾ
	List<CommodityClass> findAllByNamePaging(String name,int page,int pageSize);
	//����id��ѯʵ��
	CommodityClass findById(int id);
}
