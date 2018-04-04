package xyz.ibenben.zhongdian.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import xyz.ibenben.zhongdian.system.entity.Tubiao;

public interface TubiaoDAO {
	@Select("select * from tubiao")
	public List<Tubiao> listTubiao();
}
