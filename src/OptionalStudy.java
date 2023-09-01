import java.util.Optional;

public class OptionalStudy {

    /*
        Optional이란?
         - Java8에서는 Optional<T> 클래스를 사용해 NPE를 방지할 수 있도록 도와준다.
            Optional<T>는 null이 올 수 있는 값을 감싸는 Wrapper 클래스로,
            참조하더라도 NPE가 발생하지 않도록 도와준다.
            Optional 클래스는 아래와 같은 value에 값을 저장하기 때문에 값이 null이더라도 바로 NPE가 발생하지 않으며,
            클래스이기 때문에 각종 메소드를 제공해준다.

        NPE란?
         - NullPointerException

         Optional 객체의 생성
            of() 메소드나 ofNullable() 메소드를 사용하여 Optional 객체를 생성할 수 있습니다.
            of() 메소드는 null이 아닌 명시된 값을 가지는 Optional 객체를 반환합니다.
            만약 of() 메소드를 통해 생성된 Optional 객체에 null이 저장되면 NullPointerException 예외가 발생합니다.
            따라서 만약 참조 변수의 값이 만에 하나 null이 될 가능성이 있다면, ofNullable() 메소드를 사용하여 Optional 객체를 생성하는 것이 좋습니다.
            ofNullable() 메소드는 명시된 값이 null이 아니면 명시된 값을 가지는 Optional 객체를 반환하며, 명시된 값이 null이면 비어있는 Optional 객체를 반환합니다.
     */

    public static void main(String[] args) {
        Optional<String> optional;
        String word = null;
        {
            word = "Hello";
            optional = Optional.of(word);
            System.out.println(optional.get());
        }

        {
            word = null;
            optional = Optional.ofNullable(word);
            if (optional.isPresent()){ //optional.isPresent() 널인지 아닌지 체크 해주는 매서드
                System.out.println(optional.get()); // get optional 접근매서드
            }
        }

        {
            word = null;
            System.out.println(optional.orElse("비어있는 optional")); // 출력결과 : 비어있는 optional
        }
    }
}
