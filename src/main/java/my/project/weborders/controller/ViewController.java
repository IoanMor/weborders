package my.project.weborders.controller;

import my.project.weborders.dto.RequestFormDTO;
import my.project.weborders.repository.RequestFormRepository;
import my.project.weborders.util.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller()
@RequestMapping("/view/services")
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
    public String request() {
        return "newRequest";
    }

    @GetMapping("/privacy")
    public String privacy() {
        return "privacy";
    }

    @PostMapping("/request/new/add")
    public String addRequest(@RequestParam String name, @RequestParam String tNumber, @RequestParam String description, RedirectAttributes redirectAttributes) {
        System.out.println(">>> ЗАПРОС ПОЛУЧЕН: " + name + " / " + tNumber);
        formRepository.save(Mapper.formDTOtoEntity(new RequestFormDTO(name,tNumber,description)));
        redirectAttributes.addFlashAttribute("success", "Заявка успешно отправлена!");
        return "redirect:/view/services/request/new";
    }


}
