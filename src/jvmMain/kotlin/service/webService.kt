package service

import model.website
import java.net.URL

object webService {

    val websiteList:MutableList<website> = mutableListOf();

    fun init():MutableList<website>{
        websiteList.add(website("百度", URL("https://www.baidu.com"),999))
        websiteList.add(website("网易云音乐", URL("https://music.163.com"),120))
        websiteList.add(website("Github", URL("https://github.com"),90))
        websiteList.add(website("YouTube", URL("https://www.youtube.com"),301))

        return websiteList;
    }


}