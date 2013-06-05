package de.osramos.ss13.proj1.security;

/*
 * #%L
 * proj1
 * %%
 * Copyright (C) 2013 Amos-Project
 * %%
 * Copyright (c) 2013 by Alexander Schmidt, Sascha Ströbel, Nina Aures, Riehle, http://dirkriehle.com
 * -
 * This file is part of the Amos Project - Productive Games application.
 * -
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * -
 * This program is distributed in the hope that it will be useful, 
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * -
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 * #L%
 */

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.persistence.NonUniqueResultException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import de.osramos.ss13.proj1.model.Userdb;

public class AuthenticationByUserdb
		extends
			AbstractUserDetailsAuthenticationProvider {

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		// TODO Auto-generated method stub

	}

	@Override
	protected UserDetails retrieveUser(String username,
			UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		// populate with default usernames and passwords
		CreateUsers();

		String password = (String) authentication.getCredentials();
		if (!StringUtils.hasText(password)) {
			throw new BadCredentialsException("Please enter password");
		}
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		try {
			Userdb user = Userdb.findUserdbsByUsernameAndPasswordEquals(
					username, password).getSingleResult();

			if (user.getUserrole().equals("admin")) {
				authorities.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
			}
			if (user.getUserrole().equals("senior")) {
				authorities.add(new GrantedAuthorityImpl("ROLE_SENIOR"));
			}
			if (user.getUserrole().equals("trainee")) {
				authorities.add(new GrantedAuthorityImpl("ROLE_TRAINEE"));
			}

		} catch (EmptyResultDataAccessException e) {
			throw new BadCredentialsException("Invalid username or password");
		} catch (EntityNotFoundException e) {
			throw new BadCredentialsException("Invalid user");
		} catch (NonUniqueResultException e) {
			throw new BadCredentialsException(
					"Non-unique user, contact administrator");
		}
		return new User(username, password, true, // enabled
				true, // account not expired
				true, // credentials not expired
				true, // account not locked
				authorities);
	}

	private void CreateUsers() {
		Userdb user = null;

		try {
			user = null;
			user = Userdb.findUserdbsByUsernameEquals("admin")
					.getSingleResult();
		} catch (Exception e) {
		} finally {
			try {
				if (null == user) {
					user = new Userdb();
					user.setFirstname("admin");
					user.setLastname("ADMIN");
					user.setUsername("admin");
					user.setUserrole("admin");
					user.setPassword("admin");
					user.persist();
				}
			} catch (Exception e) {
			}
		}

		try {
			user = null;
			user = Userdb.findUserdbsByUsernameEquals("senior")
					.getSingleResult();
		} catch (Exception e) {
		} finally {
			try {
				if (null == user) {
					user = new Userdb();
					user.setFirstname("senior");
					user.setLastname("SENIOR");
					user.setUsername("senior");
					user.setUserrole("senior");
					user.setPassword("senior");
					user.persist();
				}
			} catch (Exception e) {
			}
		}

		try {
			user = null;
			user = Userdb.findUserdbsByUsernameEquals("trainee")
					.getSingleResult();
		} catch (Exception e) {
		} finally {
			try {
				if (null == user) {
					user = null;
					user = new Userdb();
					user.setFirstname("trainee");
					user.setLastname("TRAINEE");
					user.setUsername("trainee");
					user.setUserrole("trainee");
					user.setPassword("trainee");
					user.persist();
				}
			} catch (Exception e) {
			}
		}

	}
}