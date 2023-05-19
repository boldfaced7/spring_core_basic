package hello.core.member;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService = new MemberServiceImpl();
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