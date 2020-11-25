const express = require("express");
const bodyParser = require("body-parser");
const cors = require("cors");

const app = express();

const db = require("./app/models");
const { Sequelize } = require("./app/models");
app.use(express);
app.use(express.json);
db.sequelize.sync();

var corsOptions = {
  origin: "http://localhost:8080"
};

app.use(cors(corsOptions));

app.use(bodyParser.json());

app.use(bodyParser.urlencoded({extended: true}));

app.get("/", (req, res) => {
  res.json({message: "Roger"});
});

const PORT = process.env.PORT || 8080;
app.listen(PORT, () => {
  console.log('server is running on port ${PORT}.');
});