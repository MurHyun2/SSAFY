package com.ssafy.exam.member.model.dao;

import com.ssafy.exam.member.model.dto.Member;
import java.sql.SQLException;

public interface MemberDAO {
    void saveMember(Member member) throws SQLException;
    Member findMemberById(String id) throws SQLException;
    Member findMemberByIdAndPassword(String id, String password) throws SQLException;
    void deleteMember(String id) throws SQLException;
    void updateMember(Member member) throws SQLException;
}

