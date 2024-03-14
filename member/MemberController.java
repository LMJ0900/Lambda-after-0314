package com.turing.api.member;

import com.turing.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Optional;


public class MemberController {

    Map<String, Member> members;
    MemberServiceImpl memberService;
    MemberRepository repository;
    private static MemberController instance = new MemberController();

    public static MemberController getInstance() {
        return instance;
    }


    MemberController() {
        this.memberService = MemberServiceImpl.getInstance();
        this.repository = MemberRepository.getInstance();

    }
    public String login(Scanner scanner) {
        return memberService.login(Member.builder()
                .memberName(scanner.next())
                .password(scanner.next())
                .build());

    }
    public String addMembers() {
        return memberService.addMembers();
    }
    public Messenger save(Scanner sc) throws SQLException {
        memberService.save(Member.builder()
                .memberName(sc.next())
                .password(sc.next())
                .name(sc.next())
                .phoneNumber(sc.next())
                .job(sc.next())
                .height(sc.next())
                .weight(sc.next())
                .build());
        return Messenger.SUCCESS;
    }
    public List<Member> findAll(){
        return memberService.findAll();
    }
    public Optional<Member> findAById(Scanner sc){
        return memberService.findAById(sc.nextLong());
    }
    public String count(){
        return memberService.count();
    }
    public Optional<Member> getOne(Scanner sc){
        return memberService.getOne(sc.next());
    }
    public String deleteAll(){
        return memberService.deleteAll();
    }
    public Boolean existById(Scanner sc){
        return memberService.existById(sc.nextLong());
    }
    public String updatePassword(Scanner sc) {
        return memberService.updatePassword(Member.builder()
                .memberName(sc.next())
                .address(sc.next())
                .phoneNumber(sc.next())
                .password(sc.next())
                .build()
        );
    }

        public String delete(Scanner sc){
            return memberService.delete(Member.builder()
                    .memberName(sc.next())
                    .build()
            );
        }
    public List<?> findMembersByName(Scanner sc){
        return memberService.findMembersByName(sc.next());
    }
    public Map<String, ?> findMembersByFromName(Scanner sc){
        return memberService.findMembersByFromName(sc.next());
    }
    public List<?> findMembersByJob(Scanner sc){
        return memberService.findMembersByJob(sc.next());
    }
    public Map<String, ?> findMembersByFromJob(Scanner sc){
        return memberService.findMembersByFromJob(sc.next());
    }
    public Map<String, ?> findMembersByJobFromMap(Scanner sc){
        return null;
    }


    public String test(Scanner sc) {
        return memberService.test();
    }

    public List<?> findMembers() throws SQLException {
        return memberService.findMembers();
    }

    public Messenger createTable() throws SQLException {
        return memberService.createTable();
    }

    public String deleteTable() throws SQLException {
        return memberService.deleteTable();
    }
}
