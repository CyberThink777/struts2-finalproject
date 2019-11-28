import org.springframework.security.crypto.bcrypt.BCrypt;

import java.sql.*;

public class Encrypt {
    public static void main(String[] args) {
        System.out.println(BCrypt.hashpw("admin",BCrypt.gensalt()));
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/finalproject","root","toor")) {
            PreparedStatement ps = conn.prepareStatement("SELECT users.password FROM users WHERE username = 'admin' ");
            ResultSet rs = ps.executeQuery();
            rs.next();
            System.out.println(BCrypt.checkpw("admin", rs.getString(1)));
            System.out.println(rs.getString(1));
        } catch (SQLException ignored) {
            ignored.printStackTrace();
        }
    }
}
