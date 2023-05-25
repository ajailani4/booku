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