package my.project.weborders.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import my.project.weborders.dto.RequestFormDTO;
import my.project.weborders.repository.RequestFormRepository;
import my.project.weborders.util.Mapper;
import my.project.weborders.util.SpamProtection;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller()
@RequestMapping("/view/services")
@Slf4j
public class ViewController {

    private final RequestFormRepository formRepository;

    public ViewController(RequestFormRepository formRepository) {
        this.formRepository = formRepository;
    }

    @GetMapping("")
    public String controller() {
        return "view";
    }

    @GetMapping("/request/new")
    public String request(Model model) {
        model.addAttribute("requestFormDTO", new RequestFormDTO());
        return "newRequest";
    }

    @GetMapping("/privacy")
    public String privacy() {
        return "privacy";
    }

    @PostMapping("/request/new/add")
    public String addRequest(@ModelAttribute @Valid RequestFormDTO dtoForm, BindingResult bindingResult, RedirectAttributes redirectAttributes, HttpServletRequest servletRequest) {

       if (bindingResult.hasErrors()){
           return "newRequest";
       }

       if (!SpamProtection.submitRequest(servletRequest)){
            redirectAttributes.addFlashAttribute("ERROR", "Слишком много заявок. Попробуй позже.");
            return "redirect:/view/services/request/new";
        }


        log.info(">>> ЗАПРОС ПОЛУЧЕН: {}, {}", dtoForm.getName(), dtoForm.getTNumber());
        formRepository.save(Mapper.formDTOtoEntity(dtoForm));
        redirectAttributes.addFlashAttribute("success", "Заявка успешно отправлена!");
        return "redirect:/view/services/request/new";
    }


}