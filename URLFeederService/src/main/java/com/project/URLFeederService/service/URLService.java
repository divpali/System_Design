package com.project.URLFeederService.service;

import com.project.URLFeederService.dao.URLRepository;
import com.project.URLFeederService.model.URLEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class URLService {

    @Autowired
    private URLRepository urlRepository;

    public void save(URLEntity urlEntity) {
        urlRepository.save(urlEntity);
    }
}
