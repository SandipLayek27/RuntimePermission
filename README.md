# RuntimePermission
Here user easily access Runtime Permission(Single and Multiple) Permissions both accessible. 
We modify this library for my working purpose.
Here, we used some pre generated libraries and modify it's working process.
## Developed
[![Sandip](https://avatars1.githubusercontent.com/u/31722942?v=4&u=18643bfaaba26114584d27693e9891db26bcb582&s=39) Sandip](https://github.com/SandipLayek27)  
# ★ Gradle Dependency
Add Gradle dependency in the build.gradle file of your application module (app in the most cases) :
First Tab:

```sh
allprojects{
    repositories{
        jcenter()
        maven {
            url 'https://jitpack.io'
        }
    }
}
```

AND

```sh
dependencies {
    compile 'com.github.SandipLayek27:SuperLoader-master_android:2.0'
}
```

# ★ Features are
1. Single Run-Time Permission.
2. Multiple Run-Time Permission.

