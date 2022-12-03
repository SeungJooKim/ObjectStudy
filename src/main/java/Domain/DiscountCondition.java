package Domain;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
