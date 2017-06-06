class LRUCache : Cache {

    private var cache: LinkedHashMap<Int, Int>;

    constructor(capacity: Int) {
        cache = createMapWithCapacity(capacity)
    }

    private fun createMapWithCapacity(capacity: Int): LinkedHashMap<Int, Int> {
        val cache = object : LinkedHashMap<Int, Int>(capacity, 0.9f, true) {

            override fun removeEldestEntry(eldest: MutableMap.MutableEntry<Int, Int>?): Boolean {
                return size >= capacity
            }

        }

        return cache;
    }

    override fun put(key: Int, value: Int) {
        cache.put(key, value)
    }

    override fun get(key: Int): Int {
        val key = cache[key]
        if (key == null) return -1
        else return key
    }

    fun print() {
        println("Contents")

        for ((key, value) in cache) {
            print(key)
            print("--" + value);
            println()
        }

    }
}
