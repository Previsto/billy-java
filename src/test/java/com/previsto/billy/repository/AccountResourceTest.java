package com.previsto.billy.repository;

import com.previsto.billy.model.Account;
import java.time.LocalDateTime;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.response.DefaultResponseCreator;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.junit.Assert.*;
import org.springframework.test.web.client.RequestMatcher;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;

public class AccountResourceTest extends ResourceTestBase<Account> {

    public AccountResourceTest() {
        super(new AccountResource(buildRestTemplate(), "http://server/Api"));
    }

    @Override
    protected DefaultResponseCreator generateExpectedGetResponse() {
        return withSuccess(Util.readResourceFromFile("accounts_single.json"), MediaType.APPLICATION_JSON);
    }

    @Override
    protected DefaultResponseCreator generateExpectedFindAllResponse() {
        return withSuccess(Util.readResourceFromFile("accounts_list.json"), MediaType.APPLICATION_JSON);
    }

    @Override
    protected String generateExpectedGetQueryParams() {
        return "";
    }

    @Override
    protected String generateSingularId() {
        return "LpR6sv4MREW1aMlJHtASOg";
    }
    
    @Override
    protected RequestMatcher generateExpectedSaveRequest() {
        return jsonPath("$.account.id").value(generateSingularId());
    }

    @Override
    protected void doCheckEntity(Account entity) {
        if ("LpR6sv4MREW1aMlJHtASOg".equals(entity.getId())) {
            assertEquals(7210, entity.getAccountNo());
            return;
        }

        
        //throw new RuntimeException("Unexpected entity [id=" + entity.getId() + "]");
    }

}