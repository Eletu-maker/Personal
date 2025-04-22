package BankeBank;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Accounts {
    private List<Account> AllAcc;

    public Accounts (){
        this.AllAcc = new ArrayList<>();
    }

    public List<Account> getAllAcc(){ return AllAcc;}
    public void add(String username, String password){
        Account acc =new Account(username,password);
        for (Account account:AllAcc){
            if(account.getUsername().equals(username) && account.getPassword().equals(password)){
                return;
            }
        }
        AllAcc.add(acc);
    }

    public void close(String username, String password){
        Iterator<Account> iterator = AllAcc.iterator();
        while (iterator.hasNext()) {
            Account  account= iterator.next();
            if(account.getUsername().equals(username) && account.getPassword().equals(password)){
                iterator.remove();
                break;
            }
        }
    }

    public Account findAccount(String username, String password){
        for (Account account:AllAcc){
            if(account.getUsername().equals(username) && account.getPassword().equals(password)){
                return account;
            }
        }
        return null;
    }

    public Account findByAccountNumber(String username, String accountNumber){
        for (Account account:AllAcc){
            if(account.getUsername().equals(username) && account.getAccountNumber().equals(accountNumber)){
                return account;
            }
        }
        return null;
    }

    public void transfers(String senderUsername, String password,String receiverUsername, String accountNumber,double amount){
        Account sender = findAccount(senderUsername,password);
        Account receiver = findByAccountNumber(receiverUsername,accountNumber);
        if(sender != null && receiver != null){
            sender.withdrawer(amount);
            receiver.deposit(amount);
        }

    }
}
