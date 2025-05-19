package com.smhrd.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.model.MapVO;
import com.smhrd.model.MemberVO;


@Mapper
public interface MemberMapper {

	public List<MapVO> map();
	
	
	
	
	
	
	public void join(MemberVO vo);
	public MemberVO login(MemberVO vo);
	public void update(MemberVO vo);
	
	public void delete(MemberVO vo);
	
	public List<MemberVO> select(MemberVO vo);
	
	public int emailCheck(String email);
	
	public List<MemberVO> searchMember(String search);
	
}
