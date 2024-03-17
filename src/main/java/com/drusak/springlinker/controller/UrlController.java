package com.drusak.springlinker.controller;

import com.drusak.springlinker.model.Url;
import com.drusak.springlinker.service.UrlService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @PostMapping("/submitUrl")
    public String handleUrlSubmission(@RequestParam("url") String url, Model model) {
        Url savedUrl = urlService.saveUrl(url);
        model.addAttribute("message", "URL saved with ID: " + savedUrl.getId());
        return "result";
    }

    @GetMapping("/getUrl")
    public String showUrl(@RequestParam("id") Long id, Model model) {
        Url url = urlService.getUrlById(id);
        if (url != null) {
            model.addAttribute("url", "Stored URL: " + url.getUrl());
        } else {
            model.addAttribute("message", "URL not found.");
        }
        return "result";
    }
}


