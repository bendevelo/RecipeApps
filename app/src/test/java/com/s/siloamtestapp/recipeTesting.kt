package com.s.siloamtestapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.s.siloamtestapp.model.Data
import com.s.siloamtestapp.model.meals
import com.s.siloamtestapp.network.RetrofitInstance
import com.s.siloamtestapp.viewModel.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.mockito.Mock
import org.mockito.MockitoAnnotations

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class recipeTesting {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()


    @Mock
    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        viewModel = MainViewModel()
    }

    @Before
    fun setup() {
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `fetchReceipe success returns user data`() = runTest {
//        val mockUsers = listOf(meals(listOf(Data("","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","",""))))

        viewModel.getDataRecipeTesting("a")
        assertEquals("4", viewModel.recipeData.value!!.size.toString())

    }


}