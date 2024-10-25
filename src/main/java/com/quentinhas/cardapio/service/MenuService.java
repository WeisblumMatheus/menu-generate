package com.quentinhas.cardapio.service;

import com.quentinhas.cardapio.model.MenuItem;
import com.itextpdf.html2pdf.HtmlConverter;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import jakarta.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class MenuService {

    private final SpringTemplateEngine templateEngine;

    public MenuService(SpringTemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public void generateMenuPdf(List<MenuItem> menuItems, HttpServletResponse response) throws IOException {
        Context context = new Context();
        context.setVariable("foodItems", menuItems);

        String htmlContent = templateEngine.process("menu-template", context);

        ByteArrayOutputStream pdfStream = new ByteArrayOutputStream();
        HtmlConverter.convertToPdf(new ByteArrayInputStream(htmlContent.getBytes()), pdfStream);

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=cardapio.pdf");
        response.getOutputStream().write(pdfStream.toByteArray());
        response.getOutputStream().flush();
    }
}