package edu.samir.pizza2nice.api.dao.fake.admin;

import edu.samir.pizza2nice.model.Admin;

import java.util.List;

public interface IAdminDao {
    Admin isAdmin(String login, String password);
    void insertNewAdmin(Admin newAdmin);
    Admin selectAdminById(String idName);
    void updateAdminLoginById(String idName, String newLogin);
    void updateAdminPasswordById(String idName, String newPassword);
    void deleteAdmin(String idName);
    List<Admin> selectAllAdmins();
}
