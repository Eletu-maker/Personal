package myDiary;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Diaries {
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
            if (diary.getUsername().equals(username) && diary.getPassword().equals(password)) {
                iterator.remove();
                break;
            }
        }
    }

}
