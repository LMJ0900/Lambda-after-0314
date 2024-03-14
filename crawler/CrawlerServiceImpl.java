package com.turing.api.crawler;

import java.io.IOException;
import java.util.Map;

public class CrawlerServiceImpl implements CrawlerService {
    private static CrawlerServiceImpl instance = new CrawlerServiceImpl();
    private CrawlerRepository repository;
    private CrawlerServiceImpl(){
        repository = CrawlerRepository.getInstance();}

    public static CrawlerServiceImpl getInstance() {
        return instance;
    }


    @Override
    public Map<String, ?> findBugsMusic(Map<String, ?> paramMap) throws IOException {
        return repository.save(paramMap);
    }

    @Override
    public Map<String, ?> findMelonMusic(Map<String, String> paramap) throws IOException {
        return repository.save1(paramap);
    }


}