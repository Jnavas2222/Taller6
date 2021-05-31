package edu.unbosque.Taler6.jpa.repositories;

import edu.unbosque.Taler6.jpa.entities.UserApp;

import java.util.Optional;

public interface UserAppRepository {

    Optional<UserApp> findByUsername(String username);

    Optional<UserApp> save(UserApp user);
}
