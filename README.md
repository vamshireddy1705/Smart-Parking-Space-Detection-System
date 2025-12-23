# 🚗 Smart Parking Space Detection System

A Java + OpenCV based computer vision project that detects parking slot availability from an image and visually marks each slot as **EMPTY** or **FILLED**.

This project demonstrates the practical use of **image processing**, **ROI (Region of Interest)** handling, and **pixel intensity analysis** for real-world smart city applications.

---

## 🛠️ Technologies Used
- Java
- OpenCV
- Eclipse IDE
- Image Processing

---

## 📌 Features
- Detects empty and filled parking slots from an image
- Slot selection using fixed coordinates
- Color-coded output:
  - 🟢 Green → Empty slot
  - 🔴 Red → Filled slot
- Console summary of total, empty, and filled slots

---

## ▶️ How It Works
1. Input parking image is loaded
2. Parking slots are defined using rectangle coordinates
3. Each slot is converted to grayscale
4. Mean pixel intensity is calculated
5. Slot status is decided based on a threshold
6. Output is displayed visually and in console

---

## ▶️ Output
- Visual output window showing parking slots
- Console output with total, empty and filled slots

---

## 🚀 Future Enhancements
- Real-time camera/video support
- Machine Learning based detection
- Web or mobile dashboard

---

## 👤 Author
**Vamshi Reddy Vangal**  
GitHub: https://github.com/vamshireddy1705