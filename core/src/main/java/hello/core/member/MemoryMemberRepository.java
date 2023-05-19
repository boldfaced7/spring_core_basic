package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
        // 오류 처리는 예제를 간단히 만들기 위해 생략
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
        // 오류 처리는 예제를 간단히 만들기 위해 생략
    }

}
