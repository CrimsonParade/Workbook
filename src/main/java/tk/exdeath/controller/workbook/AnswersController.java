package tk.exdeath.controller.workbook;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tk.exdeath.controller.student.LoggedStudent;
import tk.exdeath.model.Student;
import tk.exdeath.model.Task;

@Controller
public class AnswersController {

    @PostMapping("/answers")
    public String answers(
            @RequestParam(required = false, value = "answers[]") String[] answers,
            @RequestParam() String lesson,
            @RequestParam() int grade,
            @RequestParam() int page, Model model) {

        Student student = LoggedStudent.getStudent();
        Task task = new Task(student, lesson, grade, page, answers);
        student.addTask(task);
        LoggedStudent.update();

        model.addAttribute("Error", answers);
        return "errorPage";
    }
}