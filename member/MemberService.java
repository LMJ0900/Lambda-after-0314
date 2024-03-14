package com.turing.api.member;

import com.turing.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface MemberService {
    String login(Member member);
    String test();
    String updatePassword(Member member);


    Map<String, ?> getMemberMap();

    List<?> findMembersByName(String Name);
    Map<String, ?> findMembersByFromName(String Name);
    List<?> findMembersByJob(String job);
    Map<String, ?> findMembersByFromJob(String job);


    String addMembers();

    Map<String,?> findMembersByJobFromMap(String job);

    List<?> findMembers() throws SQLException;

    Messenger createTable() throws SQLException;

    String deleteTable() throws SQLException;
}
