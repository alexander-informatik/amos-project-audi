package de.osramos.ss13.proj1.security;

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

public class AuthenticationByUserdb extends
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

	
}