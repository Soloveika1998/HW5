import java.util.ArrayList;
import java.util.List;

public class DataBase {
     private List<Account> accounts;
    
    public DataBase() {
        accounts = new ArrayList<Account>();
    }

    //Метод добавления аккаунта в список
    public boolean add(Account account) {
        boolean flag = false;
        if (!accounts.contains(account)) {
            accounts.add(account);
            flag = true;
        }
        return flag;
    }

    //Метод получения информации об аккаунте
    public Account getAccount(int index) {
        return contains(index) ? accounts.get(index) : null;
    }

    //Метод удаления аккауниа
    public boolean remove(Account account) {
        boolean flag = false;
        if (accounts.indexOf(account) != -1) {
            accounts.remove(account);
            flag = true;
        }
        return flag;
    }

    //Метод проверки наличия искомого индекса в ArrayList accounts
    private boolean contains(int index) {
        return accounts != null
                && accounts.size() > index;
    }

    // public List<Contact> getContacts() {
    //     // if ???...
    //     return contacts;
    // }

    //Метод получения количества аккаунтов в ArrayList accounts
    public int count() {
        return accounts.size();
    }

    // public Account getAccount(int currentIndex) {
    //     return null;
    // }
}