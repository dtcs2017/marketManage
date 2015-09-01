package dao;

import domain.Admin;

import java.util.*;
public interface AdminDao extends BaseDao<Admin> 
{
	//����Ա��������ѯԱ��ʵ��ķ���List<Admin> findByName(Admin.class entityClass,String name);
	List<Admin> findByName(String name);
	//����Ա���������������ѯԱ��ʵ��ķ���
	List<Admin> findByNameAndPW(String name,String password);
	//��������Ա������Ϣ��¼
	List<Admin> findAllAdmin();
	//����adminid����Ա����¼
	Admin findById(int id);
	//ע�����û�
	void addAdmin(Admin admin) throws Exception;
}
