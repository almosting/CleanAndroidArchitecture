package com.fengwei23.exercise0601.domain.usecase


import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import com.fengwei23.exercise0601.domain.entity.Result
import com.fengwei23.exercise0601.domain.entity.UseCaseException

class UseCaseTest {

    @ExperimentalCoroutinesApi
    private val configuration = UseCase.Configuration(Dispatchers.IO)
    private val request = mock<UseCase.Request>()
    private val response = mock<UseCase.Response>()

    private lateinit var useCase: UseCase<UseCase.Request, UseCase.Response>

    @ExperimentalCoroutinesApi
    @Before
    fun setUp() {
        useCase = object : UseCase<UseCase.Request, UseCase.Response>(configuration) {
            override fun process(request: Request): Flow<Response> {
                assertEquals(this@UseCaseTest.request, request)
                return flowOf(response)
            }
        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun testExecuteSuccess() = runTest {
        val result = useCase.execute(request).first()
        assertEquals(Result.Success(response), result)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun testExecuteUserException() {
        useCase = object : UseCase<UseCase.Request, UseCase.Response>(configuration) {
            override fun process(request: Request): Flow<Response> {
                assertEquals(this@UseCaseTest.request, request)
                return flow {
                    throw UseCaseException.UserException(Throwable())
                }
            }

        }
        runTest {
            val result = useCase.execute(request).first()
            assertTrue((result as Result.Error).exception is UseCaseException.UserException)
        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun testExecutePostException() {
        useCase = object : UseCase<UseCase.Request, UseCase.Response>(configuration) {
            override fun process(request: Request): Flow<Response> {
                assertEquals(this@UseCaseTest.request, request)
                return flow {
                    throw UseCaseException.PostException(Throwable())
                }
            }

        }
        runTest {
            val result = useCase.execute(request).first()
            assertTrue((result as Result.Error).exception is UseCaseException.PostException)
        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun testExecuteUnknownException() {
        useCase = object : UseCase<UseCase.Request, UseCase.Response>(configuration) {
            override fun process(request: Request): Flow<Response> {
                assertEquals(this@UseCaseTest.request, request)
                return flow {
                    throw Throwable()
                }
            }

        }
        runTest {
            val result = useCase.execute(request).first()
            assertTrue((result as Result.Error).exception is UseCaseException.UnknownException)
        }
    }
}