exports.config = {
    capabilities: {
        browserName: 'chromium', // Vous pouvez également utiliser 'firefox', 'safari', etc.
        chromeOptions: {
            args: ['--headless', '--disable-gpu', '--window-size=1920x1080'],
        },
    },
    specs: ['./e2e/*.js'],
      // Adresse de votre application Angular en cours d'exécution
}