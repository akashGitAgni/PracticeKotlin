
At Google I/O 2017, Google announced that it will officially support Kotlin on Android as a "first class" language. This was one of the most exciting things announced by Google for Android developers. A lot of developers are already using Kotlin in production. JetBrains--the company behind the awesome Intellij IDE--started working on Kotlin in 2011 and Kotlin 1.0 was released in 2016. According to Wikipedia, "Kotlin is a statically-typed programming language that runs on the Java Virtual Machine and also can be compiled to JavaScript source code or uses the LLVM compiler infrastructure." As Kotlin was designed with a philosophy of interoperability with Java, it was the obvious choice for Android app development. Kotlin can also generate Javascript code that is compatible with CommonJS.  

Now that we are aware of what Kotlin is, let's look at some of the features of the language. 
### Concise
**Data Classes**

We often write classes that do nothing but hold data and we all know how big those classes can get, after adding these methods ``` get()```, ```set()```, ```equals()``` and ```hashCode()```. 
For this, Kotlin has the option of "data class". The data class generates ``` equals()``` / ```hashCode() ``` pair, ```toString()``` and ```copy()```.

```
    data class AuthToken(val userId: Long, val accessToken: String)
```

No getters required as properties which are immutable here can be accessed like this:
```
    val auth: AuthToken = AuthToken(1000L, "1234")
    auth.accessToken
    auth.userId
```
**Listeners**

Let's take another example, this is how a "click listener" looks in Java.
```
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
    
        }
    });
```
Same code in Kotlin will look like 
```
    button.setOnClickListener { 
            //do something 
    }
```

**Switch statement**

Kotlin has a "```when```" expression, which is basically "```switch```" with super powers.

"```when```" can be used like switch statement. Lets look at a example of using "when" for auto-casting:
```
//Java code: Check instaceof for object and then cast it to call the appropriate method
     
     if (videoPlayer instanceof CastPlayer) {
        ((CastPlayer)videoPlayer).castMethod();
     }else if(videoPlayer instanceof MediaPlayer){
        ((MediaPlayer)videoPlayer).mediaMethod();
     }
 
 
//Same code in Kotlin using "when":
 
     when (videoPlayer) {
        is MediaPlayer -> videoPlayer.mediaMethod()
        is CastPlayer -> videoPlayer.castMethod()
     }
```

**Singleton**

Writing thread-safe and lazy singleton class in Java can be a tedious job. Kotlin has simplified singletons.
```
object MySingleton {

    var x: Int = 0

    fun increment(): Int {
        x += 1
        return x
    }
}
```
Here ```object``` keyword is used to create a singleton object with name "MySingleton".
### Null Safety

Kotlin type system is designed to eliminate NPE(Null pointer exceptions) which are also called [The Billion dollar mistake](https://en.wikipedia.org/wiki/Tony_Hoare#Apologies_and_retractions). Lets look at a example.

```
    var auth: AuthToken = null; // Compilation error
    
    var nullableAuth: AuthToken? = null;
    
    val userID = nullableAuth.userId; //compilation error.
    
    // Safe Call operator "?." to the rescue:
    val userID = nullableAuth?.userId;
    
    // This can also be chained:
    val userString = nullableAuth?.userId?.toString();

```

### Extensions
Kotlin supports extension functions and extension properties. This provides the ability to extend a class with new functionality without having to inherit from the class.
This is very helpful when we want extend the ability of certain library classes.
Lets look at a example. The following adds a swap method to ```Array<Int>```(simmilar to ```ArrayList``` in Java)
```
//Extension function :
    
   fun Array<Int>.swap(index1:Int,index2:Int){
        val tmp = this[index1] // 'this' corresponds to the list
        this[index1] = this[index2]
        this[index2] = tmp
    }
    
   var array = arrayOf(1,2,3,4)
   array.swap(0,2);
   
//Extension property:

   val Array<Int>.lastIndex: Int
           get() = size - 1
           
   val last = array.lastIndex;        
    
```

### Higher Order Functions
"This is just a really fancy term for functions that accept a function, or functions that return a function " [source](https://www.youtube.com/watch?v=fPzxfeDJDzY&t=43s)

```
func apply(one: Int, two: Int, func: (Int, Int) -> Int): Int {
  return func(one, two)
}

val sum = apply(1, 2,) { x, y -> x + y }
val difference = apply(1, 2,) { x, y -> x - y }

```
 Here in this example, the apply function--which is a higher-order function--takes two integers as arguments and a function as third argument. Inside the method body it calls that fucntion using the 2 arguments and returns the result.


By now you might have noticed that Kotlin is very similar to [Swift](https://developer.apple.com/swift/) . Yes, it is, and this blog post summarizes that: http://nilhcem.com/swift-is-like-kotlin/

I have just started to learn and explore Kotlin. As per my little experience with Kotlin, it is a modern language like Swift. It has great IDE support with features like, converting Java code to Kotlin and decompiling byte code to Java and many more . I will continue to explore Kotlin and start developing new features for Android apps in Kotlin.

Some Useful Links:

[Official Kotlin reference]( https://kotlinlang.org/docs/reference.html)

[Kotlin in Production- Christina Lee, Pinterest ](https://www.youtube.com/watch?v=mDpnc45WwlI)

[Kotlin for Nodejs](https://medium.com/@Miqubel/your-first-node-js-app-with-kotlin-30e07baa0bf7)


