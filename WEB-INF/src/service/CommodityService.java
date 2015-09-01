package service;

import java.sql.Date;
import java.util.List;



import bean.CommodityBean;

public interface CommodityService 
{
	
	//��ҳ��������name,typeid,manu��ѯ��Ʒ��Ϣ
	List<CommodityBean> findByNameTypeManu(String typename,int typeid,String manu,int page,int limit) throws Exception;
	//������Ʒ��Ϣ�ķ���������Ʒ��Ϣ��ͬ�ǣ���������
	void addCommodity(String commodityname,String commoditydesc,String manufacture
			,int commodityamount,int typeid,double commodityprice, double fcprice
			,Date tagtime);
	//���ݴ���Ĳ����޸Ĳ�Ʒ��Ϣ
	void updateCommodity(int commodityid,int typeid,String commodityname,String manufacture
			,String commoditydesc,int commodityamount,double commodityprice,double fcprice
			,Date tagtime);
	//����idɾ����Ʒ��Ϣ
	void deleteCommodity(int id);
}
