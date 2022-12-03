package Domain;

public class SequenceCondition implements DiscountCondition {

    private int sequence;

    public SequenceCondition(int sequence){
        this.sequence = sequence;
    }

    /**
     * 상영 순서와 전달된 파라미터의 순번이 일치할 경우 할인 가능한 것으로 판단.
     * @param screening
     * @return
     */
    public boolean isSatisfiedBy(Screening screening){
        return screening.isSequence(sequence);
    }
}
