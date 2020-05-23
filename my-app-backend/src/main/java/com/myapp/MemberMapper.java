package com.myapp;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberMapper {

	@Select(" SELECT COUNT(*) FROM REACTMEMBER WHERE ID=#{id} AND PW=#{pw}")
	public int select(MemberDto dto);
	
	@Insert(" INSERT INTO REACTMEMBER VALUES(#{id},#{pw}) ")
	public int insert(MemberDto dto);
}
