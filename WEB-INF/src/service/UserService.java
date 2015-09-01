package service;

import java.sql.Date;
import java.util.List;

import bean.UserBean;

public interface UserService 
{
	//��ҳ��ѯ�����û���Ϣ
	List<UserBean> findAllUser() throws Exception;
	//�����ƻ��ߵ绰��������û���Ϣ
	List<UserBean> findByNamePhone(String name,String phone,int page,int limit) throws Exception;
	//�����û���Ϣ�ķ���
	void addUser(String username,String password,String name
			,String sex,String address,String postaddress
			,String phone,String email,Date tagtime) throws Exception;
	//���ݴ���Ĳ����޸��û���Ϣ
	void updateUser(int userid,String username,String password,String name
			,String sex,String address,String postaddress
			,String phone,String email,Date tagtime) throws Exception;
	//����idɾ����Ʒ��Ϣ
	void deleteCommodity(int id);
}
