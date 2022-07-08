package com.fengwei23.exercise0701.presentation_post.list


import com.fengwei23.exercise0701.domain.entity.Interaction
import com.fengwei23.exercise0701.presentation_common.state.UiAction

sealed class PostListUiAction : UiAction {

    object Load : PostListUiAction()
    data class UserClick(val userId: Long, val interaction: Interaction) : PostListUiAction()
    data class PostClick(val postId: Long, val interaction: Interaction) : PostListUiAction()
}