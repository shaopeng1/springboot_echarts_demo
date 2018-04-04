package xyz.ibenben.zhongdian.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import xyz.ibenben.zhongdian.common.BaseDao;
import xyz.ibenben.zhongdian.system.entity.UPermission;



 @Mapper
public interface UPermissionDao extends BaseDao<UPermission> {

	
	
	/**
	 * 根据用户id获取用户权限
	 * @param obj
	 */
	 @Select("SELECT p.* from u_user_role urole left join  u_role_permission rp   on urole.rid=rp.rid  left join  u_permission p on p.id = rp.pid  where urole.uid = #{uid}")
	 List<UPermission> findPermissionByUid(Long uid);
}
