fun main(args: Array<String>) {
    println("Hello World")

    //var jp = JumpOverPositions();

    //SumDigits();


    var lru = LRUCache(5)

    lru.print()

    for (i in 0..4) {
        lru.put(i, i)
    }

    lru.print()
    System.out.println("getting - - " + lru.get(0));
    lru.put(6, 6);
    System.out.println("getting - - " + lru.get(0));
    System.out.println("getting - - " + lru.get(6));

}
