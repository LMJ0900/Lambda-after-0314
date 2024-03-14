package com.turing.api.member;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})

public class Member {
    private Long id;
    private String memberName;
    private String password;
    private String name;
    private String phoneNumber;
    private String address;
    private String job;
    private String height;
    private String weight;

@Builder(builderMethodName = "builder")
    public Member(Long id,String memberName, String password, String name, String phoneNumber, String address, String job, String height, String weight) {
        this.id = id;
        this.memberName = memberName;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.job = job;
        this.height = height;
        this.weight = weight;
    }

    public void setPw(String pw) {
        this.password = pw;
    }
}