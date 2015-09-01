package dao.Imp;


import java.util.List;

import dao.BaseDaoHibernate4;
import dao.UserDao;
import domain.Commodity;
import domain.User;

public class UserDaoImp extends BaseDaoHibernate4<User> implements UserDao 
{
		//��ѯ���е��û���Ϣ
	public List<User> findAllUser()
	{
		return findAll(User.class);
	}
	
	//��ѯ���е��û�����ҳ
	public 	List<User> findAllUserByPaging(int page,int limit)
	{
		String hql="select en from "
				+ User.class.getSimpleName() + " as en ";
		return findByPage(hql, page, limit);
	}
	
	//����name��ѯ�û���Ϣ
	public List<User> findByName(String name)
	{
		String hql="select en from "
				+ User.class.getSimpleName() + " as en"
				+ " where en.name like "+"'%"+name+"%'"; 
				return find(hql);
	}
	
	//����phone��ѯ�û���Ϣ
	public 	List<User> findByPhone(String phone)
	{
		String hql="select en from "
				+ User.class.getSimpleName() + " as en"
				+ " where en.phone like "+"'%"+phone+"%'"; 
		return find(hql);
	}

	//����name��phone��ѯ�û���Ϣ
	public 	List<User> findByNamePhone(String name,String phone)
	{
		String hql="select en from "
				+ User.class.getSimpleName() + " as en"
				+ " where en.phone like "+"'%"+phone+"%'"
				+ " and en.name like "+"'%"+name+"%'"; 
		return find(hql);
	}
	
	//�ж�ʵ���Ƿ��Ѿ�����,���ظ�ʵ���id,��������ڷ���0
	public int isExist(User user)
	{
		int result=0;
		List<User> list=findAllUser();
		for (User u : list) 
		{
			if(u.equals(user))
			{
				result=u.getUserid();
				break;
			}
		}
		return result;
	}
	//�����û���Ϣ
	public void addUser(User user) throws Exception
	{
		int id=isExist(user);
		if(id==0 )
		{
			save(user);
		}else
		{
			throw new Exception("���û��Ѿ�ע�ᣡ��");
		};
	}
	
	//���ݲ�Ʒid��ѯ��Ʒʵ��
	public User findById(int id)
	{
		return get(User.class, id);
	}
	
}
