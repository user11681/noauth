This mod disables the authentication exception in development environments.

```groovy
repositories {
    maven {url = "https://auoeke.jfrog.io/artifactory/maven"}
}

dependencies {
    // See https://auoeke.jfrog.io/artifactory/maven for versions.
    modApi("user11681:noauth:latest.release")
}
```
