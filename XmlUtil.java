package srit.plat.xmlUtil;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * @项目名称：reportplat
 * @类名称：XmlUtil
 * @类描述：
 * @创建人：sjq
 * @创建时间：2016年12月2日 上午10:13:56
 */

public class XmlUtil {

	public static void toXml() {
		List<String> hobbies = new ArrayList<String>();
		hobbies.add("basket");
		hobbies.add("draw");
		Map<String, String> map = new HashMap<String, String>();
		map.put("中国", "China");
		map.put("日本", "Japan");
		Person ps = new Person("A11", "sjq", "male", hobbies, new Student(
				"A11_1", "class_1"), map);
		try {
			JAXBContext context = JAXBContext.newInstance(Person.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.marshal(ps, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public static void toBean() {
		String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><person id=\"A11\"><hobbys><hobby>basket</hobby><hobby>draw</hobby></hobbys><mapped><field><name>日本</name><jsonkey>Japan</jsonkey></field><field><name>中国</name><jsonkey>China</jsonkey></field></mapped><name>sjq</name><sex>male</sex><stu><clazz>class_1</clazz><num>A11_1</num></stu></person>";
		try {
			JAXBContext context = JAXBContext.newInstance(Person.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			Person ps = (Person) unmarshaller
					.unmarshal(new StringReader(xmlStr));
			System.out.println(ps);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
//		toXml();
		toBean();
	}
}
