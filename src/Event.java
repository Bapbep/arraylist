import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Event {
    private String eventID;
    private String eventName;
    private String eventLocation;
    private LocalDate eventDate;
    private ArrayList<String> eventAttendees;

    public Event(String eventID, String eventName, String eventLocation, LocalDate eventDate) {
        this.eventID = eventID;
        this.eventName = eventName;
        this.eventLocation = eventLocation;
        this.eventDate = eventDate;
        this.eventAttendees = new ArrayList<>();
    }

    // Getter and setter methods

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public ArrayList<String> getEventAttendees() {
        return eventAttendees;
    }

    public void addAttendee(String attendee) {
        eventAttendees.add(attendee);
    }

    public void removeAttendee(String attendee) {
        eventAttendees.remove(attendee);
    }

    public int getTotalAttendees() {
        return eventAttendees.size();
    }

    public void organizeEvent() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of attendees:");
        int numAttendees = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numAttendees; i++) {
            System.out.println("Enter attendee name:");
            String attendee = scanner.nextLine();
            addAttendee(attendee);
        }

        System.out.println("\nEvent details:");
        System.out.println(this);

        System.out.println("\nAttendees:");
        displayAttendees();
    }

    public void displayAttendees() {
        for (String attendee : eventAttendees) {
            System.out.println(attendee);
        }
        System.out.println("Total number of attendees: " + getTotalAttendees());
    }

    @Override
    public String toString() {
        return "Event ID: " + eventID + "\nEvent Name: " + eventName + "\nEvent Location: " + eventLocation + "\nEvent Date: " + eventDate;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter event ID:");
        String eventID = scanner.nextLine();

        System.out.println("Enter event name:");
        String eventName = scanner.nextLine();

        System.out.println("Enter event location:");
        String eventLocation = scanner.nextLine();

        System.out.println("Enter event date (yyyy-MM-dd):");
        String eventDateString = scanner.nextLine();
        LocalDate eventDate = LocalDate.parse(eventDateString);

        Event event = new Event(eventID, eventName, eventLocation, eventDate);

        event.organizeEvent();
    }
}
