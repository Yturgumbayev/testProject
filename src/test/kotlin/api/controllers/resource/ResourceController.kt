package api.controllers.resource

import api.configs.BASE_HOST
import com.mashape.unirest.http.HttpResponse
import com.mashape.unirest.http.JsonNode
import com.mashape.unirest.http.Unirest.get

fun getListResources(): HttpResponse<JsonNode> =
        get("$BASE_HOST/api/unknown")
            .header("accept", "application/json")
            .asJson()

fun getSingleResource(userId: Int): HttpResponse<JsonNode> =
        get("$BASE_HOST/api/unknown/$userId")
            .header("accept", "application/json")
            .asJson()