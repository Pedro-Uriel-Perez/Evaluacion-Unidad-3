package mx.utng.pupm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import mx.utng.pupm.model.entity.User;
import mx.utng.pupm.model.service.IUserService;


@Controller
@SessionAttributes("user")
public class UserController {
    
    @Autowired
    private IUserService service;

    @GetMapping({"", "/", "/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Usuarios");
        model.addAttribute("users", service.list());
        return "list";
    }

    @GetMapping("/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de Usuarios");
        model.addAttribute("user", new User());
        return "form";
    }

    @PostMapping("/form")
    public String save(@Valid User user, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de Usuarios");
            model.addAttribute("error", "Por favor, corrija los errores en el formulario.");
            return "form";
        }
        service.save(user);
        return "redirect:list";
    }

    @GetMapping("/form/{id}")
    public String update(@PathVariable Long id, Model model){
        User user = null;
        if(id>0){
            user = service.getById(id);
        }else{
            return "redirect:list";
        }
        model.addAttribute("title", "Editar Usuario");
        model.addAttribute("user", user);
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id > 0){
            service.delete(id);
        }
        return "redirect:/list";
    }



}
