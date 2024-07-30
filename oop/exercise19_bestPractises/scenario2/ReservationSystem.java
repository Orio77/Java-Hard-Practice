package oop.exercise19_bestPractises.scenario2;

public class ReservationSystem {
    
    public void reserveBook(Book book) {
        book.setReserved(true);
    }

    public void cancelReservation(Book book) {
        if (book.isReserved())
            book.setReserved(false);
    }
}
