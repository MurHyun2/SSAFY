package com.ssafy.exam.member.model.service;

import com.ssafy.exam.member.model.dao.MemberDAO;
import com.ssafy.exam.member.model.dao.MemberDAOImpl;
import com.ssafy.exam.member.model.dto.Member;

import java.sql.SQLException;

public class MemberServiceImpl implements MemberService {

    private MemberDAO repository = new MemberDAOImpl();

    @Override
    public void register(Member member) throws SQLException {
        if (repository.findMemberById(member.getId()) != null) {
            throw new SQLException("이미 존재하는 회원입니다.");
        }
        repository.saveMember(member);
    }

    @Override
    public Member login(String id, String password) throws SQLException {
        return repository.findMemberByIdAndPassword(id, password);
    }
    
    @Override
    public void deleteMember(String id) throws SQLException {
            repository.deleteMember(id);
        }

	@Override
	public void modifyMember(Member member) throws SQLException {
		repository.updateMember(member);
	}
}
