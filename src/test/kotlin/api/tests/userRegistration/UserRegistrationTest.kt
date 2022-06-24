package api.tests.userRegistration

import api.controllers.userRegistration.postRegisterUser
import api.models.common.userRegistration
import net.javacrumbs.jsonunit.core.util.ResourceUtils.resource
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UserRegistrationTest {

    @Test
    fun test01_postUserRegistration_200_OK() {
        val userRegistration =
            postRegisterUser(userRegistration)
                assertEquals(200, userRegistration.status)
                assertEquals( resource("responses/userRegistration/postUserRegistration_200_OK.json").readText(),
                    userRegistration.body.getObject().toString(2))
    }

    @Test
    fun test02_postUserRegistration_400_BAD_REQUEST() {
        val userRegistration =
            postRegisterUser("{\"email\": \"sydney@fife\"}")
                assertEquals(400, userRegistration.status)
                assertEquals("{\"error\": \"Missing password\"}",
                    userRegistration.body.getObject().toString(2))
    }
}