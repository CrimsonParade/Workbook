package tk.exdeath.controller.student.pages;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tk.exdeath.model.student.pages.LessonList;

@Controller
public class LessonListController {

    final String PATH = "student/pages/lessonList";

    @GetMapping("/lessonList")
    public String getLessons(Model model) {
        model.addAttribute("lessons", LessonList.getLessons());
        return PATH;
    }
}