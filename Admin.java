package project;

import java.util.Scanner;


public class Admin extends person  {
    Scanner sc = new Scanner(System.in);
    Database db = new Database();
    private String workingHours;

    public Admin(){

    }

    @Override
    public String Role() {

        return "Admin";

    }


    public Admin(String username , String password , String dateOfBirth , String workingHours ){
        super(username,password,dateOfBirth);
       this.workingHours = workingHours;

    }

    //getters


    public String workingHours(){
        return workingHours;
    }

    //setters


    void setWorkingHours(String workingHours){
        this.workingHours = workingHours;
    }

    public void Addrooms(){


        System.out.println("Enter the number of rooms you want to add");
        int noOfRooms = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < noOfRooms; i++) {
            System.out.println("Enter room number: ");
            String roomNumber = sc.nextLine();
            sc.nextLine();
            System.out.println("Enter available hours ( from - to ) : ");
            String hours = sc.next();
            sc.nextLine();
            System.out.println("available ? ");
            boolean availabilty= true;
            if (sc.nextLine().equalsIgnoreCase("yes")) {
                 availabilty= true;
            } else if (sc.nextLine().equalsIgnoreCase("no")) {
                availabilty= false;
            }


            rooms room = new rooms(roomNumber , hours, availabilty );
            Database.room.add(room);
                System.out.println("Room added successfully!! ");
        }

    }
    public void CategoryEdit(){
        System.out.println("Select the action you want to proceed with:");
        System.out.println("1.Add a new category");
        System.out.println("2.Delete a category");
        System.out.println("3.Update a category");
        System.out.println("0.Exit dashboard");

        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice){

            case 1:
                System.out.println("Enter new category:");
                String name = sc.nextLine();
                category cat = new category(name);
                Database.categories.add(cat);
                System.out.println("category created successfully");
                break;
            case 2:
                System.out.println("Categories available: \n");
                for (category c : Database.categories)
                    System.out.println(c);

                System.out.println("Choose a category you want to delete:");
                String name2 = sc.nextLine();

                boolean found = false;
                for (int i = 0; i < Database.categories.size(); i++) {
                    if (Database.categories.get(i).getName().equals(name2)) {
                        Database.categories.remove(i);
                        System.out.println("Category deleted successfully");
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Category unavailable");
                }

                break;
            case 3:
                System.out.println("Categories available: \n");
                for (category c : Database.categories)
                    System.out.println(c);

                System.out.println("Choose a category you want to update:");
                String name3 = sc.nextLine();

                boolean found1 = false;
                for (int i = 0; i < Database.categories.size(); i++) {
                    if (Database.categories.get(i).getName().equals(name3)) {
                        System.out.println("what is the updated category?");
                        String name4 = sc.nextLine();
                        category cat3 = new category(name4);
                        Database.categories.set(i,cat3);
                        System.out.println("Category updated successfully");
                        found1 = true;
                        break;
                    }
                }

                if (!found1) {
                    System.out.println("Category unavailable");
                }

                break;

            case 0:
                System.out.println("byeeeeeeeee");
                return;
            default:
                System.out.println("invalid choice");
        }

    }
}
