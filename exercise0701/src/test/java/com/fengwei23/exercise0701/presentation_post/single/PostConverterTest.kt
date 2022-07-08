package com.fengwei23.exercise0701.presentation_post.single

import android.content.Context
import com.fengwei23.exercise0701.domain.usecase.GetPostUseCase
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import com.fengwei23.exercise0701.domain.entity.Post
import com.fengwei23.exercise0701.R

class PostConverterTest {

    private val context = mock<Context>()
    private val converter = PostConverter(context)

    @Test
    fun testConvertSuccess() {
        val response = GetPostUseCase.Response(
            post = Post(
                id = 1L,
                userId = 1L,
                title = "title",
                body = "body"
            )
        )
        val formattedTitle = "formattedTitle"
        val formattedBody = "formattedBody"
        whenever(context.getString(R.string.title, "title")).thenReturn(formattedTitle)
        whenever(context.getString(R.string.body, "body")).thenReturn(formattedBody)
        val result = converter.convertSuccess(response)
        assertEquals(PostModel(formattedTitle, formattedBody), result)
    }
}