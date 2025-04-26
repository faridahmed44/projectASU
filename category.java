package project;

public class category {
    @Override
    public String toString() {
        return "Category name: " + name + "\n\n" ;
    }

    private String name;

    public category(){

    }
    public category(String name){
        this.name=name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }


}
