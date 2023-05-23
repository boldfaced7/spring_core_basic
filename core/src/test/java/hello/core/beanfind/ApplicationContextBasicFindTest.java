package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        // 스프링 빈의 이름과 타입을 ac 객체의 getBean() 메소드로 넘겨 빈을 조회
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType() {
        // 스프링 빈의 타입만을 ac 객체의 getBean() 메소드로 넘겨 빈을 조회
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2() {
        // 스프링 빈의 이름과 구체 타입을 ac 객체의 getBean() 메소드로 넘겨 빈을 조회
        // 구체 타입으로 조회하면, 변경 시 유연성이 떨어져 좋지 않음
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("존재하지 않는 빈 조회")
    void findBeanByNameX() {
        assertThrows(NoSuchBeanDefinitionException.class,
              () -> ac.getBean("xxxxx", MemberServiceImpl.class));
    }
}
