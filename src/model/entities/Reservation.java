package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer room;
    private Date checkin;
    private Date checkout;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd//MM/yyy");

    public Reservation(Integer room, Date checkin, Date checkout) {
        this.room = room;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public Date getCheckin() {
        return checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public long durationDays() {
        long diff = checkout.getTime() - checkin.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public String updateDate(Date checkin, Date checkout){

        Date now = new Date();
        if (checkin.before(now) || checkout.before(now)){
            return "erro na reserva, deve ser datas futuras";
        }
        if(!checkout.after(checkin)) {
            return "erro, checkin maior que checkout";
        }
        this.checkin = checkin;
        this.checkout = checkout;
        return null;
    }

    @Override
    public String toString() {
        return "room: " + room +
                ", check-in: " + sdf.format(checkin) +
                ", check-out: " + sdf.format(checkout) +
                ", "
                + durationDays()
                +" nights";
    }
}

