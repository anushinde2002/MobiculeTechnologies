public class User {
    private String uname;
    private String pass;

    public User(String uname,String pass)
    {
        this.uname=uname;
        this.pass=pass;

    }
    public boolean login(String uname,String pass) {
        return this.uname.equals(uname)&&this.pass.equals(pass);
    }

}