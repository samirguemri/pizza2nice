package edu.samir.pizza2nice.api.service.admin;

import edu.samir.pizza2nice.model.Admin;

import java.util.List;

public interface IAdminService {
    Admin isAdmin(String login, String password);
    void addNewAdmin(Admin newAdmin);
    Admin getAdminById(String idName);
    void updateAdminLoginById(String idName, String newLogin);
    void updateAdminPasswordById(String idName, String newPassword);
    void deleteAdmin(String idName);
    List<Admin> getAdmins();
}
