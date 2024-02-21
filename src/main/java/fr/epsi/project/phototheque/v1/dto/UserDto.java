package fr.epsi.project.phototheque.v1.dto;

public class UserDto {

    Long id;
    String lastname;
    String firstname;

    public UserDto(){
        //
    }

    public UserDto(Long id, String firstname, String lastname) {
    }

    public Long getId(){
        return id;
    }
    public String getLastname() {
        return lastname;
    }

    public void setLastname(final String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(final String firstname) {
        this.firstname = firstname;
    }
}
