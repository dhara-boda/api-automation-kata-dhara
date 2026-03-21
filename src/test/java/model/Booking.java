package model;

public class Booking {

    private String firstname;
    private String lastname;
    private String totalprice;
    private boolean depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;
    public Booking() {
    }
    public Booking(String firstname, String lastname, String totalprice,
                   boolean depositpaid,
                   String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.additionalneeds = additionalneeds;
    }
    public static class BookingDates {
        private String checkin;
        private String checkout;
        private String totalprice;

        public String getCheckin() { return checkin; }
        public void setCheckin(String checkin) { this.checkin = checkin; }

        public String getCheckout() { return checkout; }
        public void setCheckout(String checkout) { this.checkout = checkout; }

    }
    // Getters and setters for all fields
    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }
    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }
    public String getTotalprice() { return totalprice; }
    public void setTotalprice(String totalprice) { this.totalprice = totalprice; }
    public boolean isDepositpaid() { return depositpaid; }
    public void setDepositpaid(boolean depositpaid) { this.depositpaid = depositpaid; }
    public BookingDates getBookingdates() { return bookingdates; }
    public void setBookingdates(BookingDates bookingdates) { this.bookingdates = bookingdates; }
    public String getAdditionalneeds() { return additionalneeds; }

}