package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Reservation r = new Reservation();
        System.out.print("Room number: ");
        int number = sc.nextInt();
        sc.nextLine();
        System.out.print("Check-in date (dd/mm/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check-out date (dd/mm/yyyy): ");
        Date checkOut = sdf.parse(sc.next());
        if (!checkOut.after(checkIn)){ //Da pra usar checkOut.getTime() <= checkIn. getTime() tambem
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        }else{
            r = new Reservation(number, checkIn, checkOut);
            System.out.println(r);
            System.out.println("Enter data to update the reservation");
            System.out.print("New Check-in date (dd/mm/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("New Check-out date (dd/mm/yyyy): ");
            checkOut = sdf.parse(sc.next());
            Date now = new Date(); // pega a data atual!!! A nova data não pode ser anterior a hoje
            if(checkIn.before(now)|| checkOut.before(now)){
                System.out.println("Error in reservation: Reservation dates for update must be future dates");
            }else if(!checkOut.after(checkIn)){
                System.out.println("Error in reservation: Check-out date must be after check-in date");
            }
            else {
                r.updateDates(checkIn, checkOut);
                System.out.println(r);
            }
        }
        sc.close();
    }


}
