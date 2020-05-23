package com.myapp;

import org.springframework.stereotype.Service;

@Service
public interface MemberBiz {
	
	public int selectMember(MemberDto dto);
	public int insertMember(MemberDto dto);
}
