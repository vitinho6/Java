package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            System.out.print("Room number: ");
            int number = sc.nextInt();
            sc.nextLine();
            System.out.print("Check-in date (dd/mm/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/mm/yyyy): ");
            Date checkOut = sdf.parse(sc.next());

            Reservation r = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + r);

            System.out.println();
            System.out.println("Enter data to update the reservation");
            System.out.print("New Check-in date (dd/mm/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("New Check-out date (dd/mm/yyyy): ");
            checkOut = sdf.parse(sc.next());

            r.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + r);

            sc.close();
        }catch (ParseException p){
            System.out.println("Invalid date format");
        }catch (DomainException d){
            System.out.println("Reservation error: " + d.getMessage());
        }catch (RuntimeException r)
        System.out.println("Unexpected error!!!");
    }


}
