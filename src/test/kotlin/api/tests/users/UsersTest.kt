package api.tests.users

import api.controllers.users.*
import api.models.common.user
import net.javacrumbs.jsonunit.core.util.ResourceUtils.resource
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertNotNull

class UsersTest {

    @Test
    fun test01_getListUsers_200_OK() {
        val listUsers =
            getListUsers(2)
                assertEquals(200, listUsers.status)
                assertEquals(resource("responses/users/getListUsers_200_OK.json").readText(),
                    listUsers.body.getObject().toString(2))
    }

    @Test
    fun test02_getSingleUser_200_OK() {
        val singleUser =
            getSingleUser(2)
                assertEquals(200, singleUser.status)
                assertEquals(resource("responses/users/getSingleUser_200_OK.json").readText(),
                    singleUser.body.getObject().toString(2))
    }

    @Test
    fun test03_getSingleUser_404_NOT_FOUND() {
        val singleUserNotFound =
            getSingleUser(23)
                assertEquals(404, singleUserNotFound.status)
                assertEquals("{}",
                    singleUserNotFound.body.getObject().toString(2))
    }

    @Test
    fun test04_patchUpdateUser_200_OK() {
        val updateUser =
            patchUpdateUser(2, user)
                assertEquals(200, updateUser.status)
                assertNotNull(updateUser.body)
    }

    @Test
    fun test05_putUpdateUser_200_OK() {
        val updateUser =
            putUpdateUser(2, user)
                assertEquals(200, updateUser.status)
                assertNotNull(updateUser.body)
    }

    @Test
    fun test06_deleteUser_204_NO_CONTENT() {
        val deleteUser =
            deleteUser(2)
                assertEquals(204, deleteUser.status)
                assertEquals(null, deleteUser.body)
    }
}