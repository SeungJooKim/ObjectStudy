package Domain;

import java.time.LocalDateTime;

public class Screening { /* 상태와 행동을 함께 가지는 복합적 객체*/

    private Movie movie; // 인스턴스 변수의 가시성 private
    private int sequence;
    private LocalDateTime whenScreened;

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened){
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    public Reservation reserve(Customer customer, int audienceCount){
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }
    private Money calculateFee(int audienceCount){
        return movie.calculateMovieFee(this).times(audienceCount);
    }
    public LocalDateTime getStartTime(){
        return whenScreened;
    }
    public boolean isSequence(int sequence){ //public 메소드를 통해서만 내외부 상태 체크,변경
        return this.sequence == sequence;
    }
    public Money getMovieFee(){
        return movie.getFee();
    }
}
