import java.util.ArrayList;
import java.util.List;

public class Test {


    public interface A {

    }

    public static class B implements A {


    }

    public static class C implements A {
    }

    public static void main(String[] args) {
        List<? super A> a = new ArrayList<>();
        a.add(new B());
        a.add(new C());

    }
}

