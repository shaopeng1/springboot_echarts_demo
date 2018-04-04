package xyz.ibenben.zhongdian.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;
import xyz.ibenben.zhongdian.system.entity.User;
import xyz.ibenben.zhongdian.system.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/indexpage")
	public String indexpage() {
		return "rediester";
	}
	
	@RequestMapping("/upUser")
	public void upUser(int state){
		System.out.println("============"+state);
	}

	@RequestMapping("/regiester")
	@ResponseBody
	public String regiester() {
		List<User> user = userService.listUser();
		String[] categories = new String[user.size()];
		Integer[] values = new Integer[user.size()];
		Integer[] values2 = new Integer[user.size()];
		Map<String, Object> json = new HashMap<String, Object>();
		json.put("categories", categories);
		json.put("values", values);
		json.put("values2", values2);
		JSONObject jsonObject = JSONObject.fromObject(json);
		return jsonObject.toString();
	}
}
