package project;
import java.util.ArrayList;

public class Database {
    static  ArrayList<Attendee> attendees = new ArrayList<>();
    static  ArrayList<Admin> admins = new ArrayList<>();
    static ArrayList<Organizer> organizers = new ArrayList<>();
    static ArrayList<Events> EVENT = new ArrayList<>();
    static ArrayList<rooms> room = new ArrayList<>();
    static ArrayList<category> categories = new ArrayList<>();

    public static void initializeDummyData(){
        Admin admin1 = new Admin("admin1","pass123","01-11-1999","9-5");
        admins.add(admin1);
        Admin admin2 = new Admin("admin2","pass124","01-01-1987","9-5");
        admins.add(admin2);
        Admin admin3 = new Admin ("admin3","pass125","22-3-2000","10-3");
        admins.add(admin3);

        Organizer organizer1 = new Organizer("hamada","passwordorg1",1000);
        organizers.add(organizer1);
        Organizer organizer2 = new Organizer("fathy","passwordorg2",50);
        organizers.add(organizer2);
        Organizer organizer3 = new Organizer("laila","passwordorg3",100);
        organizers.add(organizer3);

        rooms room1=new rooms("112", "8:00-10:00",true);
        room.add(room1);
        rooms room2=new rooms("567", "12:00-4:00",false);
        room.add(room2);
        rooms room3=new rooms("881", "5:00-9:00",true);
        room.add(room3);
        rooms room4=new rooms("455", "6:00-11:00",true);
        room.add(room4);

        if (Database.attendees.isEmpty()) {
            Attendee a1 = new Attendee("farida", "123", "1-1-2006", 150.0, "cairo", Attendee.Gender.FEMALE, "Music");
            attendees.add(a1);
            Attendee a2 = new Attendee("Reem", "456", "15-7-2006", 200.0, "damietta", Attendee.Gender.FEMALE);
            attendees.add(a2);
            Attendee a3 = new Attendee("Fatma", "789", "24-5-2004", 100.5, "suez", Attendee.Gender.FEMALE);
            attendees.add(a3);
            Attendee a4 = new Attendee("Sandra", "745", "24-5-2004", 100.5, "cairo", Attendee.Gender.FEMALE);
            attendees.add(a4);
            Attendee a5 = new Attendee("Radwa", "909", "24-5-2004", 100.5, "cairo", Attendee.Gender.FEMALE);
            attendees.add(a5);
        }
        category c1 = new category("Music");
        categories.add(c1);
        category c2 = new category("Tech");
        categories.add(c2);
        category c3 = new category("Sports");
        categories.add(c3);

        Events event1 = new Events("Cairokee concert","Music","01-11-2026",organizer1,100.0);
        EVENT.add(event1);
        Events event2 = new Events("stand-up comedy show", "Other","12-9-2025",organizer3,20.0);
        EVENT.add(event2);
        Events event3 = new Events("Ahly vs Zamalek", "Sports" , "17-7-2025",organizer2,50.0);
        EVENT.add(event3);







    }
    public int size(){
        return admins.size();
    }

    public static ArrayList<Admin> getAdmins() {
        return admins;
    }
    public static ArrayList<Attendee> getAttendees() {
        return attendees;
    }
    public static ArrayList<Organizer> getOrganizers(){
        return organizers;
    }





}