package com.example.demo.Controller;

import com.example.demo.entity.FormEntity;
import com.example.demo.service.FormService;
import com.example.demo.exception.ValidationException; // Import the custom exception
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FormController {

    @Autowired
    private FormService formService;

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("formEntity", new FormEntity());
        return "form";  // This will map to /WEB-INF/views/form.jsp
    }

    @PostMapping("/submitForm")
    public String submitForm(@ModelAttribute FormEntity formEntity, Model model) {
        try {
            // Validate the form
            formService.validateForm(formEntity);

            // Save the form data
            formService.saveForm(formEntity);

            // Success message
            model.addAttribute("message", "Form submitted successfully!");
            return "Success";  // returns success.jsp
        } catch (ValidationException e) {
            // Handle validation failure
            model.addAttribute("message", "Validation failed: " + e.getMessage());
            return "fail";  // returns the form view with error message
        } catch (Exception e) {
            // Handle other exceptions (like database issues)
            model.addAttribute("message", "Error submitting form: " + e.getMessage());
            return "fail";  // returns the form view with error message
        }
    }
}
