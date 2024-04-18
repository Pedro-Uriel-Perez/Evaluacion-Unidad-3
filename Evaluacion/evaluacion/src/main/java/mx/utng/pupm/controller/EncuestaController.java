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
import mx.utng.pupm.model.entity.Encuesta;
import mx.utng.pupm.model.service.IEncuestaService;

@Controller
@SessionAttributes("encuesta")
public class EncuestaController {
    
    @Autowired
    private IEncuestaService service;

    @GetMapping({"/encuesta", "/encuesta/", "/encuesta/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Encuestas");
        model.addAttribute("encuestas", service.list());
        return "encuesta-list";
    }

    @GetMapping("/encuesta/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario Encuestas");
        model.addAttribute("encuesta", new Encuesta());
        return "encuesta-form";
    }

    @PostMapping("/encuesta/form")
    public String save(@Valid Encuesta encuesta, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de Encuestas");
            return "encuesta-form";
        }
        service.save(encuesta);
        return "redirect:/encuesta/list";
    }

    @GetMapping("/encuesta/form/{id}")
    public String update(@PathVariable Long id, Model model){
        Encuesta encuesta = null;
        if(id>0){
            encuesta = service.getById(id);
        }else{
            return "redirect:/encuesta/list";
        }
        model.addAttribute("title", "Editar Encuesta");
        model.addAttribute("encuesta", encuesta);
        return "encuesta-form";
    }

    @GetMapping("/encuesta/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id > 0){
            service.delete(id);
        }
        return "redirect:/encuesta/list";
    }



}
