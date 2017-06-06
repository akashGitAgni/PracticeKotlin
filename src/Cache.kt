/**
 * Created by aagnihotri on 6/6/17.
 */
interface Cache {
    fun get(key: Int): Int;

    fun put(key:Int, value:Int);
}