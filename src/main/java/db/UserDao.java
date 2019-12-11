package db;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class UserDao {
    private SessionFactory sf;

    public UserDao(SessionFactory sf) {
        this.sf = sf;
    }

    public boolean login(User user) throws NullPointerException {
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            User storedUser = (User) session.createQuery("from users where username = :username").setParameter("username",
                    user.getUsername()).uniqueResult();
            session.getTransaction().commit();
            return BCrypt.checkpw(user.getPass(), storedUser.getPass());
        }
    }

    public boolean register(User user) {
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            User hashedUser = new User();
            hashedUser.setUsername(user.getUsername());
            hashedUser.setPass(BCrypt.hashpw(user.getPass(), BCrypt.gensalt()));
            session.save(hashedUser);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
