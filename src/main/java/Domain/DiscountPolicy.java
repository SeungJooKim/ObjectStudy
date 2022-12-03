package Domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * AmountDiscountPolicy , PercentDiscountPolicy 가 존재
 *  두 클래스는 대부분 코드가 중복되기때문에 부모 클래스인 DiscountPolicy안에 장복 코드를 두고 상속받아 사용
 *  DiscountPolicy의 인스턴스를 생성할 필요가 없기 때문에 추상 클래스로 구현
 */
public abstract class DiscountPolicy {

    /**
     * 하나의 할인 정책은 여러 개의 할인 조건을 포함할 수 있다.
     */

    private List<DiscountCondition> conditions = new ArrayList<>();

    public DiscountPolicy(DiscountCondition ...conditions){
        this.conditions = Arrays.asList(conditions);
    }

    public Money calculateDiscountAmount(Screening screening){
        for(DiscountCondition each: conditions){
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);

            }
        }
        return Money.ZERO;
    }

    /**
     * 부모클래스에 기본적인 알고리즘의 흐름을 구현하고 중간에 필요한 처리를 자식 클래스에 위임하는 디자인 패턴
     * - > templage Method
     * @param screening
     * @return
     */
    abstract protected Money getDiscountAmount(Screening screening);
}