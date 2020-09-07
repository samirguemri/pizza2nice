package edu.samir.pizza2nice.views.controller;

import edu.samir.pizza2nice.api.service.admin.IAdminService;
import edu.samir.pizza2nice.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminViewController {

    private IAdminService adminService;
    private HttpServletRequest request;
    private Admin adminConnected;

    @Autowired
    public AdminViewController(@Qualifier("AdminService") IAdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/pizza2nice/admin/addAdmin")
    public String addAdmin()
    {
        return "admin/addAdmin";
    }

    @GetMapping("/pizza2nice/admin/updateLogin")
    public String updateLogin()
    {
        return "admin/updateLogin";
    }

    @GetMapping("/pizza2nice/admin/updatePassword")
    public String updatePassword()
    {
        return "admin/updatePassword";
    }

    @GetMapping("/pizza2nice/admin/deleteAdmin")
    public String deleteAdmin()
    {
        return "admin/deleteAdmin";
    }


    @PostMapping("/pizza2nice/helloAdmin")
    public String isAdmin(HttpServletRequest request, Model model) {

        // firstConnection
        if(request.getParameter("loginConnection") != null){

            String login = request.getParameter("loginConnection");
            String password = request.getParameter("pwdConnection");

            adminConnected = adminService.isAdmin(login,password);
            if(adminConnected == null)
                return "home";
            return "admin/admin";
        }

        // updateLogin
        if (request.getParameter("newLogin") != null){
            String idName = adminConnected.getFirstName().concat(adminConnected.getLastName());
            String newLogin = request.getParameter("newLogin");
            adminService.updateAdminLoginById(idName,newLogin);
            return "admin/admin";
        }

        // updatePassword
        if (request.getParameter("newPassword") != null){
            String idName = adminConnected.getFirstName().concat(adminConnected.getLastName());
            String newPassword = request.getParameter("newPassword");
            adminService.updateAdminPasswordById(idName,newPassword);
            return "admin/admin";
        }

        // deleteAdmin
        if (request.getParameter("idAdminToDelete") != null){
            String idAdminToDelete = request.getParameter("idAdminToDelete");
            adminService.deleteAdmin(idAdminToDelete);
            return "admin/admin";
        }

        // addAdmin
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        String zipCode = request.getParameter("zipCode");
        String login = request.getParameter("login");
        String password = request.getParameter("pwd");

        adminService.addNewAdmin(new Admin(firstName,lastName,address,zipCode,login,password));

        return "admin/admin";
    }

}
