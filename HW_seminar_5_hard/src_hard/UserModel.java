import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class UserModel {
    
    DataBase currentDataBase;
    private int currentIndex;
    private String path;

    //Конструктор класса UserModel
    public UserModel(String path) {
        currentDataBase = new DataBase();
        currentIndex = 0;
        this.path = path;
    }

    //Метод получения информации о текущем аккаунте
    public Account currentAccount() {
        if (currentIndex >= 0) {
            return currentDataBase.getAccount(currentIndex);
        } else {
            System.out.println("База данных пуста");
            return null;
        }
    }

    //Метод записи в DataBase данных из файла
    public void load() {
        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String login = reader.readLine();
            while (login != null) {
                String password = reader.readLine();
                String email = reader.readLine();
                this.currentDataBase.add(new Account(login, password, email));
                login = reader.readLine();
            }
            reader.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Метод записи в файл данных из DataBase
    public void save() {

        try (FileWriter writer = new FileWriter(path, false)) {
            for (int i = 0; i < currentDataBase.count(); i++) {
                Account account = currentDataBase.getAccount(i);
                writer.append(String.format("%s\n", account.login));
                writer.append(String.format("%s\n", account.password));
                writer.append(String.format("%s\n", account.email));
            }
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //Метод получения текущей DataBase
    public DataBase currentDB() {
        return this.currentDataBase;
    }

    //Метод получения текущего индекса DataBase
    public int getCurrentIndex() {
        return this.currentIndex;
    }

    //Метод установки текущего индекса в DataBase
    public void setCurrentIndex(int value) {
        this.currentIndex = value;
    }
}