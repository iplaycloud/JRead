package com.iplay.jread.weather.model;

import android.content.Context;

/**
 * Description :
 * Author : iplay
 * Email  : iplaycloud@gmail.com
 * Blog   : www.iplaycloud.xyz
 * Date   : 2015/12/22
 */
public interface WeatherModel {

    void loadWeatherData(String cityName, WeatherModelImpl.LoadWeatherListener listener);

    void loadLocation(Context context, WeatherModelImpl.LoadLocationListener listener);

}
