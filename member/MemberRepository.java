package com.turing.api.member;

import com.turing.api.enums.Messenger;

public class MemberRepository{
    private static MemberRepository instance = new MemberRepository();

    public MemberRepository() {
    }

    public static MemberRepository getInstance() {
        return instance;
    }

    public Messenger saveMembers(Member member){
        return Messenger.SUCCESS;
    }
}