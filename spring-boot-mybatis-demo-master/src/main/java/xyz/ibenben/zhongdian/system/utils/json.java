package xyz.ibenben.zhongdian.system.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class json {
	/**
		 * 把对象转换成JSON
		 */
		public static <T> String toJSON(T obj) {
			ObjectMapper mapper = new ObjectMapper();
				String json = null;
				try {
					json = mapper.writeValueAsString(obj);
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
				return json;
		}
}

