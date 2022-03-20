package com.djcedblab.spring_test.service;

import com.djcedblab.spring_test.domain.Member;
import com.djcedblab.spring_test.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

//@Service
public class MemberService {

    private final MemberRepository memberRepository;

    //@Autowired
    public MemberService(MemberRepository memberRepository) {       // Dependency Injection
        this.memberRepository = memberRepository;
    }

    /**

    회원가입

     */
    public Long join(Member member){
        validateDuplicateMember(member);    // 중복회원 금지
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
                throw new IllegalStateException("존재하는 회원입니다.");
        });
    }

    /**
     * 회원조회
     *
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();

    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
