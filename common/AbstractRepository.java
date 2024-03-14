package com.turing.api.common;

import java.io.IOException;
import java.util.Map;

public abstract class AbstractRepository {
    public abstract Map<String, ?> save(Map<String, ?> paraMap) throws IOException;

    public abstract Map<String, ?> save1(Map<String, ?> paraMap) throws IOException;

}

