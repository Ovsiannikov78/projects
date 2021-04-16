export default {

  oidc: {
    clientId: '<<<==== your clientId from Okta ====>>>',
    issuer: 'https://dev-26912157.okta.com',
    redirectUri: 'http://localhost:4200/login/callback',
    scopes: ['openid', 'profile', 'email']
  }
};
