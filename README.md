# Incoming Movies 2025 App

An Android application built with modern technologies that allows users to check and explore upcoming movies for the year 2025. The app leverages a backend-driven UI for dynamic updates and flexible A/B testing.
## Screens
| List | Grid | Detail | Error |
| -------- | ------- | ------- | ------- |
| ![Screenshot_1746390380](https://github.com/user-attachments/assets/0065452e-46a1-4904-9189-e84ca76138b3) | ![Screenshot_1746390327](https://github.com/user-attachments/assets/b3eef676-654e-4dbf-b4ca-d01a8bb33d1a) | ![Screenshot_1746390383](https://github.com/user-attachments/assets/112c7cfb-4e39-49f5-a978-a80c2160525f) | ![Screenshot_1746391516](https://github.com/user-attachments/assets/12acaa4c-f535-474e-a440-c9c004272213)


## Features
- View list of incoming movies for 2025
- Browse detailed information for each movie
- Dynamic, backend-driven UI supporting A/B testing and UI customization
- Modular design with separation of concerns

## Tech Stack

- **Jetpack Compose** for UI
- **Kotlin Coroutines** for asynchronous operations
- **Koin** for dependency injection
- **Ktor** as HTTP client
- **Architecture**: Clean + MVVM
- **Modular Approach**: Multi-module setup with separate app, feature, and library modules

## Architecture

This project follows a Clean Architecture combined with MVVM, ensuring a clear separation of concerns. The modular design divides the application into:

- **app module**: Application entry point
- **feature modules**: For specific features like movie list and movie detail
- **library modules**: Shared utilities and components
- The backend-driven UI configuration allows for real-time interface updates and targeted A/B testing without redeploying the entire app.

## Testing

- Comprehensive unit tests are included
- Integration tests and screenshot tests are currently missing

## Setup & Usage

1. Clone the repository:
```bash git clone [https://github.com/andresfabreu/moviepedia]```
2. Open the project in Android Studio.
3. Sync dependencies
4. Setup [API](https://github.com/andresfabreu/moviepedia-api)
5. Setup BASE_URL inside HttpClientConfig with your WIFI_IP
6. Run the app on an emulator or physical device
