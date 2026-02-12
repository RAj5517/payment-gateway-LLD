# 💳 Payment Gateway - Low Level Design (LLD)

## 📖 Overview

This project demonstrates the Low Level Design (LLD) of a Payment Gateway Integration Layer.

The goal is to design a modular, extensible system that supports multiple payment providers while maintaining clean separation of concerns and adherence to SOLID principles.

This repository focuses purely on object-oriented design and responsibility modeling.

---

## 🎯 Problem Statement

Design a Payment Gateway integration layer that:

- Supports multiple payment providers (Paytm, Razorpay, etc.)
- Enforces a structured payment flow
- Supports retry mechanisms
- Allows easy addition of new providers
- Maintains clean architecture
- Avoids tight coupling

---

## 🧠 Design Philosophy

There is no single “correct” solution in LLD.

This design focuses on:

- Clear separation of responsibilities
- Open/Closed Principle
- Extensibility
- Controlled abstraction
- Avoiding overengineering
- Using design patterns only where justified

---
![alt text](<Screenshot 2026-02-12 165903.png>)
---


## 🏗 Architecture Overview

Flow:

Client  
→ PaymentController  
→ PaymentService  
→ GatewayFactory  
→ PaymentGatewayProxy  
→ Concrete Gateway (Paytm / Razorpay)  
→ BankingSystem  

---

## 🧩 Design Patterns Used

### 1️⃣ Template Method Pattern

Defined in `PaymentGateway`.

It enforces a structured payment flow:

- validate()
- initiate()
- confirm()

This ensures consistency across all gateways.

---

### 2️⃣ Proxy Pattern

Implemented via `PaymentGatewayProxy`.

Responsibilities:

- Wrap real gateway
- Inject retry behavior
- Delegate execution

This keeps gateway logic clean and follows Single Responsibility Principle.

---

### 3️⃣ Strategy Pattern

Implemented via `RetryStrategy`.

Supported strategies:

- LinearRetryStrategy
- ExponentialBackoffStrategy

Retry logic is interchangeable and extensible without modifying proxy.

---

### 4️⃣ Factory Pattern

Implemented via `GatewayFactory`.

Responsibilities:

- Create concrete gateway
- Wrap inside proxy
- Inject retry strategy

Centralizes object creation and reduces coupling.

---

## 📂 Project Structure

src/
 ├── Main.java
 └── com/payment/
      ├── controller/
      ├── service/
      ├── factory/
      ├── gateway/
      │     └── impl/
      ├── proxy/
      ├── retry/
      ├── model/
      └── bank/

---

## 🚀 How to Run

Compile:

javac -d out $(find src -name "*.java")

Run:

java -cp out Main

---

## 🔍 Key Components

PaymentController  
Entry point. Delegates to service.

PaymentService  
Orchestrates gateway selection and payment execution.

PaymentGateway (Abstract)  
Defines structured template method.

Concrete Gateways  
- PaytmGateway  
- RazorpayGateway  

PaymentGatewayProxy  
Adds retry mechanism transparently.

RetryStrategy  
Encapsulates retry behavior.

---

## 📈 Extensibility

To add a new payment provider:

1. Create a new BankingSystem implementation
2. Create a new Gateway extending PaymentGateway
3. Add new case in GatewayFactory

No modification required in:
- Service
- Controller
- Proxy
- Retry logic

---

## 🧠 LLD Boundary

This project intentionally avoids:

- Database persistence
- Transaction state machine
- Async webhook processing
- Distributed architecture
- Microservices

Those belong to High Level Design (HLD).

---

## 📚 Key Learnings

- LLD has no fixed solution
- Scope control is critical
- Patterns should solve problems, not decorate code
- Clean separation improves extensibility
- Thinking process matters more than diagram

---

## 🔮 Next Steps

Moving toward High Level Design while continuing LLD problem solving in parallel.

Because:

LLD sharpens precision.  
HLD expands perspective.  

Both must mature together.

---

## 👨‍💻 Author

Part of a structured System Design learning journey.

---

#SystemDesign #LLD #DesignPatterns #Java #SoftwareArchitecture
