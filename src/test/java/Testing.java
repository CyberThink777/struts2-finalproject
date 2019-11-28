import java.io.Serializable;

class User implements Serializable {
    private String username,pass;

/*    public User(){
        new User("","");
    }*/

    public User(){}
    public User(String username, String pass) {
        this.username = username;
        this.pass = pass;
    }

    public String getUsername() {
        return username;
    }

    public String getPass() {
        return pass;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}

public class Testing {
    public static void main(String[] args) {
        User test = new User();
        test.setUsername("test");
        System.out.println(test.getUsername());
    }
}