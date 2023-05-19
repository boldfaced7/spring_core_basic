package hello.core.member;

public class MemberServiceImpl implements MemberService {
    // 회원 가입/조회를 수행하기 위해 필요한 MemoryMemberRepository 인스턴스를 생성
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
