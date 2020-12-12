package com.revature.ers.servlet.util;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

public class RequestUtil {
    public static String ReadRequestBody(HttpServletRequest req) throws IOException {
        BufferedReader reader = req.getReader();
        StringBuilder stringBuilder = new StringBuilder();

        String line = reader.readLine();
        while(line != null){
            stringBuilder.append(line);
            line = reader.readLine();
        }
        return new String(stringBuilder);
    }
}
