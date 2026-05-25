# Student Records App

A simple Android application that demonstrates how to implement a `RecyclerView` with search functionality, custom adapters, and dynamic UI updates in Java.

## Features

* **Dynamic List**: Displays a list of students with their Name, Roll Number, Department, and Grade.
* **Real-time Search**: Filter the student list instantly by typing in the search bar. Searches match names, departments, and roll numbers.
* **Custom UI Components**:
    * Uses `CardView` for list items.
    * Color-coded grade badges (Green for A, Blue for B, Orange for C, Red for others).
* **Interactivity**: Tapping on any student item shows a Toast message with their name.

## Tech Stack

* **Language**: Java
* **UI Framework**: Android XML
* **Components**: 
    * `RecyclerView` for efficient list rendering.
    * `CardView` for modern item design.
    * `TextWatcher` for real-time filtering logic.

## Project Structure

* **`MainActivity.java`**: The entry point that manages the student list, handles the search logic, and initializes the RecyclerView.
* **`Student.java`**: Data model class representing a student.
* **`StudentAdapter.java`**: Custom adapter that binds student data to the list items and manages the grade-based styling.
* **`layout/activity_main.xml`**: Main screen layout containing the search `EditText` and `RecyclerView`.
* **`layout/item_student.xml`**: Layout design for individual student rows.

## How to Run

1. Clone or download this project.
2. Open the project folder in **Android Studio**.
3. Let Gradle sync and build the project.
4. Run the app on an Android Emulator or a physical device (Minimum SDK: 24).
