package com.eatsTime.member.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.eatsTime.member.domain.MemberVO;
import com.eatsTime.mybatis.config.MyBatisConfig;

public class MemberDAO {
   public SqlSession sqlSession;

   public MemberDAO() {
      sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
   }
   
   //             ҷ     
   public List<MemberVO> selectAll(MemberVO memberVO) {
      return sqlSession.selectList("member.selectAll", memberVO);
   }
   
   // ȸ          
   public void update(MemberVO memberVO) {
      sqlSession.update("member.update", memberVO);
   }
   
   // ȸ  Ż  
   public void delete(String memberId) {
      sqlSession.delete("member.delete", memberId);
   }
   
   // 특정 회원정보 조회
   public MemberVO selectMember(Long memberId) {
      return sqlSession.selectOne("member.selectMember", memberId);
   }
   
	//	회원가입
	public void insert(MemberVO memberVO) {
		sqlSession.insert("member.insert", memberVO);
	}
	
//	아이디 중복검사
	public String selectIdentification(String memberIdentification) {
		return sqlSession.selectOne("member.selectIdentification", memberIdentification);
	}
	
//	이메일 중복검사
	public String selectEmail(String memberEmail) {
		return sqlSession.selectOne("member.selectEmail", memberEmail);
	}
	
//	로그인
	public MemberVO login(MemberVO memberVO) {
		return sqlSession.selectOne("member.login", memberVO);
	}

}