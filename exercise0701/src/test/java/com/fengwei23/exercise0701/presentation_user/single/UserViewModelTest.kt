package com.fengwei23.exercise0701.presentation_user.single

import com.fengwei23.exercise0701.domain.usecase.GetUserUseCase
import com.fengwei23.exercise0701.presentation_common.state.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import com.fengwei23.exercise0701.domain.entity.Result

class UserViewModelTest {

    @ExperimentalCoroutinesApi
    private val testDispatcher: TestCoroutineDispatcher = TestCoroutineDispatcher()
    private val useCase = mock<GetUserUseCase>()
    private val converter = mock<UserConverter>()
    private lateinit var viewModel: UserViewModel

    @ExperimentalCoroutinesApi
    @Before
    fun setUp() = runBlockingTest {
        Dispatchers.setMain(testDispatcher)
        viewModel = UserViewModel(useCase, converter)
    }

    @ExperimentalCoroutinesApi
    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @ExperimentalCoroutinesApi
    @Test
    fun testHandleActionLoad() = runBlockingTest {
        assertEquals(UiState.Loading, viewModel.uiStateFlow.value)
        val userId = 1L
        val uiState = mock<UiState<UserModel>>()
        val result = mock<Result<GetUserUseCase.Response>>()
        whenever(useCase.execute(GetUserUseCase.Request(userId))).thenReturn(
            flowOf(
                result
            )
        )
        whenever(converter.convert(result)).thenReturn(uiState)
        viewModel.handleAction(UserUiAction.Load(userId))
        assertEquals(uiState, viewModel.uiStateFlow.value)
    }
}