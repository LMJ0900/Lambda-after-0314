package com.turing.api.crawler;

import java.io.IOException;
import java.util.Map;

public interface CrawlerService {
    Map<String, ?> findBugsMusic(Map<String, ?> paramMap)throws IOException ;

    Map<String,?> findMelonMusic(Map<String, String> paramap) throws IOException;
}
