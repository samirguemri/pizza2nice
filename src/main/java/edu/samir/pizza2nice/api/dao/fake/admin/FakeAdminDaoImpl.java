package edu.samir.pizza2nice.api.dao.fake.admin;

import edu.samir.pizza2nice.api.dao.fake.FakeDatabaseConnexionImpl;
import edu.samir.pizza2nice.model.Admin;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository("FakeAdminDao")
public class FakeAdminDaoImpl extends FakeDatabaseConnexionImpl implements IAdminDao {

    public FakeAdminDaoImpl(){
        super();
        connectToDatabase();
    }

    @Override
    public Admin isAdmin(String login, String password) {
        Iterator<Admin> adminIterator = adminTable.values().iterator();
        while (adminIterator.hasNext()) {
            Admin admin = adminIterator.next();
            if(admin.getLogin().equals(login) && admin.getPassword().equals(password))
                return admin;
        }
        return null;
    }

    @Override
    public void insertNewAdmin(Admin newAdmin) {
        String idName = newAdmin.getFirstName().concat(newAdmin.getLastName());
        adminTable.put(idName,newAdmin);
    }

    @Override
    public Admin selectAdminById(String idName) { return adminTable.get(idName); }

    @Override
    public void updateAdminLoginById(String idName, String newLogin) {
        Admin admin = adminTable.get(idName);
        admin.setLogin(newLogin);
        insertNewAdmin(admin);
    }

    @Override
    public void updateAdminPasswordById(String idName, String newPassword) {
        Admin admin = adminTable.get(idName);
        admin.setPassword(newPassword);
        insertNewAdmin(admin);
    }

    @Override
    public void deleteAdmin(String idName) { adminTable.remove(idName); }

    @Override
    public List<Admin> selectAllAdmins() {
        return new ArrayList<>(adminTable.values());
    }
}
