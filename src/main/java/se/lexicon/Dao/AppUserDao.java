package se.lexicon.Dao;

import se.lexicon.model.AppUser;

import java.util.Collection;

public interface AppUserDao {
    AppUser persist(AppUser appUser);
    AppUser findByUsername(String username);
    Collection<AppUser> findAll();
    void remove(String username);
}
