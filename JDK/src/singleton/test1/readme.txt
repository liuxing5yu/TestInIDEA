线程安全的单例模式

https://www.cnblogs.com/x_wukong/p/3962315.html

饿汉式：EagerSingleton
懒汉式：LazySingleton
线程安全：懒汉模式加Synchronized：ThreadSafeSingleton
双重检查锁：DoubleCheckedSingleton
内部类：InnerClassSingleton
