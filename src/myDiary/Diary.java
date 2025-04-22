package myDiary;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Diary {
    private String username;
    private String password;
    private boolean isLocked;
    private List<Entry> entries;
    private int id;



    public Diary(String username, String password){
        this.username =username;
        this.password = password;
        this.isLocked = true;
        this.entries = new ArrayList<>();
        this.id =0;

    }

    public String getUsername(){ return username; }
    public String getPassword(){ return password;}
    public List<Entry> getEntries(){ return entries;}

    public void unlockDiary(String pin){
        if(this.password.equals(pin)){
            isLocked = false;
        }
    }

    public void lockDiary(String pin){
        if(this.password.equals(pin)){
            isLocked = true;
        }
    }

    public boolean isLocked(){return isLocked;}


    public void createEntry(String title, String body){

       if(!isLocked) {
           this.id++;
           Entry entry = new Entry(this.id, title, body);
           entries.add(entry);
       }

    }

    public void deleteById(int id) {
        Iterator<Entry> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Entry entry = iterator.next();
            if (entry.getId() == id) {
                iterator.remove();
                break;
            }
        }
    }

    public Entry findById(int id){
        for(Entry entry:entries){
            if(entry.getId() == id){
                return entry;
            }
        }
        return null;
    }

    public void updateEntry(int id,String title,String body){
        Entry chapter = findById(id);
        if(chapter != null){
            chapter.setBody(body);
            chapter.setTitle(title);
        }


    }


    public String toString(){
        return this.username+", locked: "+ this.isLocked;
    }


}
