package com.turing.api.member;

import com.turing.api.article.Article;
import com.turing.api.enums.Messenger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    Connection connection;

    private static MemberRepository instance;

    static {
        try {
            instance = new MemberRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private MemberRepository() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/turingdb",
                "turing",
                "password");
    }

    public static MemberRepository getInstance() {
        return instance;
    }

    public Messenger saveMembers(Member member) {
        return Messenger.SUCCESS;
    }

    public List<?> MemberList() throws SQLException {
        List<?> list = new ArrayList<>();
        String sql = "select * from members";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            do {
//            System.out.printf("ID: %d\t Title : %s\t content: %s\t Writer: %s\n",
//                    int id = rs.getInt(title);
//                    String title = rs.getString(content);
//                    String content= rs.getString(writer);
//                    String registerDate=  rs.getString(register_date);
                Member a = Member.builder()
                        .id(rs.getLong("id"))
                        .memberName(rs.getString("memberName"))
                        .password(rs.getString("password"))
                        .name(rs.getString("name"))
                        .phoneNumber(rs.getString("phoneNumber"))
                        .address(rs.getString("address"))
                        .job(rs.getString("job"))
                        .height(rs.getString("height"))
                        .weight(rs.getString("weight"))
                        .build();
            } while (rs.next());
        } else {
            System.out.println("데이터가 없습니다");
        }
        rs.close();
        pstmt.close();
        connection.close();

        return list;
    }
}
