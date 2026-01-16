package curd.employee.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import curd.employee.entity.Employee;
import curd.employee.service.EmployeeServices;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {
    
    @Autowired
    EmployeeServices service;

    // Redirect to list after creation
    @PostMapping("/create")
    public String createNewEmployee(@ModelAttribute Employee emp) {
        service.createNewEmployee(emp);
        return "redirect:/viewAll";
    }
    
    // Redirect to list after update
    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute Employee emp) {
        service.updateEmployee(emp);
        return "redirect:/viewAll";
    }
    
    @GetMapping("/search")
    public String searchEmployee(@RequestParam("id") Long id, Model model) {
        Employee emp = service.searchEmployee(id);
        model.addAttribute("empObj", emp);
        return "searchResult";
    }
    
    // Page Navigation Mappings
    @GetMapping("/createPage")
    public String createPage() { return "create"; }
    
    @GetMapping("/updatePage")
    public String updatePage() { return "update"; }
    
    @GetMapping("/deletePage")
    public String deletePage() { return "delete"; }
    
    @GetMapping("/searchPage")
    public String searchEmployeePage() { return "search"; }
    
    // The fixed Delete logic matching your POST form
    
    @GetMapping("/viewAll")
    public String viewAllEmployees(Model model) {
        List<Employee> employeesList = service.getAllEmployees();
        model.addAttribute("employees", employeesList);
        return "viewAll"; 
    }

    @GetMapping("/about")
    public String showAboutPage() { return "about"; 
    }
    
 // Add this mapping to your controller
    @GetMapping("/homepage")
    public String showHomePage() {
        return "homepage"; // Returns homepage.html
    }

    @RequestMapping(value = "/deleteEmployee", method = {RequestMethod.GET, RequestMethod.POST})
    public String deleteEmployee(@RequestParam("id") Long id) {
        service.deleteEmployee(id);
        return "redirect:/viewAll";
    }
}
