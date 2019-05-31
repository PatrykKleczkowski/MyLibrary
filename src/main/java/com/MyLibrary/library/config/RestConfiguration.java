package com.MyLibrary.library.config;
import com.MyLibrary.library.model.Author;
import com.MyLibrary.library.model.Book;
import com.MyLibrary.library.model.Hire;
import com.MyLibrary.library.security.model.User;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.mapping.RepositoryDetectionStrategy;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;

@Component
public class RestConfiguration implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.setRepositoryDetectionStrategy(RepositoryDetectionStrategy.RepositoryDetectionStrategies.ANNOTATED);
        config.setBasePath("/api");
        config.exposeIdsFor(User.class);
        config.exposeIdsFor(Book.class);
        config.exposeIdsFor(Author.class);
        config.exposeIdsFor(Hire.class);
    }
}