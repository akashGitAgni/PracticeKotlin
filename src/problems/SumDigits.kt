package problems

class SumDigits {

    constructor() {
        println("12 - Ans - " + sumDigits(12));
        println("11234567 - Ans - " + sumDigits(11234567));
    }


    fun sumDigits(number: Int): Int {
        var sum: Int = 0;
        var divider: Int = 10;
        var num: Int = number;

        while (num > 0) {
            val rem = num % divider;
            sum += rem;
            num /= 10;
        }
        return sum;
    }
}