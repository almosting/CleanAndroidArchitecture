package com.fengwei23.exercise0701.presentation_post.single

import com.fengwei23.exercise0701.domain.usecase.GetPostUseCase
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

class PostViewModelTest {

    @ExperimentalCoroutinesApi
    private val testDispatcher: TestCoroutineDispatcher = TestCoroutineDispatcher()
    private val useCase = mock<GetPostUseCase>()
    private val converter = mock<PostConverter>()
    private lateinit var viewModel: PostViewModel

    @ExperimentalCoroutinesApi
    @Before
    fun setUp() = runBlockingTest {
        Dispatchers.setMain(testDispatcher)
        viewModel = PostViewModel(useCase, converter)
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
        val postId = 1L
        val uiState = mock<UiState<PostModel>>()
        val result = mock<Result<GetPostUseCase.Response>>()
        whenever(useCase.execute(GetPostUseCase.Request(postId))).thenReturn(
            flowOf(
                result
            )
        )
        whenever(converter.convert(result)).thenReturn(uiState)
        viewModel.handleAction(PostUiAction.Load(postId))
        assertEquals(uiState, viewModel.uiStateFlow.value)
    }
}