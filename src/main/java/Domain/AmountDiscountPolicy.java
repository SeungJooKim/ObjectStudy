package Domain;

/**
 * DiscountPolicy의 자식클래스로서 할인 조건을 만족할 경우 일정한 금액을 할인해 주는 금액 할인 정책
 */
public class AmountDiscountPolicy extends  DiscountPolicy {

    private Money discountAmount;

    /**
     * 가변인자 : ...
     * 가변인자는 파라미터의 순서 중 마지막에 있어야 컴파일 에러가 나지 않음
     */

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition ... conditions){
        super(conditions);
        this.discountAmount = discountAmount;

    }

    @Override
    protected Money getDiscountAmount(Screening screening){
        return discountAmount;
    }
}
