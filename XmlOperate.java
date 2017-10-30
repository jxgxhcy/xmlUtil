/**
 * XML操作工具类
 * <P><STRONG>Time：</STRONG>2012-3-25 下午8:16:49</P>
 * @author 胡昌海
 */
public class XmlOperate {
	/**
	 * 创建DOC对象
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
	 * 为DOC添加根节点
	 * @param document 文档对象
	 * @param rootName	结点名称
	 * @return
	 */
	public Element addRootElement(Document document,String rootName){
		Element root=document.createElement(rootName);
		document.appendChild(root);
		return root;
	}
	
	/**
	 * 为DOC添加节点
	 * @param parent 父节点
	 * @param tagName	结点名称
	 * @return
	 */
	public Element addElement(Element parent,String tagName){
		Document document=parent.getOwnerDocument();
		Element child=document.createElement(tagName);
		parent.appendChild(child);
		return child;
	}
	
	/**
	 * 为DOC添加节点
	 * @param parent 父节点
	 * @param tagName 结点名称
	 * @param text 结点文本
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
	 * 将DOC转化为字符串
	 * @param document 文档对象
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
	 * 将字符串转化为DOC对象
	 * @param xmlString 文档字符串
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
