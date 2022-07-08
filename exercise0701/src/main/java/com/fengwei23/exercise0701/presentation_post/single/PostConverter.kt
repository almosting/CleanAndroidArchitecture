package com.fengwei23.exercise0701.presentation_post.single

import android.content.Context
import com.fengwei23.exercise0701.R
import com.fengwei23.exercise0701.domain.usecase.GetPostUseCase
import com.fengwei23.exercise0701.presentation_common.state.CommonResultConverter
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PostConverter @Inject constructor(@ApplicationContext private val context: Context) :
    CommonResultConverter<GetPostUseCase.Response, PostModel>() {

    override fun convertSuccess(data: GetPostUseCase.Response): PostModel {
        return PostModel(
            context.getString(R.string.title, data.post.title),
            context.getString(R.string.body, data.post.body)
        )
    }
}