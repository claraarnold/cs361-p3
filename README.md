# Project 3 (Turing Machine simulator)

* Author: Joe Lathrop, Clara Arnold
* Class: CS361 001
* Semester: Fall 2023

## Overview
This assignment asked us to be able to read the contents of a file, create a Turing Machine, and run
a simulation on the input string which is given on the last line of the input file. A goal of this
assignment was for the program to run efficiently because the input files created Turing Machines with
large simulations.

## Reflection
This project helped both Joe and I gain a better understanding on Turing Machines, especially the transition
and tape aspects involved in Turing Machines. We had a lot of very thoughtful conversations about how we wanted
to structure the program, read the input file, build the Turing Machine, and handle the transition information 
while also keeping track of the tape. We started by structuring the program files and writing the basic methods we
have used in the past projects, then worked on reading the input file. There was some trouble with determining 
where the last line of the input file was, a.k.a, what the input string was. We solved this by using if statements
to determine where we were at in reading the input file, more specifically if we were between the third line and the
last transition line. 

We then moved on to creating transitions and keeping track of the tape. To do this we have a method which walks 
through the Turing Machine transitions and keeps track of the tape using a StringBuilder. At first our tape was a 
LinkedList, but we ran into some time efficiency with this because we weren't resizing the string for the tape. With
StringBuilder the string is automatically resized based on the number of characters. Once we solved this last issue 
we ran the program where the file's had input strings, rather than just blanks, and checked our answers with JFlap 
machines. 

This project was really cool and a very good accumulation of all the projects we've had this semester. We enjoyed
thinking through everything and finishing strong!

## Compiling and Using

- $ java tm.TMSimulator <filepath-to-file>\filename.txt

## Sources used

- Lecture notes
- P3 project description
- P2 and P1 machine methods

----------
