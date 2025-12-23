# 🚗 Smart Parking Space Detection System

A Java and OpenCV based computer vision project that automatically detects **empty** and **occupied** parking slots from a parking lot image using image processing techniques.

This project addresses real-world parking problems and can be extended for smart city applications.

---

## 📌 Problem Statement
In malls, offices, and public parking areas, drivers spend a lot of time searching for available parking spaces.  
Manual monitoring is inefficient and error-prone.  
This project aims to **automate parking space detection** using image processing.

---

## 🎯 Project Objective
- Automatically detect parking slot availability  
- Reduce time spent searching for parking  
- Provide a clear visual representation of parking status  

---

## 🛠️ Technologies Used
- Java  
- OpenCV  
- Eclipse IDE  
- Image Processing  
- Git & GitHub  

---

## ⚙️ System Workflow
1. Load the parking lot image as input  
2. Define parking slot coordinates using rectangle values  
3. Extract each parking slot as a Region of Interest (ROI)  
4. Convert ROI to grayscale  
5. Calculate mean pixel intensity  
6. Apply threshold-based logic to classify slots  
7. Display visual and console output  

---

## 🔍 Key Concepts Used
- Image Processing  
- Region of Interest (ROI)  
- Grayscale Conversion  
- Pixel Intensity Analysis  
- Threshold-based Classification  
- OpenCV Mat Operations  

---

## ✨ Features
- Detects empty and occupied parking slots from an image  
- Color-coded visualization:  
  - 🟢 Green → Empty Slot  
  - 🔴 Red → Filled Slot  
- Console output showing:  
  - Total parking slots  
  - Empty slots  
  - Occupied slots  

---

## ▶️ Output
- Visual output window displaying parking slots with bounding boxes  
- Console output showing total, empty, and filled slots  

---

## ⚠️ Limitations
- Works on static images only  
- Parking slots are manually defined  
- Accuracy may vary under different lighting conditions  

---

## 🚀 Future Enhancements
- Real-time video or CCTV camera integration  
- Automatic slot detection using Machine Learning  
- Web or mobile dashboard integration  
- IoT-based smart parking system  

---

## 📂 Project Structure
Smart-Parking-Space-Detection-System
│
├── src/
│   └── detection/
│       ├── DetectionConfig.java
│       ├── Slot.java
│       ├── SlotSelector.java
│       ├── SlotStatusDetector.java
│       └── TestOpenCV.java
│
├── parking.jpg
├── slots.txt
├── README.md


