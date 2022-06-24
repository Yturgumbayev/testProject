package api.tests.resource

import api.controllers.resource.getListResources
import api.controllers.resource.getSingleResource
import net.javacrumbs.jsonunit.core.util.ResourceUtils.resource
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ResourceTest {

    @Test
    fun test01_getListResources_200_OK() {
        val listResources =
            getListResources()
                assertEquals(200, listResources.status)
                assertEquals(resource("responses/resource/getListResources_200_OK.json").readText(),
                    listResources.body.getObject().toString(2))
    }

    @Test
    fun test02_getSingleResource_200_OK() {
        val singleResource =
            getSingleResource(2)
                assertEquals(200, singleResource.status)
                assertEquals(resource("responses/resource/getSingleResource_200_OK.json").readText(),
                    singleResource.body.getObject().toString(2))
    }

    @Test
    fun test03_getSingleResource_404_NOT_FOUND() {
        val singleResourceNotFound =
            getSingleResource(22)
                assertEquals(404, singleResourceNotFound.status)
                assertEquals("{}",
                    singleResourceNotFound.body.getObject().toString(2))
    }
}