package tk.exdeath.controller.teacher;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountTeacherController {

    final String PATH = "teacher/accountTeacher";

    @GetMapping("/accountTeacher")
    public String accountTeacher(Model model) {
        model.addAttribute("Name", LoggedTeacher.getTeacher().getFirstName());
        return PATH;
    }
}