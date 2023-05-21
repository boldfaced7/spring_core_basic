package hello.core.member;

import hello.core.AppConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }
    @Test
    void join() {
        // Given
        Member member = new Member(1L, "MemberA", Grade.VIP);

        // When
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // Then
        assertThat(member).isEqualTo(findMember);
    }
}