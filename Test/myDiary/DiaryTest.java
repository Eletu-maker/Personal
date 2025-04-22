package myDiary;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class DiaryTest {
    @Test
    public void test_that_diary_can_be_added(){
        Diaries diaries = new Diaries();
        diaries.add("usman","12345");


        assertEquals(1,diaries.getDiaries().size());
    }
    @Test
    public void test_that_duplicate_diary_can_not_be_added(){
        Diaries diaries = new Diaries();
        diaries.add("usman","12345");
        diaries.add("usman","12345");


        assertEquals(1,diaries.getDiaries().size());
    }
  @Test
  public void test_that_muultiple_diary_can_be_added(){
      Diaries diaries = new Diaries();
      diaries.add("usman","12345");
      diaries.add("korede","54321");
      diaries.add("victoria","qwert");

      assertEquals(3,diaries.getDiaries().size());
  }

  @Test
    public void test_that_findByUsername(){
      Diaries diaries = new Diaries();
      diaries.add("usman","12345");
      diaries.add("korede","54321");
      diaries.add("victoria","qwert");

      assertEquals("usman, locked: true",diaries.findByUsername("usman").toString());
  }


    @Test
    public void test_that_findByUsername_return_Null(){
        Diaries diaries = new Diaries();
        diaries.add("usman","12345");
        diaries.add("korede","54321");
        diaries.add("victoria","qwert");

        assertNull(diaries.findByUsername("eletu"));
    }
  @Test
    public void test_that_delete_diary_work(){
      Diaries diaries = new Diaries();
      diaries.add("usman","12345");
      diaries.add("korede","54321");
      diaries.add("victoria","qwert");
      diaries.delete("korede","54321");

      assertEquals(2,diaries.getDiaries().size());
  }


  @Test
    public void test_that_diary_is_lock(){
      Diaries diaries = new Diaries();
      diaries.add("usman","12345");
      Diary diary = diaries.findByUsername("usman");
      assertTrue(diary.isLocked());


  }

    @Test
    public void test_that_unlock_diary_work(){
        Diaries diaries = new Diaries();
        diaries.add("usman","12345");
        Diary diary = diaries.findByUsername("usman");
        diary.unlockDiary("12345");
        assertFalse(diary.isLocked());

    }

    @Test
    public void test_that_lock_diary_work(){
        Diaries diaries = new Diaries();
        diaries.add("usman","12345");
        Diary diary = diaries.findByUsername("usman");
        diary.unlockDiary("12345");
        diary.lockDiary("12345");
        assertTrue(diary.isLocked());

    }


    @Test
    public void test_that_createEntry_work() {
        Diaries diaries = new Diaries();
        diaries.add("usman", "12345");
        Diary diary = diaries.findByUsername("usman");
        diary.unlockDiary("12345");
        diary.createEntry( "title1", "body1");
        assertEquals(1, diary.getEntries().size());

    }


    @Test
    public void test_that_Multiple_createEntry_work(){
        Diaries diaries = new Diaries();
        diaries.add("usman","12345");
        Diary diary = diaries.findByUsername("usman");
        diary.unlockDiary("12345");
        diary.createEntry("title1","body1");
        diary.createEntry("title2","body2");
        diary.createEntry("title3","body3");
        assertEquals(3,diary.getEntries().size());

    }


    @Test
    public void test_that_deleteById_work(){
        Diaries diaries = new Diaries();
        diaries.add("usman","12345");
        Diary diary = diaries.findByUsername("usman");
        diary.unlockDiary("12345");
        diary.createEntry("title1","body1");
        diary.createEntry("title2","body2");
        diary.createEntry("title3","body3");

        diary.deleteById(1);
        assertEquals(2,diary.getEntries().size());

    }


    @Test
    public void test_that_multiply_deleteById_work(){
        Diaries diaries = new Diaries();
        diaries.add("usman","12345");
        Diary diary = diaries.findByUsername("usman");
        diary.unlockDiary("12345");
        diary.createEntry("title1","body1");
        diary.createEntry("title2","body2");
        diary.createEntry("title3","body3");
        diary.createEntry("title4","body4");

        diary.deleteById(1);
        diary.deleteById(3);
        assertEquals(2,diary.getEntries().size());

    }
    @Test
    public void test_that_findById_return_Null(){
        Diaries diaries = new Diaries();
        diaries.add("usman","12345");
        Diary diary = diaries.findByUsername("usman");
        diary.unlockDiary("12345");
        diary.createEntry("title1","body1");
        diary.createEntry("title2","body2");
        diary.createEntry("title3","body3");
        diary.createEntry("title4","body4");

        assertNull(diary.findById(25));
    }

    @Test
    public void test_that_findById_work(){
        Diaries diaries = new Diaries();
        diaries.add("usman","12345");
        Diary diary = diaries.findByUsername("usman");
        diary.unlockDiary("12345");
        diary.createEntry("title1","body1");
        diary.createEntry("title2","body2");
        diary.createEntry("title3","body3");
        diary.createEntry("title4","body4");

        assertEquals("2 title2 2025-04-20 body2",diary.findById(2).toString());
    }


    @Test
    public void test_that_updateEntry_work(){
        Diaries diaries = new Diaries();
        diaries.add("usman","12345");
        Diary diary = diaries.findByUsername("usman");
        diary.unlockDiary("12345");
        diary.createEntry("title1","body1");
        diary.createEntry("title2","body2");
        diary.createEntry("title3","body3");
        diary.createEntry("title4","body4");
        diary.updateEntry(2,"new title","new body");

        assertEquals("2 new title 2025-04-20 new body",diary.findById(2).toString());

    }


}