/**
 * XML����������
 * <P><STRONG>Time��</STRONG>2012-3-25 ����8:16:49</P>
 * @author ������
 */
public class XmlOperate {
	/**
	 * ����DOC����
	 * @return
	 * @throws Exception
	 */
	public Document createDocument() throws Exception{
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=factory.newDocumentBuilder();
		Document document=builder.newDocument();
		return document;
	}
	/**
	 * ΪDOC��Ӹ��ڵ�
	 * @param document �ĵ�����
	 * @param rootName	�������
	 * @return
	 */
	public Element addRootElement(Document document,String rootName){
		Element root=document.createElement(rootName);
		document.appendChild(root);
		return root;
	}
	
	/**
	 * ΪDOC��ӽڵ�
	 * @param parent ���ڵ�
	 * @param tagName	�������
	 * @return
	 */
	public Element addElement(Element parent,String tagName){
		Document document=parent.getOwnerDocument();
		Element child=document.createElement(tagName);
		parent.appendChild(child);
		return child;
	}
	
	/**
	 * ΪDOC��ӽڵ�
	 * @param parent ���ڵ�
	 * @param tagName �������
	 * @param text ����ı�
	 * @return
	 */
	public Element addElement(Element parent,String tagName,String text){
		Document document=parent.getOwnerDocument();
		Element child=document.createElement(tagName);
		child.setTextContent(text);
		parent.appendChild(child);
		return child;
	}
	
	/**
	 * ��DOCת��Ϊ�ַ���
	 * @param document �ĵ�����
	 * @return
	 * @throws Exception
	 */
	public String tranferToString(Document document) throws Exception{
		if(document==null)return null;
		StringWriter out=null;
		try{
			TransformerFactory factory=TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer(); 
			DOMSource source = new DOMSource(document);
		    out=new StringWriter();
		    StreamResult result = new StreamResult(out);
		    transformer.transform(source, result);
		    return out.toString();
		}finally{
		    out.close();
		}
	}
	
	/**
	 * ���ַ���ת��ΪDOC����
	 * @param xmlString �ĵ��ַ���
	 * @return
	 * @throws Exception
	 */
	public Document tranferToDocument(String xmlString) throws Exception{
		if(xmlString==null)return null;
		StringReader in=null;
		try{
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
			DocumentBuilder builder=factory.newDocumentBuilder();
			in=new StringReader(xmlString);
			return builder.parse(new InputSource(in));
		}finally{
			in.close();
		}
	}
}
