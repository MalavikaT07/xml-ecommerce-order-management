# XML E-Commerce Product Management

## Project Overview

XML E-Commerce Product Management is a Java-based project developed to store, validate, and read e-commerce product information using XML.

The project demonstrates how XML documents can be structured and validated using DTD and XML Schema Definition (XSD), and how Java DOM parsing can be used to retrieve product details.

## Technologies Used

- Java (JDK 21)
- XML
- Document Type Definition (DTD)
- XML Schema Definition (XSD)
- Java DOM Parser
- Visual Studio Code

## Project Structure

```text
xml-ecommerce-order-management/
│
├── dtd/
│   └── products.dtd
│
├── src/
│   ├── XMLReader.java
│   └── XMLValidator.java
│
├── xml/
│   ├── products.xml
│   └── products.xsd
│
├── .gitignore
└── README.md
```

## Features

- Stores multiple e-commerce product records in XML format.
- Defines document structure using DTD.
- Validates XML elements, attributes, data types, and restrictions using XSD.
- Uses Java DOM parsing to read product information.
- Extracts product names, brands, prices, currencies, and dimensions.
- Handles optional product dimensions.
- Prevents DOM processing when XSD validation fails.

## How to Run the Project

### Prerequisites

- Java Development Kit (JDK 21 or compatible version)
- A Java-compatible terminal or IDE.

### Step 1: Compile the Java files

Open the terminal in the main project directory and execute:

```powershell
javac -d . src\XMLReader.java src\XMLValidator.java
```

### Step 2: Validate the XML file

```powershell
java src.XMLValidator
```

Expected output:

```text
XML is valid against the XSD schema!
```

### Step 3: Read product information

```powershell
java src.XMLReader
```

The program validates the XML file and displays the product information if validation succeeds.

## Sample Product Information

The project currently contains three sample products:

| Product ID | Product | Brand | Price |
|---|---|---|---:|
| P101 | Keyboard | Logitech | ₹1,499 |
| P102 | Mouse | HP | ₹599 |
| P103 | Monitor | Dell | ₹8,999 |

## Learning Outcomes

Through this project, I explored:

- XML document structure and syntax.
- DTD-based XML validation.
- XSD-based validation and data restrictions.
- XML elements, attributes, and namespaces.
- Java DOM parsing.
- XML validation and parsing integration in Java.
- Exception handling and file path management.

## Future Improvements

- Add product creation, updating, and deletion functionality.
- Integrate a database for persistent product storage.
- Develop a user-friendly frontend.
- Implement a complete e-commerce product management interface.

## Author

Developed as a Java and XML learning project.