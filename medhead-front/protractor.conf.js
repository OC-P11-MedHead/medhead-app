exports.config = {
    capabilities: {
        browserName: 'chrome', // Vous pouvez également utiliser 'firefox', 'safari', etc.
        chromeOptions: {
            args: ['--no-sandbox', '--disable-gpu'],
        },
    },
    specs: ['./e2e/*.js'],
      // Adresse de votre application Angular en cours d'exécution
    baseUrl: 'http://localhost:4200/',
}