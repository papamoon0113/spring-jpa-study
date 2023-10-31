package com.example.springedu2;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import springjpa.exam.entity.Member;
import springjpa.exam.repository.MemberTeamLockerRepository;

import java.util.List;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class JPA_MemberTeamLockerTest4 {
    @Autowired
    private MemberTeamLockerRepository repo;
    
    @BeforeEach()
    void pr() {
        System.out.println("=".repeat(80));
    }
   @Test
    void test_byUsername() {
    	List<Member> list = repo.findByUsername("짱아");
    	for(Member m : list) {
    		System.out.println(m.getId());    
    		System.out.println(m.getUsername());
    		System.out.println(m.getTeam());
    	}
    }
    @Test
    void test_countByUsername() {
    	long num =repo.countByUsername("짱아");
    	System.out.println("짱아는 " + num + "명");    		
    }      
   @Test
   void test_countBy() {
    	long num =repo.countBy();
    	System.out.println("전체 회원은 " + num + "명");    		
    }
    @AfterAll
    static void end() {
        System.out.println("=".repeat(80));
        System.out.println("[[[[[[ 테스트 종료 ]]]]]]");
    }
}
