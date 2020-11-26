package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.UserModel;

public interface UserService {
    UserModel addUser(UserModel user);
    String encrypt(String password);

    UserModel findUserbyUsername(String username);

    boolean isMatch(String newPassword, String oldPassword);

    void setPassword(UserModel myUser, String newPassword);
}