package alpha.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserForm {

    private Long id;
    @Pattern(regexp = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$" , message = "Email not valid")
    private String email;
    @Size(min = 8, max = 10)
    private String password;
    @Size(min = 8, max = 10)
    private String rePassword;

    public UserForm() {
    }

    public UserForm(Long id, @Pattern(regexp = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$", message = "Email not valid") String email, @Size(min = 8, max = 10) String password, @Size(min = 8, max = 10) String rePassword) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.rePassword = rePassword;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }
}
