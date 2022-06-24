package api.controllers.userRegistration

import api.configs.BASE_HOST
import com.mashape.unirest.http.HttpResponse
import com.mashape.unirest.http.JsonNode
import com.mashape.unirest.http.Unirest.post

fun postRegisterUser(requestBody: String): HttpResponse<JsonNode> =
        post("$BASE_HOST/api/register")
            .header("accept", "application/json")
            .header("content-type", "application/json")
            .body(requestBody)
            .asJson()