package com.task.task3.controller;

import com.task.task3.dto.DeliveryResponse;
import com.task.task3.dto.PostingDto;
import com.task.task3.dto.ResponseMessage;
import com.task.task3.model.entity.Login;
import com.task.task3.model.entity.Posting;
import com.task.task3.model.repository.PostingRepository;
import com.task.task3.service.CSVHelper.CSVHelperLogin;
import com.task.task3.service.CSVHelper.CSVHelperPosting;
import com.task.task3.service.LoginService;
import com.task.task3.service.PostingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.util.List;

@Controller
@ResponseBody
@AllArgsConstructor
@RequestMapping("/posting")

public class CSVPostingController {
    private final PostingService postingService;
    private final PostingRepository postingRepository;


    /**
     * Добавление файла Postings.csv
     */

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";

        if (CSVHelperPosting.hasCSVFormat(file)) {
            try {
                postingService.save(file);
                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }
        message = "Please upload a csv file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }

    /**
     * Вывод полной таблицы, также проверка,
     * что User Name (postings.csv) находится в списке AppAccountName (logins.csv) и IsActive
     */
    @GetMapping("/getAll")
    public ResponseEntity<List<PostingDto>> getAllTutorials() {
        try {
            postingService.saveBooleanIfTrue();
            List<PostingDto> postings = postingService.getAllPostings();

            if (postings.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(postings, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Ищет Posting по дате поставки
     * запрос для примера : /posting/find/pstng?from=2020-07-21&to=2020-07-25
     */
    @GetMapping(path = "/find/pstng")
    public List<PostingDto> findPstngByDateBetween(@RequestParam(name = "from") Date from,
                                                @RequestParam(name = "to") Date to) {
        return postingService.findByDatePstng(from, to);
    }

    /**
     * Ищет Posting по дате договора
     * запрос для примера : /posting/find/docDate?from=2020-07-21&to=2020-07-25
     */
    @GetMapping(path = "/find/docDate")
    public List<PostingDto> findDocDateByDateBetween(@RequestParam(name = "from") Date from,
                                                  @RequestParam(name = "to") Date to) {
        return postingService.findByDateDocDate(from, to);
    }


    /**
     * Ищет Posting по дате договора с возможностью запроса с фильтром по полю "авторизованная поставка"
     * Выводит четыре поля: userName,authorizedDelivery, docDate, pstngDate
     * запрос для примера : /posting/find/delivery?from=2020-07-21&to=2020-07-25
     */
    @GetMapping(path = "/find/delivery")
    public List<DeliveryResponse> findByAuthorizedDelivery(@RequestParam(name = "from") Date from,
                                                           @RequestParam(name = "to") Date to) {
        return postingService.findByAuthorizedDelivery( from, to);
    }

}