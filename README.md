# energy-australia-coding-evaluation
Energy Australia coding test evaluation

**The Problem**
Your team is tasked with listing out music festival data in a particular manner: at the top level, it should show the band record label, below that it should list out all bands under their management, and below that it should display which festivals they've attended, if any. All entries should be sorted alphabetically.
For example:

Record Label 1
Band X
Omega Festival
Band Y
Record Label 2
Band A
Alpha Festival
Beta Festival

## Table of Contents

- [About](#about)
- [Getting Started](#getting-started)
- -[Prerequisites](#prerequisites)
- [Installation](#installation)
- [Types of Responses](#types of responses)


## About
This project is used to provide solution to the problem above in the Problem section.

## Getting Started

## Prerequisites
- Java 17
- SpringBoot 3.1.3

## Installation
clone the git repository by using the command 
git clone https://github.com/RahulBhartiGoswami/energy-australia-coding-evaluation.git
or download this repository and extract the ZIP file in your local machine. Import it in your favourite IDE and run Application class as a main(Java) method.
Go to any Rest Client if your choice and hit the REST URL http://localhost:8080/ea/api/v1/festivals with the HTTP GET method.

## Types of Responses
you may expect 3 different types of responses
1) At the top level, it should show the band record label, below that it should list out all bands under their management, and below that it should display which festivals they've attended, if any. All entries should be sorted alphabetically.
2) You may receive an empty response in case the API "https://eacp.energyaustralia.com.au/codingtest/api/v1/festivals" sends empty response.
3) You may get Too many request exception in case the application receives "Too many request error" from the API "https://eacp.energyaustralia.com.au/codingtest/api/v1/festivals"
  
  
