package com.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberBizImpl implements MemberBiz{

	@Autowired
	private MemberMapper membermapper;
	
	@Override
	public int selectMember(MemberDto dto) {
		// TODO Auto-generated method stub
		return membermapper.select(dto);
	}
	
	@Override
	public int insertMember(MemberDto dto) {
		// TODO Auto-generated method stub
		return membermapper.insert(dto);
	}

}
