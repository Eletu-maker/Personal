package myDiary;

import java.time.LocalDate;

public class Entry {
    private int id ;
    private String title;
    private  String body;
    private LocalDate dateCreated;


    public Entry(int id, String title,String body){
        this.title =title;
        this.body = body;
        this.id=id;
        this.dateCreated = LocalDate.now();
    }

    public int getId(){return id;}
    public void setTitle(String title){this.title = title;}
    public void setBody(String body){this.body = body;}

    public String toString(){
        return "id: "+this.id+", title: "+this.title+", date: "+this.dateCreated+", body: "+this.body;
    }
}
