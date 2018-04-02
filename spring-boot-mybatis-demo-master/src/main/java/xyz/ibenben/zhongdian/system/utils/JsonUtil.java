package xyz.ibenben.zhongdian.system.utils;

import java.lang.reflect.Field;
import java.util.List;

public class JsonUtil {
	
	public static String toJSON(Object obj) throws Exception{
		if(null == obj) return "{}";
		if (isArray(obj)) {
			return toArrayJSON(obj);
		} else if (isList(obj)) {
			return toListJSON(obj);
		} else {
			return toObjectJSON(obj);
		}
	}
	
	/*
	 *	把List转换成json 
	 * @param obj
	 */
	public static String toListJSON(Object obj) throws Exception{
		String sb = "[";
		List list = (List) obj;
		for (int i = 0; i < list.size(); i++) {
			if (1 == sb.length()) {
				sb += toObjectJSON(list.get(i));
			} else {
				sb += "," + toObjectJSON(list.get(i));
			}
		}
		return sb + "]"; 
	}
	
	/*
	 *	把数组转换成json 
	 * @param obj
	 */
	public static String toArrayJSON(Object obj) throws Exception{
		String sb = "[";
		Object[] objArr = (Object[]) obj;
		for (int i = 0; i < objArr.length; i++) {
			if (1 == sb.length()) {
				sb += toObjectJSON(objArr[i]);
			} else {
				sb += "," + toObjectJSON(objArr[i]);
			}
		}
		return sb + "]";
	}

	/*
	 * 把普通的对象转换成json
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public static String toObjectJSON(Object obj) throws Exception{
		if(null == obj) return "";
		String json = "{";
		Field[] fields = obj.getClass().getDeclaredFields();
		for(Field field : fields){
			boolean accFlag = field.isAccessible();
			field.setAccessible(true);
			if(isArray(field.get(obj))){
				if(json.length() == 1)
					json += "\"" + field.getName() + "\":" + toArrayJSON(field.get(obj));
				else
					json += ",\"" + field.getName() + "\":" + toArrayJSON(field.get(obj));
			}else if(isList(field.get(obj))){
				if(json.length() == 1)
					json += "\"" + field.getName() + "\":" + toListJSON(field.get(obj));
				else
					json += ",\"" + field.getName() + "\":" + toListJSON(field.get(obj));
			}else{
				if(json.length() == 1){
					if(field.get(obj).equals(false)  || field.get(obj).equals(true) )
						json = json  +"\""+ field.getName() + "\":" + field.get(obj) ;
					else
						json = json  +"\""+ field.getName() + "\":\"" + field.get(obj)+"\"" ;	
				}else{
					if(field.get(obj).equals(false)  || field.get(obj).equals(true) )
						json = json + ",\"" + field.getName() + "\":" + field.get(obj) ;
					else
						json = json + ",\"" + field.getName() + "\":\"" + field.get(obj)+"\"" ;
				}
			}
			field.setAccessible(accFlag);
		}
		return json + "}";
	}
	
	/*
	 *	判断是否是数组类型 
	 * @param obj
	 * @return
	 */
	public static boolean isArray(Object obj){
		return obj.getClass().isArray();
	}
	
	/*
	 *	判断是否是List 
	 * @param obj
	 * @return
	 */
	public static boolean isList(Object obj){
		String objName = obj.getClass().getSimpleName();
		return "List".equals(objName) || "ArrayList".equals(objName);
	}
}