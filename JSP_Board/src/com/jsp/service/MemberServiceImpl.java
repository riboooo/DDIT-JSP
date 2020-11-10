package com.jsp.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.jsp.dao.MemberDAO;
import com.jsp.dto.MemberVO;
import com.jsp.exception.InvalidPasswordException;
import com.jsp.exception.NotFoundIDException;
import com.jsp.request.SearchCriteria;

public class MemberServiceImpl implements MemberService {

	private MemberDAO memberDAO; // = MemberDAOImpl.getInsetance();
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Override
	public void login(String id, String pwd , HttpSession session) throws SQLException, NotFoundIDException, InvalidPasswordException {
		MemberVO member = memberDAO.selectMemberById(id);
		
		if(member == null) throw new NotFoundIDException();
		if(!pwd.equals(member.getPwd())) throw new InvalidPasswordException();
		
		session.setAttribute("loginUser", member);
		session.setMaxInactiveInterval(6*60);
	}

	@Override
	public List<MemberVO> getMemberList(SearchCriteria cri) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getSearchMemberList(SearchCriteria cri) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO getMember(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void regist(MemberVO member) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void modify(MemberVO member) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(String id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void disabled(String id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void enabled(String id) throws SQLException {
		// TODO Auto-generated method stub

	}

}