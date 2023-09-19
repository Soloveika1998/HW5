public class UserPresenter {
    private UserModel model;
    private UserView view;

    public UserPresenter(NewConsoleView view, String pathDb) {
        this.view = view;
        model = new UserModel(pathDb);
    }

    //Метод записи в DataBase данных из файла
    public void LoadFromFile() {
        model.load();

        if (model.currentDB().count() > 0) {
            model.setCurrentIndex(0);
            var account = model.currentAccount();

            view.setLogin(account.login);
            view.setPassword(account.password);
            view.setEmail(account.email);
        }
    }

    public void add() {
        model.currentDB().add(
                new Account(view.getLogin(), view.getPassword(), view.getEmail()));
    }

    public void remove() {
        Account account = new Account(view.getLogin(), view.getPassword(), view.getEmail());
        model.currentDB().remove(account);

        if (model.currentDB().count() < 1) {
            model.setCurrentIndex(-1);

            view.setLogin("");
            view.setPassword("");
            view.setEmail("");
        } else {
            model.setCurrentIndex(model.getCurrentIndex() - 1);
            if (model.getCurrentIndex() < 0)
                model.setCurrentIndex(0);

            Account temp = model.currentAccount();
            view.setLogin(temp.login);
            view.setPassword(temp.password);
            view.setEmail(temp.email);
        }
    }

    public void saveToFile() {
        model.save();
    }
}
