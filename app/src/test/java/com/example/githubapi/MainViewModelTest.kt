package com.example.githubapi

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.rxjava2.observable
import com.example.githubapi.main.MainRepository
import com.example.githubapi.main.MainViewModel
import com.example.githubapi.paging.UserPagingSource
import com.example.githubapi.util.FakeNetworkApi
import com.example.githubapi.util.RxImmediateSchedulerRule
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.*

class MainViewModelTest {

    companion object {
        @ClassRule
        @JvmField
        val schedulers = RxImmediateSchedulerRule()
    }

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @MockK
    private lateinit var repository: MainRepository

    private lateinit var viewModel: MainViewModel

    private lateinit var fakeQuery: String

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxed = true)
        viewModel = MainViewModel(repository)
        fakeQuery = "app"
    }

    // FIXME
    @Test
    fun getUsersTest_success() {

        val source = UserPagingSource(FakeNetworkApi(), fakeQuery, 30, {}, {})
        val pager = Pager(
                config = PagingConfig(
                        pageSize = 30,
                        prefetchDistance = 10
                ),
                pagingSourceFactory = { source }
        )

        every { repository.getUsers(fakeQuery, { }, { }) } returns pager.observable

        viewModel.getUsers(fakeQuery)

        Assert.assertEquals(pager, viewModel.getUsers.value)
    }
}