package dao;

import java.util.List;

import domain.Commodity;
import domain.User;

public interface UserDao extends BaseDao<User>
{
	//��ѯ���е��û���Ϣ
	List<User> findAllUser();
	//��ѯ���е��û�����ҳ
	List<User> findAllUserByPaging(int page,int limit);
	//����name��ѯ�û���Ϣ����ҳ
	List<User> findByName(String name);
	//����phone��ѯ�û���Ϣ
	List<User> findByPhone(String phone);
	//����name��phone��ѯ�û���Ϣ
	List<User> findByNamePhone(String name,String phone);
	
	void addUser(User user) throws Exception;
	//�ж�ʵ���Ƿ��Ѿ�����,���ظ�ʵ���id,��������ڷ���0
	int isExist(User user);
	//���ݲ�Ʒid��ѯ��Ʒʵ��
	User findById(int id);
}
