# Booku
Booku is a multiplatform app that can be used to find books. Currently this app is only available on Android and Windows.

## Architecture
This app implements Clean Architecture which has three main layers, UI/Presentation, Domain, and Data layer. Almost all codes are shared, except the ViewModel and the navigation. The reason is Android and desktop platform have different behavior. The concept of ViewModel on Android is different with ViewModel/Controller concept on desktop. Then Compose Multiplatform has not had a navigation API yet, so I decided to make a navigation for each platform, Android and desktop.

## Tech Stack and Libraries
- Kotlin
- Kotlin Multiplatform
- Compose Multiplatform
- Koin
- Flow
- Coroutines
- Ktor Client
- Kotlin Serialization
- Image Loader by [qdsfdhvh](https://github.com/qdsfdhvh)

## Features
1. View volumes/books by category, such as Fiction, Science, Technology, Social, and Business
2. View volumes/books detail
3. Search a volume/book


## Preview

### Android
**Home**<br/>
![Home](https://res.cloudinary.com/dkwoatrfe/image/upload/w_360,h_800/v1686911435/booku_android_home_kro7av.jpg)

**Book List**<br/>
![Book List](https://res.cloudinary.com/dkwoatrfe/image/upload/w_360,h_800/v1686911435/booku_android_search_uatxeq.jpg)

**Book Detail**<br/>
![Book Detail](https://res.cloudinary.com/dkwoatrfe/image/upload/w_360,h_800/v1686911434/booku_android_detail_pi5ueo.jpg)

### Desktop (Windows)
**Home**<br/>
![Home](https://res.cloudinary.com/dkwoatrfe/image/upload/w_800,h_520/v1686911434/booku_desktop_home_iha17h.png)

**Book List**<br/>
![Book List](https://res.cloudinary.com/dkwoatrfe/image/upload/w_800,h_520/v1686911434/booku_desktop_search_h9lz5v.png)

**Book Detail**<br/>
![Book Detail](https://res.cloudinary.com/dkwoatrfe/image/upload/w_800,h_520/v1686911425/booku_desktop_detail_ybng2a.png)