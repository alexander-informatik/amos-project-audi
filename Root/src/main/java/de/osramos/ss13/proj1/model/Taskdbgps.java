package de.osramos.ss13.proj1.model;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Taskdbgps {

    @NotNull
    private String gpscoordinate;

    private Long pos;

    @ManyToOne
    private Taskdb task;
}
