var express = require('express');
var app = express();
var bodyParser = require('body-parser');
var mysql = require('mysql');

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({
    extended: true
}));
  
// default route
app.get('/', function (req, res) {
    return res.send({ error: true, message: 'Test Student Web API' })
});
// connection configurations
var dbConn = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: '',
    database: 'logindb'
});

dbConn.connect();

app.post('/login', function(req, res){
    var data = req.body;
    var username = data.username;
    var password = data.password;

        dbConn.query('SELECT * FROM userlogin WHERE username = ? AND password = ?', [username, password], function(error, results, fields) {
            dbConn.on('error', function(err) {
                console.log('[MySQL ERROR]', err)
            });

            if (results && results.length) {
                res.end(JSON.stringify(results[0]))
            }
            else {
                res.end(JSON.stringify('Wrong password'));
            }
        });
});


// set port
app.listen(3000, function () {
    console.log('Node app is running on port 3000');
});
 
module.exports = app;