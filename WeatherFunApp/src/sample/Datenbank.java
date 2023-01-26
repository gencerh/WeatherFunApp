package sample;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Datenbank {

    String url = "jdbc:mysql://localhost:3306/ap22_hakki";
    String username = "root";
    String password = "";

    public Datenbank() {
    }
    public boolean DBConnect(){
        String url = "jdbc:mysql://localhost:3306/ap22_hakki";
        String user = "root";
        String password = "";
        try{
            Connection conn = DriverManager.getConnection(url, user, password);
            return true;

        } catch (SQLException throwables) {
            return false;
        }
    }

    public boolean createInfo(String uname, String mail, String tnum, String pwd) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ap22_hakki";
        String username = "root";
        String password = "";
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "INSERT INTO users(username,e_mail,telefonnummer,password)" + " VALUES " + "('" + uname + "', '" + mail + "', '" + tnum + "', '" + pwd + "')";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.executeUpdate(sql);

        } catch (SQLException throwables) {
        }
        return false;
    }

    public boolean checkLogin(String usname, String paswd) throws SQLException {
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "SELECT * FROM users WHERE username = '" + usname + "' and password = '" + paswd + "'";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();

        } catch (SQLException throwables) {
            return false;
        }

    }
    public boolean checkAdmin(String userName){
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "SELECT * FROM users WHERE username = '" + userName +"'";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            boolean isAdmin=false;

            while (resultSet.next()){

                isAdmin = resultSet.getBoolean("is_admin");

            }
            return isAdmin;

        } catch (SQLException throwables) {
            return false;
        }
    }
    public boolean checkRegistiration(String usname) throws SQLException {
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "SELECT * FROM users WHERE username = '" + usname + "'";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();
        } catch (SQLException throwables) {
            return false;
        }

    }
    public List<Person> getPersonList() throws SQLException {
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery("select * from users");
            List<Person> personList = new ArrayList<>();
            while (rs.next()) {
                String id = rs.getString("id");
                String username = rs.getString("username");
                String email = rs.getString("e_mail");
                String telefonNummer = rs.getNString("telefonnummer");
                Person person = new Person(id, username, email,telefonNummer);
                personList.add(person);
            }
            System.out.println(personList.get(1).getEmail());
            return personList ;
        }
        catch (SQLException throwables) {
            return null;
        }
    }

}
