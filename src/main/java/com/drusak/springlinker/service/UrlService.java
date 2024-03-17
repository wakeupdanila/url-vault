package com.drusak.springlinker.service;

import com.drusak.springlinker.model.Url;
import com.drusak.springlinker.repository.UrlRepository;
import org.springframework.stereotype.Service;

@Service
public class UrlService {

    private final UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public Url saveUrl(String url) {
        Url newUrl = new Url();
        newUrl.setUrl(url);
        return urlRepository.save(newUrl);
    }

    public Url getUrlById(Long id) {
        return urlRepository.findById(id).orElse(null);
    }
}
