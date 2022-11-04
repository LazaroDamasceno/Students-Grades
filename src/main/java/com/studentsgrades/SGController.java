package com.studentsgrades;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SGController {

    List<StudentGrade> grades = new ArrayList<>();

    @GetMapping("/")
    public String getForm(Model model) {
        model.addAttribute("grades", new StudentGrade());
        return "form";
    }

    @GetMapping("/table")
    public String getTable(Model model) {
        model.addAttribute("grades", grades);
        return "table";
    }

    @PostMapping("/submitData")
    public String submitData(StudentGrade sg) {
        grades.add(sg);
        return "redirect:/table";
    }

}
