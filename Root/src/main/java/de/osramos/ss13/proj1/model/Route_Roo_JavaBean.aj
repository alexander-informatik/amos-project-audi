// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package de.osramos.ss13.proj1.model;

import de.osramos.ss13.proj1.model.Gpscoordinate;
import de.osramos.ss13.proj1.model.Route;
import java.util.Set;

privileged aspect Route_Roo_JavaBean {
    
    public String Route.getStartpointName() {
        return this.startpointName;
    }
    
    public void Route.setStartpointName(String startpointName) {
        this.startpointName = startpointName;
    }
    
    public String Route.getEndpointName() {
        return this.endpointName;
    }
    
    public void Route.setEndpointName(String endpointName) {
        this.endpointName = endpointName;
    }
    
    public Set<Gpscoordinate> Route.getGpscoordinates() {
        return this.gpscoordinates;
    }
    
    public void Route.setGpscoordinates(Set<Gpscoordinate> gpscoordinates) {
        this.gpscoordinates = gpscoordinates;
    }
    
}