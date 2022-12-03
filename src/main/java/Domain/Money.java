package Domain;


import java.math.BigDecimal;

public class Money { // 저장하는 값이 금액과 관련되었음을 나타내고자 long타입이 아닌 money 객체 사용
    public static final Money ZERO = Money.wons(0);

    private final BigDecimal amount;

    Money(BigDecimal amount){
        this.amount = amount;
    }

    public static Money wons(long amount){
        return new Money(BigDecimal.valueOf(amount));
    }

    public static Money wons(double amount){
        return new Money(BigDecimal.valueOf(amount));
    }

    public Money plus(Money amount){
        return new Money(this.amount.add(amount.amount));
    }
    public Money minus(Money amount){
        return new Money(this.amount.subtract(amount.amount));
    }
    public Money times(double percent){
        return new Money(this.amount.multiply(BigDecimal.valueOf(percent)));
    }
    public boolean isLessThan(Money other){
        return amount.compareTo(other.amount) < 0;
    }
    public boolean isGreaterThanOrEqual(Money other){
        return amount.compareTo(other.amount) >=0;
    }
}
