package org.example;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UrlReader {

    public Map<String, Integer> readUrl(String strUrl, List<String> words) {
        Map<String, Integer> mapWords = new HashMap<>();
        for(String ss: words) {
            mapWords.put(ss,0);
        }

       try {
            URL url = new URL(strUrl);
        try {
            URLConnection urlConnection = url.openConnection();
            BufferedReader  bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line = "";
            while (line != null) {
                for (String word: words) {
                    if(line.indexOf(word) >= 0) {
                        Integer ii = mapWords.get(word);
                        ii++;
                        mapWords.put(word, ii);
                    }
                }
                line = bufferedReader.readLine();

            }
        }catch (IOException io) {
            System.out.println(io.getMessage());
        }
        } catch (MalformedURLException e) {
            System.out.println("kan ikke læse URL=" + " " + strUrl + " " + e.getMessage());
        }


        return mapWords;
    }


    public Map<String, Map<String, Integer>> readUrls (List<String> urls, List<String> words) {
        Map<String, Map<String, Integer>> outerMap = new HashMap<>();
        for (String url : urls) {
            Map<String, Integer> innerMap = new HashMap<>();
            innerMap = this.readUrl(url, words);
            outerMap.put(url, innerMap);

        }
        return outerMap;
    }
    }
