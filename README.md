# LumiformApp 📋

An Android Jetpack Compose app built for a coding challenge to parse, persist, and display a deeply nested JSON form structure. Includes image support, offline capability, and a clean architecture approach with modern Android development tools.

---

## ✨ Features

- 🗂️ Recursive rendering of nested pages, sections, and questions
- 📸 Full-screen image viewer with back navigation
- 🛜 Offline support via Room database
- 🔄 Remote data sync with Retrofit
- 💡 State management using Kotlin Flows and ViewModel
- 💬 Error & loading state handling with `ResultState` sealed class

---

## 🧱 Architecture


- **UI Layer**: Jetpack Compose + Navigation
- **ViewModel**: Observes data state (`NetworkState`) and maps entities to UI models
- **Repository**: Handles API fetch and local DB fallback
- **Room**: Persists structured forms locally
- **Retrofit + Moshi**: Fetches JSON and maps it into structured models
- **Hilt**: Dependency injection

---

## 🔧 Tech Stack

- **Kotlin** + **Jetpack Compose**
- **Room**
- **Retrofit** + **Moshi**
- **Kotlin Coroutines / Flow**
- **Hilt** for DI
- **Glide (Compose integration)** for image loading

---

## 📁 Folder Structure (Core)

.
├── data/
│ ├── local/ # Room entities & DAO
│ ├── remote/ # Retrofit API & DTOs
│ └── ui/ # UI models (Page, Section, Question)
│
├── mainscreen/ # ViewModel, Repository & Composables
├── di/ # Hilt modules
└── MainActivity.kt # App entry point with NavHost

---

## 🚀 How to Run

1. Clone the repo:
   ```bash
   git clone https://github.com/ikbal995/LumiformApp.git
