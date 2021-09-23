# **Jemison_KotlinMMP**

## **Pre-requisites**

- Android Studio
- XCode
- git cli
- Homebrew
- java/ openjdk
- gradle
- cocoapods (iOS)


## Get **KMMP plugin** for *Android Studio*

- Open the `KotlinMMP` folder in Android Studio
- Hit shift twice and type `plugins`, search for `kmm`, install `Kotlin Multiplatform Mobile`
- Restart AS, then enter the command in your terminal
  ```zsh
  brew install gradle 
  ```

## For iOS

Error with the Gradle Main class : 
- Install gradle by running the command 
  ```zsh 
  brew install gradle
  ```
- Run the command 
  ```zsh 
  gradle wrapper
  ```
Another alternative of brew is to use sdkman. An advantage of sdkman over brew is that many versions of gradle are supported. (brew only supports the latest version and 2.14.) To install sdkman execute:
 ```zsh 
curl -s "https://get.sdkman.io" | bash
 ```
 
 - Once sdkman is installed use the command:
 ```zsh 
sdk install gradle
 ```
 - Finally run the command 
  ```zsh 
  gradle wrapper
  ```
- For pod install run the command 
```zsh 
sudo gem install cocoapods
  ```
Then change the directory to iOSApp and run :
```zsh 
pod install
  ```
 
