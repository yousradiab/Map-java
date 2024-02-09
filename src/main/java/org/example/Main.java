package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void testMapping() {
        Map<String, String> mapString = new HashMap<>();
        mapString.put("key1", "value1");
        mapString.put("key2", "value2");
        mapString.put("key3", "value3");
        mapString.put("key1", "value4");

        //System.out.println(mapString);
        //keyset er collections og returner et sæt - ikke sorteret.
        for(String s: mapString.keySet()) {
            //System.out.println(s);
        }
        mapString.forEach((key, value) ->System.out.println( key + "value=" + value));

    }
    public static void main(String[] args) {

       /* List<String> words = Arrays.asList("mand", "han", "dig");
        String urlEb = "https://ekstrabladet.dk/";
        UrlReader urlReader = new UrlReader();
        Map<String, Integer> mapWords = urlReader.readUrl(urlEb, words);
        mapWords.forEach((key, value) -> System.out.println(key + "value=" + " " + value));

        //var obj =("hej med dig".indexOf("hej"));
        //System.out.println(obj);
*/

        List<String> words = Arrays.asList("Bliv", "<div", "<h", "tre");
        List<String> urls = Arrays.asList("https://ekstrabladet.dk/","https://dr.dk/","https://bt.dk/");
        UrlReader urlReader = new UrlReader();
        Map<String, Map<String, Integer>> urlsMap = urlReader.readUrls(urls, words);
        urlsMap.forEach((url, value) -> System.out.println(url + " value = " +value));

    }


}