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
import mx.utng.pupm.model.entity.Pedido;
import mx.utng.pupm.model.service.IPedidoService;

@Controller
@SessionAttributes("pedido")
public class PedidoController {
    
    @Autowired
    private IPedidoService service;

    @GetMapping({"/pedido", "/pedido/", "/pedido/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Pedidos");
        model.addAttribute("pedidos", service.list());
        return "pedido-list";
    }

    @GetMapping("/pedido/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de Pedidos");
        model.addAttribute("pedido", new Pedido());
        return "pedido-form";
    }

    @PostMapping("/pedido/form")
    public String save(@Valid Pedido pedido, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de Pedidos");
            return "pedido-form";
        }
        service.save(pedido);
        return "redirect:/pedido/list";
    }

    @GetMapping("/pedido/form/{id}")
    public String update(@PathVariable Long id, Model model){
        Pedido pedido = null;
        if(id>0){
            pedido = service.getById(id);
        }else{
            return "redirect:/pedido/list";
        }
        model.addAttribute("title", "Editar pedido");
        model.addAttribute("pedido", pedido);
        return "pedido-form";
    }

    @GetMapping("/pedido/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id > 0){
            service.delete(id);
        }
        return "redirect:/pedido/list";
    }



}
