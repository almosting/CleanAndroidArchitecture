package com.fengwei23.exercise0701.presentation_user.single

import android.content.Context
import com.fengwei23.exercise0701.R
import com.fengwei23.exercise0701.domain.usecase.GetUserUseCase
import org.junit.Assert
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import com.fengwei23.exercise0701.domain.entity.User

class UserConverterTest {

    private val context = mock<Context>()
    private val converter = UserConverter(context)

    @Test
    fun testConvertSuccess() {
        val response = GetUserUseCase.Response(
            user = User(
                id = 1L,
                name = "name",
                username = "username",
                email = "email"
            )
        )
        val formattedName = "formattedName"
        val formattedUsername = "formattedUsername"
        val formattedEmail = "formattedEmail"
        whenever(context.getString(R.string.name, "name")).thenReturn(formattedName)
        whenever(context.getString(R.string.username, "username")).thenReturn(formattedUsername)
        whenever(context.getString(R.string.email, "email")).thenReturn(formattedEmail)
        val result = converter.convertSuccess(response)
        Assert.assertEquals(UserModel(formattedName, formattedUsername, formattedEmail), result)
    }
}