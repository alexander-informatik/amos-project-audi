package de.osramos.ss13.proj1.model;

import java.util.List;
import javax.validation.constraints.NotNull;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.transaction.annotation.Transactional;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findUserdbsByUsernameAndPasswordEquals", "findUserdbsByUsernameEquals", "findUserdbsByUserroleEquals" })
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
