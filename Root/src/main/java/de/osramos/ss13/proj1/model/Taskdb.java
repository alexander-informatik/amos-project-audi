package de.osramos.ss13.proj1.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findTaskdbsByTrainee", "findTaskdbsById", "findTaskdbsByPersonEquals" })
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

    @Pattern(regexp = "(-+)?\\d+\\.\\d+,(-+)?\\d+\\.\\d+", message = "Please enter GPS Coordinates in Google Format: two floating point numbers seperated by a comma for longitude and latitude")
    private String gps_Start;

    @Pattern(regexp = "^$|(-+)?\\d+\\.\\d+,(-+)?\\d+\\.\\d+", message = "Please enter GPS Coordinates in Google Format: two floating point numbers seperated by a comma for longitude and latitude")
    private String gps_1;

    @Pattern(regexp = "^$|(-+)?\\d+\\.\\d+,(-+)?\\d+\\.\\d+", message = "Please enter GPS Coordinates in Google Format: two floating point numbers seperated by a comma for longitude and latitude")
    private String gps_2;

    @Pattern(regexp = "^$|(-+)?\\d+\\.\\d+,(-+)?\\d+\\.\\d+", message = "Please enter GPS Coordinates in Google Format: two floating point numbers seperated by a comma for longitude and latitude")
    private String gps_3;

    @Pattern(regexp = "^$|(-+)?\\d+\\.\\d+,(-+)?\\d+\\.\\d+", message = "Please enter GPS Coordinates in Google Format: two floating point numbers seperated by a comma for longitude and latitude")
    private String gps_4;

    @Pattern(regexp = "^$|(-+)?\\d+\\.\\d+,(-+)?\\d+\\.\\d+", message = "Please enter GPS Coordinates in Google Format: two floating point numbers seperated by a comma for longitude and latitude")
    private String gps_5;

    @Pattern(regexp = "^$|(-+)?\\d+\\.\\d+,(-+)?\\d+\\.\\d+", message = "Please enter GPS Coordinates in Google Format: two floating point numbers seperated by a comma for longitude and latitude")
    private String gps_6;

    @Pattern(regexp = "^$|(-+)?\\d+\\.\\d+,(-+)?\\d+\\.\\d+", message = "Please enter GPS Coordinates in Google Format: two floating point numbers seperated by a comma for longitude and latitude")
    private String gps_7;

    @Pattern(regexp = "^$|(-+)?\\d+\\.\\d+,(-+)?\\d+\\.\\d+", message = "Please enter GPS Coordinates in Google Format: two floating point numbers seperated by a comma for longitude and latitude")
    private String gps_8;

    @Pattern(regexp = "^$|(-+)?\\d+\\.\\d+,(-+)?\\d+\\.\\d+", message = "Please enter GPS Coordinates in Google Format: two floating point numbers seperated by a comma for longitude and latitude")
    private String gps_9;

    @Pattern(regexp = "^$|(-+)?\\d+\\.\\d+,(-+)?\\d+\\.\\d+", message = "Please enter GPS Coordinates in Google Format: two floating point numbers seperated by a comma for longitude and latitude")
    private String gps_10;

    @Pattern(regexp = "^$|(-+)?\\d+\\.\\d+,(-+)?\\d+\\.\\d+", message = "Please enter GPS Coordinates in Google Format: two floating point numbers seperated by a comma for longitude and latitude")
    private String gps_11;

    @Pattern(regexp = "^$|(-+)?\\d+\\.\\d+,(-+)?\\d+\\.\\d+", message = "Please enter GPS Coordinates in Google Format: two floating point numbers seperated by a comma for longitude and latitude")
    private String gps_12;

    @Pattern(regexp = "(-+)?\\d+\\.\\d+,(-+)?\\d+\\.\\d+", message = "Please enter GPS Coordinates in Google Format: two floating point numbers seperated by a comma for longitude and latitude")
    private String gps_End;

    private String completionPassword;
}
