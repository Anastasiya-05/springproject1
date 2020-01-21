package by.minenkova.springprogect1.form;

import by.minenkova.springprogect1.validator.CellPhone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PersonForm {
    @NotNull(message ="{valid.name.notNull}")
    @Size(min=3, message ="{valid.firstname.size.min3}")
    private String firstName;
    @NotBlank(message ="{valid.lastname.notBlank}")
    private String lastName;
    @NotBlank(message = "{valid.street.notBlank}")
    private String street;
    @NotBlank(message = "{valid.city.notBlank}")
    private String city;
    @Digits(integer=6, fraction= 0, message= "{valid.zip.digits}")
    private String zip;
    @NotBlank(message ="{valid.email.notBlank}")
    @Email(message = "{valid.email.email}")
    private String email;
// @Pattern(regexp="^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$",message="Must be formatted DD/MM/YYYY")
// private String birthday;
//ISO 8601 date format (yyyy-MM-dd)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Past(message = "{valid.birthday.past}")
    private String birthday;
    @CellPhone(message = "{valid.phone.cellphone}")
    private String phone;
/*public class PersonForm {
    @NotBlank(message = "Name is required")
    @Size(min = 3, message = "Name must be at least 3 characters long")
    private String firstName;
    @NotBlank(message = "LastName is required")
    private String lastName;
    @NotBlank(message = "Street is required")
    private String street;
    @NotBlank(message = "City is required")
    private String city;
    @Pattern(regexp = "\\d{6}", message = "Invalid zip code")
    private String zip;
    @NotNull
    @Pattern(regexp = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$", message = "Invalid email")
    private String email;
    @Pattern(regexp = "^((3[01]|[12][0-9]|0[1-9]).1[0-2]|0[1-9]).[0-9]{4}$", message = "Must be formatted DD.MM.YYYY")
    private String birthday;
    @CellPhone(message = "Must be formatted +375XXXXXXXXX")
    private String phone;*/

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
