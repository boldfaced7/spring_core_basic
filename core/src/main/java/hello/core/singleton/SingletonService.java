package hello.core.singleton;

public class SingletonService {
    // 싱글톤 패턴을 구현하는 방법은 여러 가지가 있으며, 여기서는 객체를 미리 생성해두는 가장 단순하고 안전한 방법을 선택
    private static final SingletonService instance = new SingletonService();

    // private 생성자를 사용해 외부에서 임의로 객체를 생성하지 못하도록 막아 객체 인스턴스가 1개만 생성되도록 보장
    private SingletonService() {}
    public static SingletonService getInstance() {
        return instance;
    }
}
