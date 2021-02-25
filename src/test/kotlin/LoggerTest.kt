import com.nhaarman.mockitokotlin2.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
// import org.mockito.ArgumentMatchers.any
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class LoggerTest {

    @Mock
    lateinit var logRepo: LogRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        Logger.setLogRepo(logRepo)
    }


    @Test
    fun `log i failed`() {

// When
        Logger.i("Test", "Test1")

 // Then
        verify(logRepo, times(1)).upsert(
            check {
            assertEquals("i", it.type)
            assertEquals("Test", it.tag)
            assertEquals("Test1", it.msg)
        })
        verify(logRepo, times(1)).upsert(any())
        // Needs mockito-kotlin, mockito's any() causes a null and fails the verify.
    }
}