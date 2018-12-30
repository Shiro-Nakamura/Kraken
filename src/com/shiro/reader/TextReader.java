package com.shiro.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class TextReader implements MalwareFeedReader {

    private String address;

    public TextReader(String address) {
        this.address = address;
    }

    @Override
    public String readFeeds() {
        try {
            URL url = new URL(address);
            URLConnection connection = url.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            connection.getInputStream()));

            StringBuilder response = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null)
                response.append(inputLine);

            in.close();

            return response.toString();
        } catch (IOException e) {
            return "";
        }
    }
}
