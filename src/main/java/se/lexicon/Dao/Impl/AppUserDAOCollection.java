package se.lexicon.Dao.Impl;

import se.lexicon.Dao.AppUserDao;
import se.lexicon.model.AppUser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AppUserDAOCollection implements AppUserDao {
    private final List<AppUser> users = new ArrayList<>();

    @Override
    public AppUser persist(AppUser appUser) {
        if (appUser == null) {
            throw new IllegalArgumentException("AppUser cannot be null");
        }
        // Check if user already exists
        for (AppUser user : users) {
            if (user.getUsername().equals(appUser.getUsername())) {
                throw new IllegalArgumentException("Username already exists");
            }
        }
        users.add(appUser);
        return appUser;
    }

    @Override
    public AppUser findByUsername(String username) {
        for (AppUser user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null; // or throw an exception if preferred
    }

    @Override
    public Collection<AppUser> findAll() {
        return new ArrayList<>(users);
    }

    @Override
    public void remove(String username) {
        users.removeIf(user -> user.getUsername().equals(username));
    }
}