package ua.ponarin.triviausers.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import ua.ponarin.triviausers.dto.User;

@Configuration
public class RepositoryRestConfig {
    @Bean
    public RepositoryRestConfigurer repositoryRestConfigurer()
    {
        return RepositoryRestConfigurer.withConfig(config -> config.exposeIdsFor(User.class));
    }
}
