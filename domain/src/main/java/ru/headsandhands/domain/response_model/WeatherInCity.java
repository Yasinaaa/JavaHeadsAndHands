package ru.headsandhands.domain.response_model;

import java.util.ArrayList;

/**
 * Created by yasina on 10.10.2019.
 * Copyright (c) 2018 Infomatica. All rights reserved.
 */
public class WeatherInCity {

    public Coord coord;
    public ArrayList<Weather> weather;
    public String base;
    public WeatherMain main;
    public long visibility;
    public Wind wind;
    public Clouds clouds;
    public long dt;
    public Sys sys;
    public long id;
    public String name;
    public int cod;

    public class Coord{
        public float lon;
        public float lat;
    }

    public class Weather{
        public long id;
        public String main, description, icon;
    }

    public class WeatherMain{
        public float temp, pressure, humidity, temp_min, temp_max;
    }

    public class Wind{
        public float speed;
        public int deg;
    }

    public class Clouds{
        public int all;
    }

    public class Sys{
        public int type;
        public long id;
        public float message;
        public String country;
        public long sunrise, sunset;
    }
}
