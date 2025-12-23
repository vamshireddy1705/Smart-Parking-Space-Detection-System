# Smart Parking Space Detection System 🚗🅿️

A Java + OpenCV based computer vision project that detects whether parking slots are **EMPTY** or **FILLED** from an image.

---

## 🔍 Project Overview
This system analyzes a parking lot image and automatically identifies parking slot availability using image processing techniques.  
Each slot is marked with:
- 🟩 Green → EMPTY
- 🟥 Red → FILLED

The result is displayed visually and also printed in the console.

---

## 🛠️ Technologies Used
- Java
- OpenCV 4.x
- Eclipse IDE
- Git & GitHub

---

## ⚙️ How It Works
1. Load parking lot image
2. Read predefined parking slot coordinates
3. Extract each slot as ROI (Region of Interest)
4. Analyze pixel intensity to detect occupancy
5. Draw bounding boxes and labels on image

---

## 📂 Project Structure
