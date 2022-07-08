package com.fengwei23.exercise0701.presentation_user.single

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fengwei23.exercise0701.presentation_common.navigation.UserInput
import com.fengwei23.exercise0701.presentation_common.state.CommonScreen

@Composable
fun UserScreen(
    viewModel: UserViewModel,
    userInput: UserInput
) {
    viewModel.uiStateFlow.collectAsState().value.let { result ->
        CommonScreen(result) { userModel ->
            User(userModel)
        }
    }
    LaunchedEffect(userInput.userId) {
        viewModel.submitAction(UserUiAction.Load(userInput.userId))
    }
}

@Composable
fun User(userModel: UserModel) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = userModel.name)
        Text(text = userModel.username)
        Text(text = userModel.email)
    }
}