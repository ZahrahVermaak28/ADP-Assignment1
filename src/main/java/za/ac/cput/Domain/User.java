package za.ac.cput.Domain;

/**
 * @author Zahrah Vermaak 221406395
 */

public class User {

    private String userID;
    private String name;
    private String surname;
    private String email;
    private String password;

    public User() {
    }

    private User(Builder builder) {
        this.userID = builder.userID;
        this.name = builder.name;
        this.surname = builder.surname;
        this.email = builder.email;
        this.password = builder.password;
    }

    public String getUserID() {
        return userID;
    }
    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }

    public String getFullName() {
        return "Name: " + name + " " + "Surname: " + surname;
    }

    public static class Builder {
        private String userID;
        private String name;
        private String surname;
        private String email;
        private String password;

        public Builder setUserId(String userId) {
            this.userID = userId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }
        public Builder setPassword(String password){
            this.password = password;
            return this;
        }

        public User build() {
            return new User(this);
        }


    }

    @Override
    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
