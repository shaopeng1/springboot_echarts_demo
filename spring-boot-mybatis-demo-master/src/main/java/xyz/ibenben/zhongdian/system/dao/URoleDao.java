package xyz.ibenben.zhongdian.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import xyz.ibenben.zhongdian.common.BaseDao;
import xyz.ibenben.zhongdian.system.entity.URole;


@Mapper
public interface URoleDao extends BaseDao<URole> {
	
	/**
	 * 根据用户ID获取该用户所在组的角色权限
	 * @param obj
	 */
	@Select("SELECT role.id,role.name from u_user_role urole left join u_role role on urole.rid = role.id where urole.uid = #{uid}")
	public List<URole> findRoleByUid(Long uid);
}
