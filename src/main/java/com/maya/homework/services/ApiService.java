package com.maya.homework.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maya.homework.models.*;
import com.maya.homework.models.requests.LoginForm;
import com.maya.homework.models.requests.TransactionListForm;
import com.maya.homework.models.requests.TransactionReportForm;
import com.maya.homework.models.responses.LoginResponse;
import com.maya.homework.models.responses.TransactionDetailResponse;
import com.maya.homework.models.responses.TransactionReportResponse;
import com.maya.homework.models.responses.TransactionListResponse;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ApiService {
    public String endpoint = "https://sandbox-reporting.rpdpymnt.com/api/v3";

    // FOR JSON OBJECY MAPPER
    private final ObjectMapper objectMapper = new ObjectMapper();

    // FOR DUMMY DATA
    String[] dummyCurrencies = {"TRY", "USD", "DZD", "AZN", "EUR", "AUD"};

    // Call login service on the rpdpymnt auth service
    public LoginResponse login(LoginForm loginform) throws JSONException {
        RestTemplate restTemplate = new RestTemplate();

        String url = endpoint + "/merchant/user/login";

        JSONObject personJsonObject = new JSONObject();
        personJsonObject.put("email", loginform.email);
        personJsonObject.put("password", loginform.password);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(personJsonObject.toString(), headers);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setStatus(500);

        try {
            String endpointResponse = restTemplate.postForObject(url, entity, String.class);
            JsonNode responseObject = objectMapper.readTree(endpointResponse);

            System.out.println(responseObject.toString());
            loginResponse.setToken(responseObject.path("token").asText());
            if (responseObject.path("status").asText().equals("APPROVED")) {
                loginResponse.setStatus(200);
            }

        } catch (HttpStatusCodeException exception) {
            int statusCode = exception.getStatusCode().value();

            loginResponse.setError("Incorrect username or password!");
            loginResponse.setStatus(statusCode);
            return loginResponse;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            loginResponse.setError("Invalid Cred");
        }


        return loginResponse;
    }

    // @todo Call real service
    //  RETURN ONLY DUMMY DATA RIGHT NOW
    public TransactionReportResponse transactionReport(TransactionReportForm transactionReportForm) {
        // DUMMY DATA

        // int randomSize = new Random().nextInt();
        int randomNum = ThreadLocalRandom.current().nextInt(3, 5);

        CurrencyModel[] currencies = new CurrencyModel[randomNum];

        for (int i = 0; i < randomNum; i++) {
            CurrencyModel currency = new CurrencyModel();

            Random rand = new Random();

            int randomCount = ThreadLocalRandom.current().nextInt(1, 50);
            int randomTotal = ThreadLocalRandom.current().nextInt(5000, 10000);

            currency.setCount(randomCount);
            currency.setTotal(randomTotal);
            currency.setCurrency(this.dummyCurrencies[rand.nextInt(this.dummyCurrencies.length)]);
            currencies[i] = currency;
        }

        TransactionReportResponse transactionReportResponse = new TransactionReportResponse();

        transactionReportResponse.setCurrencies(currencies);
        transactionReportResponse.setTotal(currencies.length);

        return transactionReportResponse;
    }

    // @todo Call real service
    //  RETURN ONLY DUMMY DATA RIGHT NOW
    public TransactionListResponse transactionList(TransactionListForm transactionListForm) {
        // DUMMY DATA
        // i made a dummy service because your api service received the mongo error

        // int randomSize = new Random().nextInt();
        int randomSize = ThreadLocalRandom.current().nextInt(10, 40);

        TransactionDataItemModel[] data = new TransactionDataItemModel[randomSize];

        for (int i = 0; i < randomSize; i++) {
            TransactionDataItemModel transaction = new TransactionDataItemModel();

            Random rand = new Random();

            // GENERATE DUMMY FX MODEL
            AcquirerModel randomFxModel = new AcquirerModel();
            FxModel fxModel = new FxModel();
            FxMerchantModel fxMerchant = new FxMerchantModel();

            double randomAmount = ThreadLocalRandom.current().nextDouble() * 10000;
            double roundOff = Math.round(randomAmount * 100.0) / 100.0;
            fxMerchant.setOriginalAmount(roundOff);
            fxMerchant.setOriginalCurrency(this.dummyCurrencies[rand.nextInt(this.dummyCurrencies.length)]);
            fxModel.setMerchant(fxMerchant);
            transaction.setFx(fxModel);

            // GENERATE DUMMY ACQUIRER MODEL
            AcquirerModel randomAcquirer = new AcquirerModel();
            int randomAcquirerId = ThreadLocalRandom.current().nextInt(1, 50);
            randomAcquirer.setId(randomAcquirerId);
            randomAcquirer.setName("Test Dummy Acq " + (i + 1));
            transaction.setAcquirer(randomAcquirer);

            // GENERATE DUMMY CUSTOMER MODEL
            CustomerInfoModel customerInfoModel = new CustomerInfoModel();
            customerInfoModel.setEmail("test@test.io");
            customerInfoModel.setBillingFirstName("Customer " + (i + 1));
            customerInfoModel.setBillingLastName("Lastname");
            transaction.setCustomerInfo(customerInfoModel);


            // GENERATE DUMMY MERCHANT MODEL
            MerchantModel randomMerchant = new MerchantModel();
            int randomMerchantId = ThreadLocalRandom.current().nextInt(1, 50);
            randomMerchant.setId(randomMerchantId);
            randomMerchant.setName("Test Dummy Merchant " + (i + 1));
            transaction.setMerchant(randomMerchant);

            // GENERATE DUMMY TRN MODEL
            TransactionModel randomTrn = new TransactionModel();

            // GENERATE DUMMY MERCHANT for TRN
            TransactionMerchantModel randomTrnMerchant = new TransactionMerchantModel();
            randomTrnMerchant.setCreated_at(new Date());
            randomTrnMerchant.setMessage("Auth3D is APPROVED");
            randomTrnMerchant.setOperation("3DAUTH");
            randomTrnMerchant.setStatus("APPROVED");
            int randomRrfId = ThreadLocalRandom.current().nextInt(1000, 40000);
            randomTrnMerchant.setReferenceNo("api_560a" + randomRrfId);
            int randomTrnId = ThreadLocalRandom.current().nextInt(100000, 999999);
            randomTrnMerchant.setTransactionId(Integer.toString(randomTrnId));

            randomTrn.setMerchant(randomTrnMerchant);
            transaction.setTransaction(randomTrn);

            // GENERATE DUMMY IPN MODEL

            TransactionIpnModel transactionIpnModel = new TransactionIpnModel(rand.nextBoolean());
            transaction.setIpn(transactionIpnModel);

            // SET DUMMY REFUNDABLE PARAM
            transaction.setRefundable(rand.nextBoolean());


            data[i] = transaction;
        }

        TransactionListResponse transactionListResponse = new TransactionListResponse();

        transactionListResponse.setData(data);
        transactionListResponse.setTotal(data.length);

        return transactionListResponse;
    }

    public TransactionDetailResponse transactionDetail(String transactionId) {

        // DUMMY RESPONSE

        TransactionDetailResponse transactionDetailResponse = new TransactionDetailResponse();

        // GENERATE DUMMY FX
        FxModel dummyFx = new FxModel();
        FxMerchantModel dummyFxMerchant = new FxMerchantModel();
        dummyFxMerchant.setOriginalAmount(2.2);
        dummyFxMerchant.setOriginalCurrency("USD");
        dummyFx.setMerchant(dummyFxMerchant);
        transactionDetailResponse.setFx(dummyFx);

        // GENERATE DUMMY CUSTOMER
        CustomerInfoModel customerInfoModel = new CustomerInfoModel();
        customerInfoModel.setId(1);
        customerInfoModel.setCreated_at(new Date());
        customerInfoModel.setUpdated_at(new Date());
        customerInfoModel.setDeleted_at(new Date());
        customerInfoModel.setNumber("401288XXXXXX1881");
        customerInfoModel.setExpiryMonth("6");
        customerInfoModel.setExpiryYear("2017");
        customerInfoModel.setStartMonth(null);
        customerInfoModel.setStartYear(null);
        customerInfoModel.setIssueNumber(null);
        customerInfoModel.setEmail("test@test.info");
        customerInfoModel.setBirthday(new Date());
        customerInfoModel.setGender("Male");
        customerInfoModel.setBillingTitle(null);
        customerInfoModel.setBillingFirstName("Michael");
        customerInfoModel.setBillingLastName("Kara");
        customerInfoModel.setBillingCompany(null);
        customerInfoModel.setBillingAddress1("test address");
        customerInfoModel.setBillingAddress1(null);
        customerInfoModel.setBillingCity("Antalya");
        customerInfoModel.setBillingPostcode("07070");
        customerInfoModel.setBillingState(null);
        customerInfoModel.setBillingCountry("TR");
        customerInfoModel.setBillingFax(null);
        customerInfoModel.setShippingTitle(null);
        customerInfoModel.setShippingFirstName("Michael");
        customerInfoModel.setShippingLastName("Kara");
        customerInfoModel.setShippingCompany(null);
        customerInfoModel.setShippingAddress1("test address 2");
        customerInfoModel.setShippingAddress1("test address 2");
        customerInfoModel.setShippingCity("Antalya");
        customerInfoModel.setShippingPostcode("07070");
        customerInfoModel.setShippingState(null);
        customerInfoModel.setShippingCountry("TR");
        customerInfoModel.setShippingPhone(null);
        customerInfoModel.setShippingFax(null);
        transactionDetailResponse.setCustomerInfo(customerInfoModel);

        // GENERATE DUMMY MERCHANT
        MerchantModel merchantModel = new MerchantModel();
        merchantModel.setId(1);
        merchantModel.setName("Dummy Merchant 1");
        transactionDetailResponse.setMerchant(merchantModel);

        // GENERATE DUMMY TRANSACTION
        TransactionModel transactionModel = new TransactionModel();
        TransactionMerchantModel transactionMerchantModel = new TransactionMerchantModel();
        transactionMerchantModel.setReferenceNo("reference_5617ae66281ee");
        transactionMerchantModel.setMerchantId(1);
        transactionMerchantModel.setStatus("WAITING");
        transactionMerchantModel.setChannel("API");
        transactionMerchantModel.setOperation("DIRECT");
        transactionMerchantModel.setFxTransactionId(1);
        transactionMerchantModel.setUpdated_at(new Date());
        transactionMerchantModel.setCreated_at(new Date());
        transactionMerchantModel.setId(1);
        transactionMerchantModel.setAcquirerTransactionId(1);
        transactionMerchantModel.setCode("00");
        transactionMerchantModel.setMessage("Waiting");
        transactionMerchantModel.setTransactionId("1-1444392550-1");


        transactionModel.setMerchant(transactionMerchantModel);
        transactionDetailResponse.setTransaction(transactionModel);

        return transactionDetailResponse;
    }
}
