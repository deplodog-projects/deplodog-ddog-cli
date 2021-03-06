plugins {
    java
    id("org.javamodularity.moduleplugin") version Plugins.module
    id("org.beryx.jlink") version Plugins.jlink
}

application {
    mainClassName = "ddog.cli.app/com.deplodog.ddog.app.CliApplication"
    applicationName = "ddog"
}

commonDependencies()
dependencies {
    compile(project(":ddog.cli.core"))
}

jlink {
    addOptions("--strip-debug", "--compress", "2", "--no-header-files", "--no-man-pages")
    launcher {
        name = "ddog"
    }
    jpackage {
        jpackageHome = "/home/aleks/work/JDK/openjdk-13-jpackage+36_linux-x64_bin/jdk-13"
        outputDir = "ddog"
        imageName = "ddog"
        skipInstaller = false
        installerName = "ddog"
        installerOptions = listOf(
                "--app-version", "0.0.1",
                "--description", "CLI to simplify Kubernetes deployment, see https://deplodog.com for details",
                "--vendor", "Deplodog"
        )
    }
}
