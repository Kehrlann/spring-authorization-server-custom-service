package wf.garnier.demo.authorizationserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.server.authorization.InMemoryOAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.OAuth2Authorization;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.OAuth2TokenType;

@SpringBootApplication
public class AuthorizationserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthorizationserverApplication.class, args);
    }


    @Bean
    OAuth2AuthorizationService authorizationService() {
        return new MyAuthService();
    }

    static class MyAuthService implements OAuth2AuthorizationService {
        private final OAuth2AuthorizationService delegate = new InMemoryOAuth2AuthorizationService();

        @Override
        public void save(OAuth2Authorization authorization) {
            System.out.println("~~~~~~~~~~ CALLING SAVE ~~~~~~~~~~~~");
            delegate.save(authorization);
        }

        @Override
        public void remove(OAuth2Authorization authorization) {
            delegate.remove(authorization);
        }

        @Override
        public OAuth2Authorization findById(String id) {
            return delegate.findById(id);
        }

        @Override
        public OAuth2Authorization findByToken(String token, OAuth2TokenType tokenType) {
            return delegate.findByToken(token, tokenType);
        }
    }
}
