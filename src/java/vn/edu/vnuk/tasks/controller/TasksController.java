/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.vnuk.tasks.controller;

import java.sql.SQLException;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;
import vn.edu.vnuk.tasks.dao.TaskDao;
import vn.edu.vnuk.tasks.model.Task;

/**
 *
 * @author Admin
 */
@Controller
public class TasksController {
    
    @RequestMapping("/addTask")
    public String add(){
        return "task/add";
    }
    
    @RequestMapping("createTask")
    public String create(@Valid Task task, BindingResult result) throws SQLException{
        
        if (result.hasFieldErrors("description")) {
            return "task/add";
        }
        
        new TaskDao().create(task);
        return "task/added";
    }
    
    @RequestMapping("tasks")
    public String read(Model model) throws SQLException{
        model.addAttribute("tasks", new TaskDao().read());
        return "task/index";
    }
    
    @RequestMapping(value = "deleteTask/{id}", method = RequestMethod.GET)
    @ResponseBody 
    public RedirectView delete(@PathVariable("id") int id) throws SQLException{
        new TaskDao().delete(id);
        return new RedirectView("../tasks");
    }
    
     @RequestMapping("editTask")
    public String edit(@RequestParam Map<String, String> taskId, Model model) throws SQLException{
        int id = Integer.parseInt(taskId.get("id").toString());
        model.addAttribute("task", new TaskDao().read(id));
        return "task/edit";
    }
}
