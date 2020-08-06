package model

data class DataBean(
    val air: String,
    val air_level: String,
    val air_pm25: String,
    val air_tips: String,
    val alarm: Alarm,
    val aqi: Aqi,
    val city: String,
    val cityEn: String,
    val cityid: String,
    val country: String,
    val countryEn: String,
    val date: String,
    val humidity: String,
    val pressure: String,
    val tem: String,
    val tem1: String,
    val tem2: String,
    val update_time: String,
    val visibility: String,
    val wea: String,
    val wea_img: String,
    val week: String,
    val win: String,
    val win_meter: String,
    val win_speed: String
)

data class Alarm(
    val alarm_content: String,
    val alarm_level: String,
    val alarm_type: String
)

data class Aqi(
    val air: String,
    val air_level: String,
    val air_tips: String,
    val city: String,
    val cityEn: String,
    val cityid: String,
    val country: String,
    val countryEn: String,
    val jinghuaqi: String,
    val kaichuang: String,
    val kouzhao: String,
    val no2: String,
    val no2_desc: String,
    val o3: String,
    val o3_desc: String,
    val pm10: String,
    val pm10_desc: String,
    val pm25: String,
    val pm25_desc: String,
    val so2: String,
    val so2_desc: String,
    val waichu: String
)