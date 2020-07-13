package com.maya.homework;

import com.maya.homework.models.requests.TransactionListForm;
import com.maya.homework.models.requests.TransactionReportForm;
import com.maya.homework.models.responses.TransactionDetailResponse;
import com.maya.homework.models.responses.TransactionListResponse;
import com.maya.homework.models.responses.TransactionReportResponse;
import com.maya.homework.services.ApiService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TransactionController {
    @PostMapping(value = "/transactions/list", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public ResponseEntity<Object> list(@RequestBody TransactionListForm transactionListForm) {
        ApiService service = new ApiService();
        TransactionListResponse listServiceResponse = service.transactionList(transactionListForm);
        return ResponseEntity.status(200).body(listServiceResponse);
    }

    @GetMapping(value = "/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public ResponseEntity<Object> details(@RequestParam String transactionId) {
        ApiService service = new ApiService();
        TransactionDetailResponse listServiceResponse = service.transactionDetail(transactionId);
        return ResponseEntity.status(200).body(listServiceResponse);
    }

    @PostMapping(value = "/transactions/report", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public ResponseEntity<Object> report(@RequestBody TransactionReportForm transactionReportForm) {
        ApiService service = new ApiService();
        TransactionReportResponse reportServiceResponse = service.transactionReport(transactionReportForm);
        return ResponseEntity.status(200).body(reportServiceResponse);
    }
}
