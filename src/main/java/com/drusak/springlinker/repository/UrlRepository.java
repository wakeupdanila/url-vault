package com.drusak.springlinker.repository;

import com.drusak.springlinker.model.Url;
import org.springframework.data.repository.CrudRepository;

public interface UrlRepository extends CrudRepository<Url, Long> {
}
