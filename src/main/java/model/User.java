package model;

public class User {

    private String username;
    private String password;

    /**
     * Creates an user with populated fields
     * @param username: user's username
     * @param password: user's password
     */
    public User(final String username, final String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Creates a default user
     */
    public User() {
    }

    //username
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    //password
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
