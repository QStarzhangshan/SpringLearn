package spring.tx.xml;

public interface BookShopDao {
	//������Ż�ȡ��ĵ���
	public int findBookPriceByIsbn(String isbn);
	
	//������Ŀ��,ʹ��Ŀ���һ
	public void updateBookStock(String isbn);
	
	//�����û����˻����,ʹusername��balance-price
	public void updateUserAccount(String username, int price);
	
	
}
