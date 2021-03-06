<?php
require_once $_SERVER["DOCUMENT_ROOT"] . "/auto_load.php"; //Inclusion du chargement de tout les fichiers

//Implémentation des constantes
const EXIT_CODE_OK = 0;
const EXIT_CODE_ACTION_MISSING = 1;
const EXIT_CODE_INCORRECT_PARAMETER = 2;
const EXIT_CODE_ERROR_API_EXTERNAL = 3;
const EXIT_CODE_UNKNOW_ACTION = 4;
const EXIT_CODE_UNKNOW_ID_USER = 5;
const EXIT_CODE_INCORRECT_ID_USER = 6;
const EXIT_CODE_UNKNOW_CARDS = 7;
const EXIT_CODE_INCORRECT_CARDS = 8;
const EXIT_CODE_UNKNOW_CARDS_PARAMETER = 9;
const EXIT_CODE_CARDS_IS_MISSING_IN_DB = 10;
const EXIT_CODE_RANDOM_CARD_IS_NULL = 11;
const EXIT_CODE_ERROR_INSERTION_IN_DB = 12;
const EXIT_CODE_INCORRECT_MONEY_READ = 13;
const EXIT_CODE_INCORRECT_TYPE_REQUEST = 14;
const EXIT_CODE_INVALID_URI = 15;
const EXIT_CODE_TOO_LONG_URI = 16;
const EXIT_CODE_UNKNOW_VALUE_PARAMETER = 17;
const EXIT_CODE_INCORRECT_MONEY_SETTER = 18;
const EXIT_CODE_INCORRECT_USER_READ = 19;
const EXIT_CODE_MISSING_PARAMETER = 20;
const EXIT_CODE_ERROR_SQL = 21;
const EXIT_CODE_LOGIN_EXIST = 22;
const EXIT_CODE_GOOGLE_ACCOUNT_EXIST = 23;
const EXIT_CODE_NO_IMPLEMENTED_FUNCTION = 99;
const EXIT_CODE_FACEBOOK_ACCOUNT_EXIST = 24;
const EXIT_CODE_INVENTORY_IS_MISSING = 25;
const EXIT_CODE_EXCHANGE_NOT_WORKING = 26;



const REQUEST_POST = "POST";
const REQUEST_DELETE = "DELETE";
const REQUEST_GET = "GET";

const ROUTE_MONEY = "money";
const ROUTE_USER = "user";
const ROUTE_PARAM = "parameter";
const ROUTE_CARD = "card";
const ROUTE_OTHER = "other";
const ROUTE_CONNECT = "connect";
const ROUTE_INVENTORY = "inventory";
const ROUTE_REGISTER = "register";
const SUB_ROUTE_EMPTY = "";
const SUB_ROUTE_EXCHANGE = "exchange";
const SUB_ROUTE_QUIZZ = "quizz";
const SUB_ROUTE_CRAFTCARD = "craftcard";
const SUB_ROUTE_MELT = "meltcard";
const SUB_ROUTE_RANDOM = "random";
const SUB_ROUTE_ADD_CARD_SPECIAL = "admin";
const SUB_ROUTE_FILTER = "filter";





const HEARTHSTONE_API_URI = "http://api.hearthstonejson.com/v1/15590/frFR/cards.json";
const HEARTHSTONE_ART_URI = "art.hearthstonejson.com/v1/render/latest/frFR/512x/";

const CITY_API_URI = "https://geo.api.gouv.fr/departements/";
const END_CITY_API_URI = "/communes";


const MIN_POPULATION = "10000";
const DB_HOST = "psqt.myd.infomaniak.com";
const DB_NAME = "psqt_iem";
const DB_USER = "psqt_iem";
const DB_PASS = "odSNV7j34Ex0";

const DEACTIVATE = false;
const ACTIVATE = true;
