package tk.exdeath.model.teacher.account;

import tk.exdeath.model.database.entities.Teacher;
import tk.exdeath.model.database.service.TeacherService;

public abstract class LoggedTeacher {

    private static final TeacherService teacherService = new TeacherService();
    private static Teacher teacher;
    private static String login;

    public static TeacherService getTeacherService() {
        return teacherService;
    }

    public static Teacher getTeacher() {
        return teacher;
    }

    public static void setTeacher(Teacher teacher) {
        LoggedTeacher.teacher = teacher;
    }

    public static String getLogin() {
        return login;
    }

    public static void setLogin(String login) {
        LoggedTeacher.login = login;
    }

    public static void update() {
        teacherService.update(teacher);
    }
}