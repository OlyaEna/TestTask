package com.task.task3.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.task.task3.model.entity.Login;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

public class CSVHelperLogin {
    public static String TYPE = "text/csv";
    static String[] HEADERs = {"Application", "AppAccountName", "IsActive", "JobTitle", "Department"};

    public static boolean hasCSVFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    public static List<Login> csvToLogin(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Login> logins = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Login login = new Login(
                        csvRecord.get("Application"),
                        csvRecord.get("AppAccountName"),
                        Boolean.parseBoolean(csvRecord.get("IsActive")),
                        csvRecord.get("JobTitle"),
                        csvRecord.get("Department")
                );

                logins.add(login);
            }

            return logins;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

}