package com.djcedblab.spring_test;

import com.djcedblab.spring_test.repository.JdbcMemberRepository;
//import com.djcedblab.spring_test.repository.JdbcTemplateMemberRepository;
import com.djcedblab.spring_test.repository.JdbcTemplateMemberRepository;
import com.djcedblab.spring_test.repository.MemberRepository;
import com.djcedblab.spring_test.repository.MemoryMemberRepository;
import com.djcedblab.spring_test.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final DataSource dataSource;
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
// return new MemoryMemberRepository();
// return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }
}