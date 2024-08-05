# Sample custom OAuth2AuthorizationService

1. Launch the app
2. Navigate
   to http://localhost:9000/oauth2/authorize?response_type=code&client_id=oidc-client&scope=openid&state=random&redirect_uri=http://localhost:8080/authorized
3. Login with `user` / `password`
4. The request will fail because there is no `localhost:8080/authorized` to navigate to, but you should
   see `~~~~~~~~~~ CALLING SAVE ~~~~~~~~~~~~` in the console