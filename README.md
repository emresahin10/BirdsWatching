# 🦜 Birds Watching

Birds Watching is a modern Android application that helps users discover and learn about various bird species. The app provides detailed information about birds, including their habitats, characteristics, and images.

## 🛠 Tech Stack & Features

### Architecture & Design
- **Clean Architecture** with feature-based modularization
- **MVI** (Model-View-Intent) pattern for unidirectional data flow
- **Multi-module** project structure inspired by [Now in Android](https://github.com/android/nowinandroid)
- **Material Design 3** with dynamic theming

### Libraries & Frameworks
- **Jetpack Compose** for modern UI development
- **Kotlin** as the programming language
- **Coroutines & Flow** for asynchronous programming and state management
- **Hilt** for dependency injection
- **Retrofit** for network operations
- **Coil** for image loading
- **MockK** for unit testing

### Project Structure
```
app/
├── core/
│   ├── common/        # Common utilities and extensions
│   ├── data/          # Data layer with repositories
│   ├── network/       # Network layer with API services
│   ├── model/         # Domain models
│   ├── ui/            # Common UI components
│   └── designsystem/  # Design system and theming
└── feature/
    ├── home/          # Home screen feature
    └── detail/        # Bird detail screen feature
```

## 🎨 Design System
The app implements a custom design system with:
- Nature-inspired color palette
- Consistent typography
- Reusable components:
  - Buttons
  - Cards
  - Text Fields
  - Loading Indicators

## 🔌 API Integration
This app uses the [Birds API](https://github.com/emresahin10/bird-watching-api) for fetching bird data. The API provides:
- List of bird species
- Detailed bird information
- Bird images
- Search functionality

## 🚀 Getting Started

### Prerequisites
- Android Studio Hedgehog or newer
- JDK 17
- Android SDK with minimum API level 26

### Setup
1. Clone the repository:
```bash
git clone https://github.com/emresahin10/BirdsWatching.git
```

2. Open the project in Android Studio

3. Sync the project with Gradle files

4. Run the app on an emulator or physical device

## 📱 Features
- Browse various bird species
- View detailed information about each bird
- Search for specific birds
- Save favorite birds
- Dark/Light theme support
- Material You dynamic theming

## 🧪 Testing
The project includes:
- Unit tests using JUnit and MockK
- UI tests using Compose testing framework
- Integration tests for the data layer

## 📄 License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🤝 Contributing
Contributions are welcome! Please feel free to submit a Pull Request. 
