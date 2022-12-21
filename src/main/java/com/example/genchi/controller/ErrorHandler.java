package com.example.genchi.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorHandler implements ErrorController {
    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error() {
        return "" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>404 - resource not found</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<h2>404 - Resource not found</h2>\n" +
                "\n" +
                "<p>\n" +
                "    The requested resource was not found;\n" +
                "</p>\n" +
                "";
    }


}
