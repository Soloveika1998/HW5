public class Account implements Comparable<Account> {

    public String login;
    public String password;
    public String email;
   
    //Конструктов класса Account
    public Account(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }
 
    @Override
    public int compareTo(Account o) {
        return 0;
    }

    //Переопределяем метод equals, т.е. устанавливаем, что значит I аккаунт равен II аккаунту
    @Override
    public boolean equals(Object obj) {
        Account t = (Account)obj;
        return this.login == t.login
                && this.email == t.email;
    }

}
