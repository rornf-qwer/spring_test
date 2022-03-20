package com.djcedblab.spring_test.service;

import com.djcedblab.spring_test.domain.Member;
import com.djcedblab.spring_test.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach                                             // Dependency Injection
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {                     // 메서드 하나하나 실행끝나고 동작
        memberRepository.clearStore();            // 메모리 클리어
    }


    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("Spiirrrrrr");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("Spiirrrrrr");

        Member member2 = new Member();
        member2.setName("Spiirrrrrr");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("존재하는 회원입니다.");

/*
        예시
        memberService.join(member1);
        try{
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("존재하는 회원입니다.1");
        }
*/


        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}