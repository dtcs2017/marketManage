package service.Imp;

import java.util.*;

import bean.CommodityClassBean;
import dao.CommodityClassDao;
import dao.Imp.CommodityClassDaoImp;
import domain.Admin;
import domain.CommodityClass;
import service.CommodityClassService;

public class CommodityClassServiceImp implements CommodityClassService 
{
	
    private CommodityClassDao typeDaoImp;
   
	public void setTypeDaoImp(CommodityClassDao typeDaoImp) 
	{
		this.typeDaoImp = typeDaoImp;
	}

	//��ѯ���е���Ʒ����ʵ�壬����id,name,desc���Ե�bean
	public List<CommodityClassBean> findAllTypes() 
	{	
		List<CommodityClassBean> result=new ArrayList<CommodityClassBean>();
		List<CommodityClass>  list;
		list=typeDaoImp.findAll();
		for (CommodityClass type : list) {
			result.add(new CommodityClassBean(type.getTypeid(),type.getTypename(),type.getTypedesc()));
		}
		return result;
	}
	//��ҳ��ѯ������Ʒ������Ϣ
	public List<CommodityClassBean> findAllTypeByPaging(int page, int limit) 
	{
		List<CommodityClassBean> result=new ArrayList<CommodityClassBean>();
		List<CommodityClass>  list;
		list=typeDaoImp.findAllByPaging(page, limit);
		for (CommodityClass type : list) {
			result.add(new CommodityClassBean(type.getTypeid(),type.getTypename(),type.getTypedesc()));
		}
		return result;
	}
	//ͨ����Ʒ�������Ʋ�����������
	public List<CommodityClassBean> findTypeByName(String typename)
	{
		List<CommodityClassBean> result=new ArrayList<CommodityClassBean>();
		List<CommodityClass>  list;
		list=typeDaoImp.findByName(typename);
		for (CommodityClass it : list) {
			result.add(new CommodityClassBean(it.getTypeid(),it.getTypename(),it.getTypedesc()));
		}
		return result;
	}
	
	//ͨ����Ʒ�������Ʋ����������ݲ���ҳ��ʾ
	public List<CommodityClassBean> findTypeByNamePaging(String typename,
			int page, int limit) 
	{
		
		List<CommodityClassBean> result=new ArrayList<CommodityClassBean>();
		List<CommodityClass>  list;
		list=typeDaoImp.findAllByNamePaging(typename, page, limit);
		for (CommodityClass it : list) {
			result.add(new CommodityClassBean(it.getTypeid(),it.getTypename(),it.getTypedesc()));
		}
		return result;
	}
	
	//������Ʒ������Ϣ��Ҫ��������ͬ��typename����
	public void updateType(int typeid,String typename,String typedesc) throws Exception
	{
		
		CommodityClass type=typeDaoImp.findById(typeid);
		if(isExisted(typename))
		{
			type.setTypedesc(typedesc);
			typeDaoImp.update(type);
			
		}else
		{
			
			type.setTypename(typename);
			type.setTypedesc(typedesc);
			typeDaoImp.update(type);
		}
	} 
	
	//ͨ��name�����ж��Ƿ��Ѿ�����ĳ��Ʒ����
	private boolean isExisted(String typename)
	{
		List<CommodityClass> list=typeDaoImp.findByNameAccurate(typename);
		boolean result=false;
		if (list.size()>0) 
		{
			result=true;
		}else
		{
			result=false;
		}
		return result;
	}
	
	//�����Ʒ����
	public void addType(String typename,String typedesc) throws Exception
	{	
		
		if(isExisted(typename))
		{	
			throw new Exception("������Ʒ�Ѿ�����");
		}else
		{	
			CommodityClass type=new CommodityClass();
			type.setTypename(typename);
			type.setTypedesc(typedesc);
			typeDaoImp.save(type);
		}	
	}
	
	//ɾ����Ʒ��������Ϣ
	public void deleteTypes(int id,String typename) throws Exception 
	{
		if(!isExisted(typename))
		{	
			throw new Exception("�Բ��𣬲����ڸ���Ʒ������Ϣ");
		}else
		{	
			CommodityClass type=typeDaoImp.findById(id);
			typeDaoImp.delete(type);
		}	
	}	
}
