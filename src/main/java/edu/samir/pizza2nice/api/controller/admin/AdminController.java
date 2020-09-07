package edu.samir.pizza2nice.api.controller.admin;

import edu.samir.pizza2nice.api.service.admin.AdminServiceImpl;
import edu.samir.pizza2nice.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("AdminController")
@RequestMapping("/pizza2nice/administrator")
public class AdminController {

    private final AdminServiceImpl adminService;

    @Autowired
    public AdminController(@Qualifier("AdminService") AdminServiceImpl adminService) {
        this.adminService = adminService;
    }

    @GetMapping(
            name = "isAdmin",
            path = "{login}/{password}"
    )
    public Admin isAdmin(@PathVariable("login") String login,@PathVariable("password") String password) {
        return adminService.isAdmin(login,password);
    }

    @PostMapping(
            name = "addNewAdmin",
            path = "/add",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public void addNewAdmin(@RequestBody Admin newAdmin){
        adminService.addNewAdmin(newAdmin);
    }

    @GetMapping(
            name = "getAdmins",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Admin> getAdmins(){
        return adminService.getAdmins();
    }

    @GetMapping(
            name = "getAdminById",
            path = "{idName}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Admin getAdminById(@PathVariable("idName") String idName){
        return adminService.getAdminById(idName);
    }

    @PutMapping(
            name = "updateAdminLoginById",
            path = "/update/login/{idName}",
            consumes = MediaType.APPLICATION_JSON_VALUE

    )
    public void updateAdminLoginById(@PathVariable("idName") String idName, @RequestBody String newLogin){
        adminService.updateAdminLoginById(idName,newLogin);
    }

    @PutMapping(
            name = "updateAdminPasswordById",
            path = "/update/password/{idName}",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public void updateAdminPasswordById(@PathVariable("idName") String idName, @RequestBody String newPassword){
        adminService.updateAdminPasswordById(idName,newPassword);
    }

    @DeleteMapping(
            name = "deleteAdmin",
            path = "/delete/{idName}"
    )
    public void deleteAdmin(@PathVariable("idName") String idName){
        adminService.deleteAdmin(idName);
    }
}
