package edu.samir.pizza2nice.api.service.admin;

import edu.samir.pizza2nice.api.dao.fake.admin.IAdminDao;
import edu.samir.pizza2nice.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AdminService")
public class AdminServiceImpl implements IAdminService {

    private final IAdminDao adminDao;

    @Autowired
    public AdminServiceImpl(@Qualifier("FakeAdminDao") IAdminDao adminDao) {
        this.adminDao = adminDao;
    }

    @Override
    public Admin isAdmin(String login, String password) {
        return adminDao.isAdmin(login, password);
    }

    @Override
    public void updateAdminLoginById(String idName, String newLogin) { adminDao.updateAdminLoginById(idName,newLogin); }

    @Override
    public void updateAdminPasswordById(String idName, String newPassword) { adminDao.updateAdminPasswordById(idName,newPassword); }

    @Override
    public void addNewAdmin(Admin newAdmin) { adminDao.insertNewAdmin(newAdmin); }

    @Override
    public Admin getAdminById(String idName) { return adminDao.selectAdminById(idName); }

    @Override
    public void deleteAdmin(String idName) {
        adminDao.deleteAdmin(idName);
    }

    @Override
    public List<Admin> getAdmins() {
        return adminDao.selectAllAdmins();
    }
}
