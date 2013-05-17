package de.osramos.ss13.proj1.model;

import javax.validation.constraints.NotNull;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Userdb {

    @NotNull
    private String firstname;

    @NotNull
    private String lastname;

    @NotNull
    private String userrole;

    @NotNull
    private String username;

    @NotNull
    private String password;
}
