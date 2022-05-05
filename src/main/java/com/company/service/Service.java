package com.company.service;

import com.company.entity.GsonUniversity;
import com.company.entity.UniversityDTO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class Service {

    private static String urlName = "http://universities.hipolabs.com/search?country=Uzbekistan";

    public static List<UniversityDTO> universityOfUzbekistan() {
        List<UniversityDTO> universityDTOList = new LinkedList<>();
        try {
            URL url = new URL(urlName);
            URLConnection connection = url.openConnection();

            InputStream stream = connection.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            StringBuilder builder = new StringBuilder();
            String line = reader.readLine();

            while (line != null) {
                builder.append(line);
                line = reader.readLine();
            }

            Gson gson = new Gson();
            GsonUniversity[] gsonUniversities = gson.fromJson(builder.toString(), GsonUniversity[].class);
            for (GsonUniversity gsonUniversity : gsonUniversities) {
                UniversityDTO dto = new UniversityDTO();
                dto.setDomains(gsonUniversity.getDomains()[0]);
                dto.setWeb_pages(gsonUniversity.getWeb_pages()[0]);
                dto.setName(gsonUniversity.getName());
                universityDTOList.add(dto);
            }

//            for (UniversityDTO universityDTO : universityDTOList) {
//                System.out.println(universityDTO);
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return universityDTOList;
    }

}
