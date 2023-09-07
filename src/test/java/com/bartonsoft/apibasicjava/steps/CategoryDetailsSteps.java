package com.bartonsoft.apibasicjava.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import com.bartonsoft.apibasicjava.datamodel.CategoryDetailsResponse;
import com.google.gson.Gson;

import io.cucumber.datatable.*;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;
import io.cucumber.java.DataTableType;

import com.bartonsoft.apibasicjava.common.*;
import static org.assertj.core.api.Assertions.*;

public class CategoryDetailsSteps {

    private String baseURL = "https://api.tmsandbox.co.nz";
    private Response response;
    private CategoryDetailsResponse actualCategoryDetailsResponse;

    @DataTableType
    public CategoryDetailsTable transform(Map<String, String> row){               
        return new CategoryDetailsTable(
            row.get("jsonPointer"), 
            Boolean.parseBoolean(row.get("exactMatch")), 
            row.get("expectedContent"));
    }

    @When("I perform a GET request to the following endpoint {string}")
    public void i_perform_a_get_request_to_the_following_endpoint(String path) {
        RequestSpecification request = RestAssured.given();
        request.baseUri(baseURL);
        request.basePath(path);
        response = request.get();
        response.then().statusCode(200);
    }

    @Then("I receive a valid payload")
    public void i_receive_a_valid_payload() {
        actualCategoryDetailsResponse = response.getBody().as(CategoryDetailsResponse.class);
    }

    @Then("the following data is returned")
    public void the_following_data_is_returned(DataTable inputTable) {
        List<CategoryDetailsTable> dataTable = inputTable.asList(CategoryDetailsTable.class);
        JSONObject jsonRepresentation = new JSONObject(new Gson().toJson(actualCategoryDetailsResponse));
        for(CategoryDetailsTable row : dataTable){
            Object element = jsonRepresentation.query("/" + row.jsonPointer);
            if (row.exactMatch){
                assertThat(element.toString()).isEqualTo(row.expectedContent);
            }
            else{
                assertThat((String)element).contains(row.expectedContent);
            }
        }
    }
}
