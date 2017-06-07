package problems

class JumpGameII() {

    fun minNumberOfSteps(prob: Array<Int>): Int {
        var reach = 0;
        var lastReach = 0;
        var steps = 0;


        for (i in prob.indices) {

            if (i > lastReach) {
                lastReach = reach;
                steps++;
            }

            if (prob[i] + i > reach) {
                reach = prob[i] + i;
            }

        }

        if (reach < prob.size - 1) {
            return 0;
        }

        return steps;
    }
}