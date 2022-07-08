package com.fengwei23.exercise0701.presentation_post.list

import com.fengwei23.exercise0701.presentation_common.state.UiSingleEvent


sealed class PostListUiSingleEvent : UiSingleEvent {

    data class OpenUserScreen(val navRoute: String) : PostListUiSingleEvent()
    data class OpenPostScreen(val navRoute: String) : PostListUiSingleEvent()
}