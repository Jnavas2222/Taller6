package edu.unbosque.Taler6.services;

import edu.unbosque.Taler6.jpa.entities.UserApp;
import edu.unbosque.Taler6.jpa.repositories.UserAppRepository;
import edu.unbosque.Taler6.jpa.repositories.UserAppRepositoryImpl;
import edu.unbosque.Taler6.resources.pojos.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;

@Stateless
public class UserAppService {

    UserAppRepository userAppRepository;

    public Optional<String> validateUser( String username, String password ) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Getting credentials from the database
        userAppRepository = new UserAppRepositoryImpl(entityManager);
        Optional<UserApp> user = userAppRepository.findByUsername(username);

        entityManager.close();
        entityManagerFactory.close();

        // Validating if credentials provided by the user are valid
        // If success, return the user role
        if (user.isPresent()) {
            if (user.get().getUsername().equals(username) && user.get().getPassword().equals(password)) {
                return Optional.of(user.get().getRole());
            }
        }

        return Optional.empty();

    }

    public Optional<User> createUser(User user) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        userAppRepository = new UserAppRepositoryImpl(entityManager);

        UserApp userApp = new UserApp(user.getUsername(), user.getPassword(), user.getEmail(), user.getRole());
        Optional<UserApp> persistedUserApp = userAppRepository.save(userApp);

        entityManager.close();
        entityManagerFactory.close();

        if (persistedUserApp.isPresent()) {
            return Optional.of(new User(persistedUserApp.get().getUsername(),
                    persistedUserApp.get().getPassword(),
                    persistedUserApp.get().getEmail(),
                    persistedUserApp.get().getRole()));
        } else {
            return Optional.empty();
        }

    }

}
