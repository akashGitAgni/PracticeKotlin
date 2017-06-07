package tests


import org.junit.Test
import org.junit.Assert.*
import org.hamcrest.CoreMatchers.*
import problems.JumpGameII

class JumpGameII_Tests {


    @Test
    fun testBasicCase() {
        var jg = JumpGameII();
        //println("2, 1, 1, 1, 4 ------:" + minNumberOfSteps(arrayOf(2, 3, 1, 1, 4)));
        var ans = jg.minNumberOfSteps(arrayOf(2, 3, 1, 1, 4));
        assertThat(ans, `is`(2))
        ans = jg.minNumberOfSteps(arrayOf(2, 1, 1, 1, 4));
        assertThat(ans, `is`(3))
    }

    @Test
    fun testEmptyArray() {
        var jg = JumpGameII();

        var ans = jg.minNumberOfSteps(emptyArray());
        assertThat(ans, `is`(0))
    }
}