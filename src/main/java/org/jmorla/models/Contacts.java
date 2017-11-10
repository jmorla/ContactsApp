package org.jmorla.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by jmorla on 26/10/2017.
 */
@Entity
public class Contacts {

    @Id
    @Column
    private String id;

    @Column
    @NotNull
    @Size(min = 3,message = "este campo debe contener minimo 3 caracteres")
    private String firstname;

    @Column
    @NotNull
    @Size(min = 3,message = "este campo debe contener minimo 3 caracteres")
    private String lastname;

    @Column
    @NotNull
    @Size(min = 5, message = "este campo debe contener minimo 5 caracteres")
    private String email;

    @Column
    @Size(min = 12,message = "numero de telefono incorrecto, ejemplo (809)-355-2342")
    private String phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
