/*
 * Copyright (c) 2013 by Dirk Riehle, http://dirkriehle.com
 *
 * This file is part of the Amos SS13 Project - Productive Games Development (PGA) rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 * 
 * Software Developers in alphabetical order:
 * Nina Aures
 * Alexander Schmidt
 * Sascha Stroebel
 */

/*
 CREATE TABLE taskdbgpsentry
 (
 id bigint NOT NULL,
 fid_taskdb bigint NOT NULL,
 position bigint NOT NULL,
 gpscoordinate character varying,
 CONSTRAINT taskdb__gpsentry_pk_id PRIMARY KEY (id)
 )
 */

package de.osramos.ss13.Model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import java.io.Serializable;

@Table(name = "taskdbgpsentry")
@Entity
public class Taskdb__GpsEntry implements Serializable {
	private static final long serialVersionUID = 7633330776549817123L;

	Long id;
	Long fid_taskdb;
	String position;
	String gpscoordinate;

	public Taskdb__GpsEntry() {
	}

	@Id
	@SequenceGenerator(name = "taskdbgpsentry_sequence", sequenceName = "taskdbgpsentry_id_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "taskdbgpsentry_sequence")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFid_TaskDB() {
		return fid_taskdb;
	}

	public void setFid_TaskDB(Long fid_TaskDB) {
		this.fid_taskdb = fid_TaskDB;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getGpscoordinate() {
		return gpscoordinate;
	}

	public void setGpscoordinate(String gpscoordinate) {
		this.gpscoordinate = gpscoordinate;
	}

}
