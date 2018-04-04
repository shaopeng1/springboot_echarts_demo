package xyz.ibenben.zhongdian.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;
import xyz.ibenben.zhongdian.system.dao.TubiaoDAO;
import xyz.ibenben.zhongdian.system.entity.Tubiao;
import xyz.ibenben.zhongdian.system.entity.User;

@Controller
public class UserController {
	@Autowired
	private TubiaoDAO tubiaoDAO;

	@RequestMapping("/indexpage")
	public String indexpage() {
		return "rediester";
	}

	@RequestMapping("/tubiao")
	@ResponseBody
	public String tubiao() {
		List<Tubiao> tubiao = tubiaoDAO.listTubiao();
		String[] categories = new String[tubiao.size()];
		Integer[] values = new Integer[tubiao.size()];
		Integer[] values2 = new Integer[tubiao.size()];
		for (int i = 0; i < tubiao.size(); i++) {
			categories[i] = tubiao.get(i).getUsername();
			values[i] = tubiao.get(i).getState();
			values2[i] = tubiao.get(i).getState2();
		}
		Map<String, Object> json = new HashMap<String, Object>();
		json.put("categories", categories);
		json.put("values", values);
		json.put("values2", values2);
		JSONObject jsonObject = JSONObject.fromObject(json);
		return jsonObject.toString();
	}
	
	/**
	 * 获取所有权限
	 * @return
	 */
	@RequestMapping("/quanxian")
	@ResponseBody
	public String quanxian(){
		User u = (User) SecurityUtils.getSubject().getPrincipal();
		JSONObject jsonObject = JSONObject.fromObject(u);
		return jsonObject.toString();
	}
}
