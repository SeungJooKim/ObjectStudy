package Domain;

public class Reservation {
    private Customer customer;
    private Screening screening;
    private Money fee;
    private int audienceCount;

    public Reservation(Customer customer, Screening screening, Money fee, int audienceCount){
        this.customer = customer;
        this.screening  = screening;
        this.fee = fee;
        this.audienceCount = audienceCount;
    }
    /*
     * 영화를 예매하기 위해 screening, movie , reservation 인스턴스들은 서로의 메서드를 호출하며 상호 작용
     */

}
