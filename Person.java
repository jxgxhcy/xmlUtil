package srit.plat.xmlUtil;

import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * @项目名称：reportplat
 * @类名称：Person
 * @类描述：
 * @创建人：sjq
 * @创建时间：2016年12月2日 上午10:14:19
 */

@XmlRootElement
public class Person {

	private String id;
	private String name;
	private String sex;
	private List<String> hobby;
	private Map<String, String> mapped;
	private Student stu;
	@XmlAttribute(name="id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@XmlElementWrapper(name = "hobbys")
	@XmlElement(name = "hobby")
	public List<String> getHobby() {
		return hobby;
	}
	
	public void setHobby(List<String> hobby) {
		this.hobby = hobby;
	}



	/**
	 * 
	 * @param id
	 * @param name
	 * @param sex
	 * @param hobby
	 * @param stu
	 * @param mapped
	 * @description
	 */
	public Person(String id, String name, String sex, List<String> hobby,
			Student stu,Map<String, String> mapped) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.hobby = hobby;
		this.stu = stu;
		this.mapped = mapped;
	}
	/**
	 * 
	 * @Title Person	
	 * @description TODO
	 */
	public Person() {
		super();
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", sex=" + sex
				+ ", hobby=" + hobby + ", stu=" + stu + ", mapped=" + mapped +"]";
	}
	public Student getStu() {
		return stu;
	}

	public void setStu(Student stu) {
		this.stu = stu;
	}
	
	@XmlJavaTypeAdapter(MapAdapter.class)
	public Map<String, String> getMapped() {
		return mapped;
	}

	public void setMapped(Map<String, String> mapped) {
		this.mapped = mapped;
	}


}
class Student {
	private String num;
	private String clazz;
	
	public String getNum() {
		return num;
	}
	
	public void setNum(String num) {
		this.num = num;
	}
	
	public String getClazz() {
		return clazz;
	}
	
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	
	public Student(String num, String clazz) {
		super();
		this.num = num;
		this.clazz = clazz;
	}
	
	public Student() {
		super();
	}
	
	@Override
	public String toString() {
		return "Student [num=" + num + ", clazz=" + clazz + "]";
	}
	
}
