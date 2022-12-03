package Domain;

import java.time.Duration;

public class Movie {

    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;

    /**
     * movie 는 discountpolicy에 의존한다.
     * 그러나 실행 시점에는 movie의 인스턴스는 amountpolicy 나 PercentDiscountPolicy의 인스턴스에 의존하게 된다.
     *  = 코드의 의존성과 실행 시점의 의존성이 서로 다를 수 있음.
     */
    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy){
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money getFee() {
        return fee;
    }

    /**
     *  Movie는 기본 요금인 Fee 에서 반환된 할인 요금을 차감.
     * @param screening
     * @return
     */
    public Money calculateMovieFee(Screening screening){
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }

    public void changeDiscountPolicy(DiscountPolicy discountPolicy){
        this.discountPolicy = discountPolicy;
    }
}
