package srit.plat.xmlUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**     
 * @项目名称：reportplat   
 * @类名称：XmlAdapter   
 * @类描述：   
 * @创建人：sjq   
 * @创建时间：2016年12月2日 下午12:48:54  
 */

public class MapAdapter extends XmlAdapter<MapAdapter.AdaptedMap, Map<String, String>>{


	
	
	public static class AdaptedMap {
		
		public List<Field> field = new ArrayList<Field>();
	  
	}
	
	public static class Field{
		public String name;
		public String jsonkey;
	}

	/* (non-Javadoc)
	 * @see javax.xml.bind.annotation.adapters.XmlAdapter#unmarshal(java.lang.Object)
	 */
	@Override
	public Map<String, String> unmarshal(AdaptedMap v) throws Exception {
		 Map<String, String> map = new HashMap<String, String>();
	        for(Field field : v.field) {
	            map.put(field.name, field.jsonkey);
	        }
	        return map;
	}

	/* (non-Javadoc)
	 * @see javax.xml.bind.annotation.adapters.XmlAdapter#marshal(java.lang.Object)
	 */
	@Override
	public AdaptedMap marshal(Map<String, String> v) throws Exception {
		AdaptedMap adaptedMap = new AdaptedMap();
        for(Map.Entry<String, String> mapEntry : v.entrySet()) {
            Field field = new Field();
            field.name = mapEntry.getKey();
            field.jsonkey = mapEntry.getValue();
            adaptedMap.field.add(field);
        }
        return adaptedMap;
	}

}
