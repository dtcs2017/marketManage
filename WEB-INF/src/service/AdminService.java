package service;

import java.sql.Date;
import java.util.List;

import bean.AdminBean;
import domain.Admin;

public interface AdminService
{
	//�����µ�Ա����Ϣ
	void addAdmin(String username,String sex,Date hireday,String password) throws Exception;
	//�ж��Ƿ�ɵ�¼
	boolean isAdmin(String username,String password) throws Exception;
	//����Ա����Ϣ
	void updateAdmin(int adminid,String username,String sex,Date hireday,String password);
	//�������е�Ա����Ϣ
	List<AdminBean> findallAdmin() throws Exception;
	//�������Ʋ�ѯԱ����Ϣ
	List<AdminBean> findByName(String username) throws Exception;
	//ɾ��Ա����Ϣ
	void deleteAdmin(int id);
}
