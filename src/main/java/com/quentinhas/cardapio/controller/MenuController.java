package com.quentinhas.cardapio.controller;

import com.quentinhas.cardapio.model.MenuItem;
import com.quentinhas.cardapio.service.MenuService;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/menu")
public class MenuController {

    private final List<MenuItem> menuItem = new ArrayList<>();
    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/gerar-cardapio")
    public ModelAndView showForms() {
        return new ModelAndView("gerar_tela");
    }

    @PostMapping
    public void createMenu(@RequestBody List<MenuItem> menu, HttpServletResponse response) throws IOException {
        menuItem.clear();
        menuItem.addAll(menu);

        menuService.generateMenuPdf(menuItem, response);
    }
}
