package com.fengwei23.exercise0701.presentation_post.single

import com.fengwei23.exercise0701.presentation_common.state.UiAction


sealed class PostUiAction : UiAction {

    data class Load(val postId: Long) : PostUiAction()
}