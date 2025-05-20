package com.smhrd.member;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MemberMapper {

	public void join(MemberVO vo);

	public MemberVO login(MemberVO vo);
}