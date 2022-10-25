package cl.uchile.dcc.finalreality.exceptions

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

internal class RequireTest {
    @Test
    fun requireTest() {
        assertThrows(IllegalArgumentException::class.java) { require(false) }
    }
    @Test
    fun atLeastTest() {
        assertThrows(InvalidStatValueException::class.java) { Require.Stat(1, "test") atLeast 2 }
        assertDoesNotThrow { Require.Stat(2, "test") atLeast 1 }
    }
    @Test
    fun inRangeTest() {
        assertThrows(InvalidStatValueException::class.java) { Require.Stat(1, "test") inRange 2..3 }
        assertDoesNotThrow { Require.Stat(2, "test") inRange 1..3 }
    }
}
