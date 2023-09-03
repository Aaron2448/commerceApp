const cors = require('cors');

module.exports = function (app) {
    const corsOptions = {
        origin: true,
        methods: ['GET', 'POST', 'PUT', 'DELETE', 'OPTIONS'],
        allowedHeaders: ['Authorization', 'Content-Type', 'Origin', 'X-Requested-With', 'Accept'],
        credentials: true,
        optionsSuccessStatus: 204,
    };

    app.use(cors(corsOptions));

    app.use(function (req, res, next) {
        res.header('Access-Control-Allow-Origin', '*');
        res.header('Access-Control-Allow-Methods', 'GET, POST, PUT, DELETE, OPTIONS');
        res.header('Access-Control-Allow-Headers', 'Authorization, Content-Type, Origin, X-Requested-With, Accept');
        res.header('Access-Control-Allow-Credentials', true);
        res.header('Access-Control-Max-Age', '86400');
        next();
    });
};