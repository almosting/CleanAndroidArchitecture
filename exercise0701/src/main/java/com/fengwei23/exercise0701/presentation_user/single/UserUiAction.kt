package com.fengwei23.exercise0701.presentation_user.single

import com.fengwei23.exercise0701.presentation_common.state.UiAction

sealed class UserUiAction : UiAction {

    data class Load(val userId: Long) : UserUiAction()
}