import java.sql.*;

public class Main {
        private static final String URL = "jdbc:mysql://localhost:3306/bms";
        private static final String USERNAME = "root";
        private static final String PASSWORD = "0950";

        public static void main(String[] args) {
            Connection connection;
            try {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                if(!connection.isClosed()){
                    System.out.println("Соединение с БД установлено!");
                }
                Statement statement = connection.createStatement();
//                statement.execute("INSERT INTO books(title, author, genre) values ('Человек-невидимка', 'Ральф Эллисон', 'Детектив');");

                ResultSet resultSet = statement.executeQuery("SELECT * FROM books");
                while(resultSet.next()){
                    int id = resultSet.getInt(1);
                    String title = resultSet.getString(2);
                    String author = resultSet.getString(3);
                    String genre = resultSet.getString(4);
                    System.out.println(id + ", "+ title + ", " + author + ", " + genre);
                }

                connection.close();
                if (connection.isClosed()){
                    System.out.println("Соединение с БД закрыто.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
