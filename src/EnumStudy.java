import java.lang.reflect.Array;
import java.util.Arrays;

public class EnumStudy {
    /*
        Eunm의 장점
        - 코드가 단순해지며 가독성이 좋아진다
        - 허용 가능한 값들을 제한하여 유형 안전(type safe)을 제공한다.
        - 키워드 enum을 사용하기 때문에 구현의 의도가 열거임을 분명하게 나타낼 수 있다.
        - 자체 클래스 상수와 달리 switch문에서도 사용할 수 있다
        - 단순 상수와 비교해 IDE의 적극적인 지원을 받을 수 있다 (자동완성, 오타검증, 텍스트 리팩토링 등등)
        - 리팩토링시 변경 범위가 최소화 된다 (enum에서 한번에 관리하기 때문에 내용의 추가가 필요하더라도, Enum 코드외에 수정할 필요가 없다)
        - enum은 본질적으로 Thread safe인 싱글톤 객체 이므로 싱글톤 클래스를 생성하는데에도 사용된다

        추가적으로 enum 성능은 어떨가 싶지만,
        정수 상수와 다르지 않으며 열거 타입을 메모리에 올리는 공간과 초기화 시간이 있지만 체감될 정도는 아니다.
     */

    public static void main(String[] args) {

        { // 일반적인 문장
            Phone phone = new Phone();
            phone.setName("apple");
            phone.setNumber(37);

            Phone phone2 = new Phone();
            phone2.setName("samsung");
            phone2.setNumber(127);

            System.out.println(getPhoneName(phone));
            System.out.println(getPhoneName(phone2));
        }

        { // enum 활용 했을때
            String str = EnumPhone.getEnumPhoneName("iphone", 37);
            String str2 = EnumPhone.getEnumPhoneName("samsung", 127);

            System.out.println(str);
            System.out.println(str2);
        }

    }

    public static String getPhoneName(Phone phone){
        String name = "";
        if (phone.getName().equals("apple") && phone.getNumber() == 37) {
            name = "아이폰";
        } else if (phone.getName().equals("samsung") && phone.getNumber() == 127) {
            name = "갤럭시폰";
        }
        return name;
    }
}
class Phone{
    private String name;
    private long number;

    public long getNumber(){return number;}
    public void setNumber(long number){this.number = number;}
    public String getName(){return name;}
    public void setName(String name){this.name = name;}
}
enum EnumPhone{
    PHONE_TYPE1("아이폰", "iphone", 37),
    PHONE_TYPE2("갤럭시폰", "samsung", 127),
    NONE("논", "no", 0);

    private String phoneName;
    private String name;
    private long number;

    EnumPhone(String phoneName, String name, long number){
        this.phoneName = phoneName;
        this.name = name;
        this.number = number;
    }

    public static EnumPhone getEnumPhone(String name, long number){
        return Arrays.stream(EnumPhone.values())
                .filter(x -> x.name.equals(name) && x.number == number)
                .findAny()
                .orElse(NONE);
    }

    public static String getEnumPhoneName(String name, long number){
        return getEnumPhone(name, number).getPhoneName();
    }
    public String getPhoneName(){
        return this.phoneName;
    }
}