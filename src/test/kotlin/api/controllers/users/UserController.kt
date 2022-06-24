package api.controllers.users

import api.configs.BASE_HOST
import com.mashape.unirest.http.HttpResponse
import com.mashape.unirest.http.JsonNode
import com.mashape.unirest.http.Unirest.*

fun getListUsers(page: Int): HttpResponse<JsonNode> =
        get("$BASE_HOST/api/users")
                .header("accept", "application/json")
                .queryString("page", "$page")
                .asJson()

fun getSingleUser(userId: Int): HttpResponse<JsonNode> =
        get("$BASE_HOST/api/users/$userId")
                .header("accept", "application/json")
                .asJson()

fun patchUpdateUser(userId: Int, requestBody: String): HttpResponse<JsonNode> =
        patch("$BASE_HOST/api/users/$userId")
                .header("accept", "application/json")
                .body(requestBody)
                .asJson()

fun putUpdateUser(userId: Int, requestBody: String): HttpResponse<JsonNode> =
        put("$BASE_HOST/api/users/$userId")
                .header("accept", "application/json")
                .body(requestBody)
                .asJson()

fun deleteUser(userId: Int): HttpResponse<JsonNode> =
        delete("$BASE_HOST/api/users/$userId")
                .header("accept", "application/json")
                .asJson()