package myDiary;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Diaries implements Serializable {
    private List<Diary> diaries;

    public Diaries (){
        this.diaries = new ArrayList<>();
    }


    public List<Diary> getDiaries(){ return diaries;}

    public void add(String username,String password){
        Diary newDiary = new Diary(username,password);
        for(Diary diary: diaries){
            if (diary.getUsername().equals(username)){
                return;
            }
        }
        diaries.add(newDiary);
    }

    public Diary findByUsername(String username){
      for(Diary diary:diaries){
          if (diary.getUsername().equals(username)){
              return diary;
          }
      }
      return null;
    }

    public void delete(String username,String password){
        Iterator<Diary> iterator = diaries.iterator();
        while (iterator.hasNext()) {
            Diary diary = iterator.next();
            if (diary.getUsername().equals(username) && diary.isCorrect(password)) {
                iterator.remove();
                break;
            }
        }
    }



public void saveToFile(String filename) {
    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
        out.writeObject(this);
        System.out.println("Diaries saved to: " + new File(filename).getAbsolutePath());
    } catch (IOException e) {
        e.printStackTrace();
    }
}


    public static Diaries loadFromFile(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (Diaries) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new Diaries();
        }
    }
}
