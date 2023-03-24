package com.task.task3.service.CSVHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.task.task3.model.entity.Login;
import com.task.task3.model.entity.Posting;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

public class CSVHelperPosting {
    public static String TYPE = "text/csv";
    static String[] HEADERs = {"Mat. Doc.", "Item", "Doc. Date", "Pstng Date", "Material Description",
            "Quantity", "BUn", "Amount LC", "Crcy", "User Name"};

    public static boolean hasCSVFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    public static List<Posting> csvToPosting(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Posting> postings = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

            for (CSVRecord csvRecord : csvRecords) {
                Posting posting = new Posting(
                        Long.parseLong(csvRecord.get("Mat. Doc.")),
                        Integer.parseInt(csvRecord.get("Item")),
                        LocalDate.parse(csvRecord.get("Doc. Date"), formatter),
                        LocalDate.parse(csvRecord.get("Pstng Date"), formatter),
                        csvRecord.get("Material Description"),
                        Integer.parseInt(csvRecord.get("Quantity")),
                        csvRecord.get("BUn"),
                        csvRecord.get("Amount LC"),
                        csvRecord.get("Crcy"),
                        csvRecord.get("User Name")
                );

                postings.add(posting);
            }

            return postings;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}