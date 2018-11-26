package org.mql.platform.business.users.impl;

import org.mql.platform.business.users.AuthenticationService;
import org.mql.platform.models.User;
import org.springframework.stereotype.Service;

@Service
public class DefaultAuthenticationService implements AuthenticationService {

  @Override
  public User login(String username, String password) {
    
    return null;
  }
}
