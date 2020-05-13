package pl.dabrowski.partyOrganizer.service;


import pl.dabrowski.partyOrganizer.model.User;

public interface UserService {

    public User findUserByEmail(String email);

    public void saveUser(User user);
}
