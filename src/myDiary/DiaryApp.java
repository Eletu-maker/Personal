package myDiary;


import java.util.InputMismatchException;
import java.util.Scanner;

public class DiaryApp {

    public static void main(String[] args) {
        Diaries diaries = new Diaries();
        Scanner entries = new Scanner(System.in);
        System.out.println("Welcome to bebeto diary room");
        boolean repeat = true;
        int num =0;
        String username;
        String password;
        String title;
        String body;
        while (repeat) {
            System.out.println("""
                    
                    Enter your choice of action?
                    1. Create diary
                    2. Enter diary
                    3. Close diary
                    4. Exit
                    
                    """);


            int option =0;
            boolean valid = false;

            while (!valid) {
                try {
                    System.out.print("Enter your choice: ");
                    option = entries.nextInt();

                    if (option < 1 || option > 4) {
                        System.out.println("Unacceptable value: please enter option number between 1 and 5.");
                    } else {
                        valid = true;
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Invalid input: please enter a number.");
                    entries.next();
                }
            }


            switch (option){
                case 1:

                    System.out.println("Enter your details here");
                    System.out.print("Enter username: ");
                    entries.nextLine();
                     username = entries.nextLine();
                    System.out.print("Enter password: ");
                     password = entries.nextLine();
                    num++;
                     diaries.add(username,password);
                    if(diaries.getDiaries().size() ==num){
                        System.out.println("Account create successfully");
                    }else {
                        System.out.println("Account with this username already exist");
                        num--;
                    }

                    break;
                case 2:
                    System.out.println("Enter your details here");
                    System.out.print("Enter username: ");
                    entries.nextLine();
                     username = entries.nextLine();
                     Diary diary = diaries.findByUsername(username);
                     if(diary != null) {
                         System.out.println(diaries.findByUsername(username));
                         System.out.println("Enter password to unlock");
                         while (diary.isLocked()) {
                             System.out.print("Enter password: ");
                             password = entries.nextLine();
                             diary.unlockDiary(password);
                             System.out.println(diary);
                         }
                         System.out.println("""
                                 
                                 Enter your choice
                                 1. Create new entry
                                 2. Update previous entry
                                 
                                 """);
                         int innerOption =0;
                         valid = false;
                         while (!valid) {
                             try {
                                 System.out.print("Enter your choice: ");
                                 innerOption = entries.nextInt();

                                 if (innerOption < 1 || innerOption > 2) {
                                     System.out.println("Unacceptable value: please enter option number between 1 and 2 .");
                                 } else {
                                     valid = true;
                                 }

                             } catch (InputMismatchException e) {
                                 System.out.println("Invalid input: please enter a number.");
                                 entries.next();
                             }
                         }

                         switch (innerOption){
                             case 1:
                                 System.out.println("Enter entry title");
                                 entries.nextLine();
                                 title =  entries.nextLine();
                                 System.out.println("Enter entry body");
                                 body =  entries.nextLine();
                                 diary.createEntry(title,body);
                                 System.out.println(diary.getEntries());
                                 break;
                             case 2:
                                 if(diary.getEntries().isEmpty()){
                                     System.out.println("No entries created yet");
                                 }else {
                                     System.out.println(diary.getEntries());

                                     int id = 0;
                                     valid = false;
                                     while (!valid) {
                                         try {
                                             System.out.println("Enter id: ");
                                             id = entries.nextInt();
                                             valid=true;
                                         } catch (InputMismatchException e) {
                                             System.out.println("Invalid input: please enter a number.");
                                             entries.next();
                                         }
                                     }
                                     Entry entry= diary.findById(id);
                                     if( entry == null ){
                                         System.out.println("Entry doesn't exist");
                                     }else {
                                         System.out.println("Enter update title");
                                         entries.nextLine();
                                         title =  entries.nextLine();
                                         System.out.println("Enter update body");
                                         body =  entries.nextLine();
                                         diary.updateEntry(id,title,body);
                                         System.out.println(diary.getEntries());
                                     }

                                 }

                         }



                     }else {
                         System.out.println("Account does not exist");
                     }

                    break;
                case 3:

                    System.out.println("Enter your details here");
                    System.out.print("Enter username: ");
                    entries.nextLine();
                    username = entries.nextLine();
                    System.out.print("Enter password: ");
                    password = entries.nextLine();
                    diaries.delete(username,password);
                    num = diaries.getDiaries().size();
                    break;
                case 4:
                    System.out.println("Goodbye come with more gist next time");
                    repeat = false;
                    break;
            }


        }




    }
}
