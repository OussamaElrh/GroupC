package org.mql.platform.business.users;

import org.mql.platform.models.User;

/**
 * 
 * Service responsible for authentication
 * 
 * @author mehdithe
 *
 */
public interface AuthenticationService {

  /**
   * login the user defined by the username and password
   * 
   * @param username email/username of the User
   * @param password password of the given user, cannot be null
   * @return the corresponding user, or null if the login is not successful
   */
  User login(String username, String password);
}
