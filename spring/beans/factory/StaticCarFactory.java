package spring.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * ��̬����������ֱ����һ����ľ�̬�����Ϳ��Է���beanʵ��
 * @author zj342
 *
 */

public class StaticCarFactory {

	private static Map<String, Car> cars= new HashMap<String, Car>();
	
	static {
		cars.put("audi", new Car("audi", 300000));
		cars.put("Ford", new Car("ford", 400000));
	}
	
	private static Car getCar(String name) {
		return cars.get(name);
	}
}
