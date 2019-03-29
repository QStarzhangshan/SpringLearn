package spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {

	@Autowired
	private BookShopDao bookShopDao;
	
	//�������ע��
	//1.ָ������Ĵ�����Ϊ,����ǰ�����񷽷�������һ�����񷽷�����ʱ���ʹ������,
	//Ĭ��ȡֵΪ REQUIRED, �����÷���������
	//������ΪREQUIRED_NEW
	//����,REQUIRED_NEW����������е�һ����
	//2.ʹ��isolationָ������ĸ��뼶��, ��õ�ȡֵΪREAD_COMMITTED(�����ύ)
	//3.Ĭ��Spring������ʽ�������������ʱ������лع�,Ҳ����ͨ����Ӧ���Խ�������
	//ͨ�������Ĭ��ֵ����(noRollbackFor= {UserAccountException.class})
	//4.readonly ָ�������Ƿ�Ϊֻ��,��ʾ�������֮��ȡ���ݵ��ǲ���������,�������԰������ݿ������Ż�����,
	//�������һ��ֻ��ȡ���ݿ�ֵ�ķ���,Ӧ����Ϊreadonly=true
	//5.ʹ��timeoutָ��ǿ��ǿ�ƻع�����֮ǰ�������ռ�õ�ʱ��,ռ��ʱ�������ǿ�ƻع�
	@Transactional(propagation=Propagation.REQUIRED, 
			isolation=Isolation.READ_COMMITTED,
			readOnly=false,
			timeout=3)
	@Override
	public void purchase(String username, String isbn) {
		//1.��ȡ��ĵ���
		int price = bookShopDao.findBookPriceByIsbn(isbn);
		//2.������Ŀ��
		bookShopDao.updateBookStock(isbn);
		//3.�����û����
		bookShopDao.updateUserAccount(username, price);
	}

}
