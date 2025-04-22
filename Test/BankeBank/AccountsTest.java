package BankeBank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountsTest {
    @Test
    public void test_Account_can_be_added_to_Accounts(){
        Accounts accounts = new Accounts();
        accounts.add("usman","12345");
        accounts.add("korede","12345");
        accounts.add("biodun","12345");

        assertEquals(3,accounts.getAllAcc().size());
    }

    @Test
    public void test_duplicate_Account_can_not_be_added_to_Accounts(){
        Accounts accounts = new Accounts();
        accounts.add("usman","12345");
        accounts.add("korede","12345");
        accounts.add("biodun","12345");
        accounts.add("usman","12345");
        accounts.add("biodun","12345");

        assertEquals(3,accounts.getAllAcc().size());
    }

    @Test
    public void test_Account_can_be_remove_to_Accounts(){
        Accounts accounts = new Accounts();
        accounts.add("usman","12345");
        accounts.add("korede","12345");
        accounts.add("biodun","12345");
        accounts.close("korede","12345");

        assertEquals(2,accounts.getAllAcc().size());
    }



    @Test
    public void test_multiple_Account_can_be_remove_to_Accounts(){
        Accounts accounts = new Accounts();
        accounts.add("usman","12345");
        accounts.add("korede","12345");
        accounts.add("biodun","12345");
        accounts.close("korede","12345");
        accounts.close("biodun","12345");

        assertEquals(1,accounts.getAllAcc().size());
    }

    @Test
    public void test_that_can_find_account_in_Accounts(){
        Accounts accounts = new Accounts();
        accounts.add("usman","12345");
        accounts.add("korede","12345");
        accounts.add("biodun","12345");
        accounts.add("Eletu","11111");
        accounts.add("micheal","2222");
        String acc_num= accounts.findAccount("Eletu","11111").getAccountNumber();
        String acc_num1= accounts.findAccount("korede","12345").getAccountNumber();

        assertEquals("Name: Eletu, Balance: 0.0, Account_Number: "+acc_num,accounts.findAccount("Eletu","11111").toString());
        assertEquals("Name: korede, Balance: 0.0, Account_Number: "+acc_num1 ,accounts.findAccount("korede","12345").toString());

    }

    @Test
    public void test_that_can_find_account_in_Accounts_return_null(){
        Accounts accounts = new Accounts();
        accounts.add("usman","12345");
        accounts.add("korede","12345");
        accounts.add("biodun","12345");
        accounts.add("micheal","2222");


        assertNull(accounts.findAccount("Eletu","11111"));
    }

    @Test
    public void test_that_money_can_be_deposited(){
        Accounts accounts = new Accounts();
        accounts.add("usman","12345");
        accounts.add("korede","12345");
        accounts.add("biodun","12345");
        accounts.add("Eletu","11111");
        accounts.add("micheal","2222");
        Account account=  accounts.findAccount("Eletu","11111");
        account.deposit(2000);
        account.deposit(1000);
        account.deposit(500);
        assertEquals(3500,account.getBalance());
        account.deposit(-500);
        assertEquals(3500,account.getBalance());

    }

    @Test
    public void test_that_money_can_be_withdraw(){
        Accounts accounts = new Accounts();
        accounts.add("usman","12345");
        accounts.add("korede","12345");
        accounts.add("biodun","12345");
        accounts.add("Eletu","11111");
        accounts.add("micheal","2222");
        Account account=  accounts.findAccount("Eletu","11111");
        account.deposit(2000);
        account.deposit(1000);
        account.deposit(500);
        assertEquals(3500,account.getBalance());
        account.withdrawer(500);
        assertEquals(3000,account.getBalance());

    }


    @Test
    public void test_that_change_password_work(){
        Accounts accounts = new Accounts();
        accounts.add("usman","12345");
        accounts.add("korede","12345");
        accounts.add("biodun","12345");
        accounts.add("Eletu","11111");
        accounts.add("micheal","2222");
        Account account=  accounts.findAccount("Eletu","11111");
        assertEquals("11111",account.getPassword());
        account.setPassword("09876");
        assertEquals("09876",account.getPassword());


    }


    @Test
    public void test_that_can_find_account_by_acc_num_in_Accounts(){
        Accounts accounts = new Accounts();
        accounts.add("usman","12345");
        accounts.add("korede","12345");
        accounts.add("biodun","12345");
        accounts.add("Eletu","11111");
        accounts.add("micheal","2222");
        String acc_num= accounts.findAccount("Eletu","11111").getAccountNumber();
        String acc_num1= accounts.findAccount("korede","12345").getAccountNumber();


        assertEquals("Name: Eletu, Balance: 0.0, Account_Number: "+acc_num,accounts.findByAccountNumber("Eletu",acc_num).toString());
        assertEquals("Name: korede, Balance: 0.0, Account_Number: "+acc_num1 ,accounts.findByAccountNumber("korede",acc_num1).toString());

    }


    @Test
    public void test_that_can_find_account_by_acc_num_in_Accounts_return_null(){
        Accounts accounts = new Accounts();
        accounts.add("usman","12345");
        accounts.add("korede","12345");
        accounts.add("biodun","12345");
        accounts.add("Eletu","11111");
        accounts.add("micheal","2222");
        String acc_num= accounts.findAccount("Eletu","11111").getAccountNumber();
        String acc_num1= accounts.findAccount("korede","12345").getAccountNumber();


        assertNull(accounts.findByAccountNumber("Eletu","1234334"));
    }

    @Test
    public void test_that_transfer_work(){
        Accounts accounts = new Accounts();
        accounts.add("usman","12345");
        accounts.add("korede","12345");
        accounts.add("biodun","12345");
        accounts.add("Eletu","11111");
        accounts.add("micheal","2222");
        Account account=  accounts.findAccount("Eletu","11111");
        account.deposit(3000);
        Account account1= accounts.findAccount("korede","12345");
        String acc_num1= account1.getAccountNumber();
        accounts.transfers("Eletu","11111","korede",acc_num1,500);
        assertEquals(2500,account.getBalance());
        assertEquals(500,account1.getBalance());

    }
}