package myDiary;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;

public class Diary implements Serializable {
    private String username;
    private String password;
    private boolean isLocked;
    private List<Entry> entries;
    private int counter;



    public Diary(String username, String password){
        this.username =username;
        this.password = password;
        this.isLocked = true;
        this.entries = new ArrayList<>();
        this.counter =0;

    }

    public String getUsername(){ return username; }


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
           this.counter++;
           Entry entry = new Entry(this.counter, title, body);
           entries.add(entry);
       }

    }

    public void deleteById(int id) {
      /*
        Iterator<Entry> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Entry entry = iterator.next();
            if (entry.getId() == id) {
                iterator.remove();
                break;
            }
        }

       */


        for(Entry entry:entries){
            if (entry.getId() == id) {
                entries.remove(entry);
                break;
            }
        }
        /*
        for(int count =0; count <entries.size(); count++){
            if (entries.get(count).getId() == id){
                entries.remove(entries.get(count));
            }
        }

         */
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


    public boolean isCorrect(String password) {
        return this.password.equals(password);
    }
}
