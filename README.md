# 🎨 AI Image Generator – Full Stack Application

A **full‑stack web application** that generates stunning images from text prompts using AI, stores generation history in a MySQL database, and provides a modern React frontend with user authentication.

---

## 📌 Project Overview

This project demonstrates a complete **Spring Boot + React** full‑stack integration. Users can:

- Enter a descriptive prompt
- Generate a unique image using the free Pollinations.ai API
- View a gallery of all their past generations
- Download images locally
- (Optional) Sign up / log in to keep their history private

The backend is built with **Spring Boot**, **Spring Data JPA**, and **MySQL**, while the frontend is a responsive **React** application with **Tailwind CSS**.

---

## ✨ Features

- ✅ **Text‑to‑Image Generation** – generate images from natural language prompts  
- ✅ **User Authentication** (JWT) – sign up, log in, and secure your history  
- ✅ **Personal History** – each user sees only their own generated images  
- ✅ **Image Download** – save generated images to your device  
- ✅ **RESTful API** – clean, well‑documented endpoints  
- ✅ **Database Persistence** – all generations stored in MySQL via JPA/Hibernate  
- ✅ **Responsive UI** – works on desktop, tablet, and mobile  
- ✅ **Real‑time Feedback** – loading spinner while image is being generated  

---

## 🛠️ Tech Stack

| Layer                | Technologies |
|----------------------|--------------|
| **Backend**          | Java 17, Spring Boot 3.x, Spring Security, JWT, Spring Data JPA, Maven |
| **Database**         | MySQL, Hibernate |
| **AI Service**       | Pollinations.ai (free, no API key required) |
| **Frontend**         | React 18, Axios, Tailwind CSS, npm |
| **Build Tools**      | Maven (backend), npm (frontend) |
| **IDE**              | Spring Tool Suite (STS) |

---

## 📋 Prerequisites

- **Java 17** or higher
- **MySQL** (installed and running locally)
- **Node.js** and **npm** (for frontend)
- **Maven** (or use the Maven wrapper included)

---

## 🚀 Setup Instructions

### 1️⃣ Clone the repository

```bash
git clone https://github.com/yourusername/ai-image-generator.git
cd ai-image-generator