package aplication;

import model.entities.Reservation;
import model.exception.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

        try {
            System.out.println("quarto: ");
            int quarto = sc.nextInt();
            System.out.println("data checkint(dd/MM/yyyy): ");
            Date checkin = sdf.parse(sc.next());
            System.out.println("date checkout: ");
            Date checkout = sdf.parse(sc.next());

            Reservation rs = new Reservation(quarto, checkin, checkout);
            System.out.println("reserva: " + rs);

            System.out.println();
            System.out.println("quarto: ");
            quarto = sc.nextInt();
            System.out.println("data checkin (dd/MM/yyyy): ");
            checkin = sdf.parse(sc.next());
            System.out.println("data checkout (dd/MM/yyyy): ");
            checkout = sdf.parse(sc.next());

            rs.updateDate(checkin, checkout);
            System.out.println("reserva: " + rs);
        } catch (ParseException e){
            System.out.println("invalid date format");
        } catch (DomainException e){
            System.out.println("Erro na reserva" + e.getMessage());
        } catch (RuntimeException e){
            System.out.println("Erro inesperado");
        }
    }
}
