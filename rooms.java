package project;

public class rooms {

        private String availablehours;
        private String roomNumber;
        private boolean available;

        public rooms(){
        }

        public rooms(String roomNumber , String availablehours, boolean available) {

            this.availablehours = availablehours;
            this.roomNumber = roomNumber;
            this.available = available;
        }

    @Override
    public String toString() {
        return "Room Number : " + roomNumber +
                "\n Available Hours : " + availablehours
                +"\n Is it available for rent? " + isAvailable() +"\n\n";
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomNumber() {
            return roomNumber;
        }

    public String getAvailablehours() {
        return availablehours;
    }

    public void setAvailablehours(String availablehours) {
        this.availablehours = availablehours;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

}

