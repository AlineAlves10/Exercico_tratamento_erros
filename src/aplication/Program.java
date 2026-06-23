package aplication;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program{
    public static void main(String[] args) throws ParseException{
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

        System.out.println("quarto: ");
        int quarto = sc.nextInt();

        System.out.println("data checkint(dd/MM/yyyy): ");
        Date checkin = sdf.parse(sc.next());

        System.out.println("date checkout: ");
        Date checkout = sdf.parse(sc.next());

        if(!checkout.after(checkin)){
            System.out.println("erro, checkin maior que checkout");
        } else{
            Reservation rs = new Reservation(quarto, checkin, checkout);
            System.out.println("Reservation: " + rs);

            System.out.println();
            System.out.println("quarto: ");
            quarto = sc.nextInt();

            System.out.println("data checkin (dd/MM/yyyy): ");
            checkin = sdf.parse(sc.next());

            System.out.println("date checkout (dd/MM/yyyy): ");
            checkout = sdf.parse(sc.next());

            Date now = new Date();
            if (checkin.before(now) || checkout.before(now)){
                System.out.println("erro na reserva, deve ser datas futuras");
            } else if(!checkout.after(checkin)) {
                System.out.println("erro, checkin maior que checkout");
            } else{
                rs.updateDate(checkin, checkout);
                System.out.println("Reservation: " + rs);
            }

        }

    }
}
