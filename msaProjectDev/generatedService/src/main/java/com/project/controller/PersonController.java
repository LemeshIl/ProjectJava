package com.project.controller;


import com.lowagie.text.DocumentException;
import com.project.PersonPDFExporter;
import com.project.model.Person;
import com.project.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.UUID;

@RestController
public class PersonController {
    @Autowired
    PersonService personService;

    @GetMapping("/generate-agreement/{id}")
    public void exportToPDFOne(HttpServletResponse response, @PathVariable UUID id) throws DocumentException, IOException {
        response.setContentType("application/pdf");

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=creditFile" + ".pdf";
        response.setHeader(headerKey, headerValue);

        Person person = personService.getOne(id);
        if (!person.isAllowed()) {
            response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        } else {
            PersonPDFExporter exporter = new PersonPDFExporter(person);
            exporter.export(response);
        }
    }
}
