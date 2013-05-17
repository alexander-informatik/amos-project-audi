package de.osramos.ss13.proj1.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Taskdb {

    @NotNull
    private String taskname;

    @NotNull
    private String person;

    @NotNull
    private String personfunction;

    @NotNull
    private String building;

    @NotNull
    private String roomno;

    @ManyToOne
    private Userdb trainee;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Taskdbgps> taskdbgps = new HashSet<Taskdbgps>();
}
