package tk.exdeath.controller.admin.delete;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tk.exdeath.model.admin.delete.DeleteStudent;

@Controller
public class DeleteStudentController {

    final String PATH = "admin/delete/deleteStudent";

    @GetMapping("/deleteStudent")
    public String returnPage(
            @RequestParam(defaultValue = "ERROR") String key, Model model) {
        try {
            DeleteStudent.keyCheck(key);
            return PATH;
        } catch (RuntimeException ex) {
            model.addAttribute("Error", ex.getMessage());
            return "errorPage";
        }
    }

    @PostMapping("/deleteStudent")
    public String deleteStudent(
            @RequestParam(defaultValue = "null") String login, Model model) {
        try {
            DeleteStudent.deleteStudent(login);
            model.addAttribute("Message", login + " успешно удален");
            return PATH;
        } catch (RuntimeException ex) {
            model.addAttribute("Message", ex.getMessage());
            return PATH;
        }
    }
}