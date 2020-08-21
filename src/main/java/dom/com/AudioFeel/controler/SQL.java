package dom.com.AudioFeel.controler;

import dom.com.AudioFeel.Data.User;

import java.sql.*;
import java.util.HashMap;

public class SQL {

    private static String url = "jdbc:postgresql://localhost:5432/bidderUsers";
    private static String login = "postgres";
    private static String password = "kamykpatyk622";
    public static HashMap<String, String> listaSQLtoList = new HashMap();

    public static void UpdateExport(User user) {

        try {
            Connection con = DriverManager.getConnection(url, login, password);
            PreparedStatement stm = con.prepareStatement("INSERT INTO Users(Login, Pass, IfAdmin ) VALUES (?,?,?)");
            //stm.executeUpdate(query);

            stm.setString(1, user.getLogin());
            stm.setString(2, user.getPassword());
            stm.setInt(3, 0);
            stm.execute();
            System.out.println(user.getLogin());
            System.out.println("New User :" + user.getLogin() + ", " + user.getPassword() + " " + user.getIfAdmin());


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //////////////////////////////////////////////////////////////////////////////////
    public static ResultSet ExecuteImport(String query) {
        try {
            Connection con = DriverManager.getConnection(url, login, password);
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void ImportUsersSQL() {
        try {
            ResultSet rs = ExecuteImport("Select * From Users");

            while (rs.next()) {
                new User(rs.getString("Login"), rs.getString("Pass"), rs.getInt("ifAdmin"));
                //listaSQLtoList.put(rs.getString("Login"), rs.getString("Pass"));


                System.out.printf("Login w bazie: %s\tPass: %s\tifAdmin: %d\n", rs.getString("Login"), rs.getString("Pass"), rs.getInt("ifAdmin"));
            }
            //System.out.println(listaSQLtoList);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Bład Import BD");
        }
    }

    public static void changeToArray() {


    }

    public static boolean ExecuteImport() {
        return true;
    }

    public static boolean ImportUsersSQL(User user) {
        return true;
    }

    public static boolean listaSQLtoList(User log) {
        return true;
    }

}
