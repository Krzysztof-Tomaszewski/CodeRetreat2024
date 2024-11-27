# Conway's Game of Life - Code Retreat 2024

## About the Event

This repository contains two final iterations of my solution (Java and Kotlin) from **Code Retreat 2024 by Allegro Tech and Poznań JUG**, a day-long, intensive practice workshop focused on software craftsmanship. During this event, we explored the **Conway's Game of Life** problem using **Test-Driven Development (TDD)** and adhered to the **Four Rules of Simple Design** by Kent Beck:

1. The code passes all tests.
2. The code expresses the intent of the programmer (clear and readable).
3. The code does not contain duplicate logic.
4. The code has the fewest possible classes and methods.

## About Code Retreat

**Code Retreat** is a global event that promotes deliberate practice of core software development skills. Participants work on the same problem (e.g., Conway's Game of Life) in multiple iterations, resetting their code after each session. The goal is not to finish the problem but to focus on **improving skills**, learning new techniques, and fostering collaboration.

## What is Conway's Game of Life?

Conway's Game of Life is a cellular automaton devised by mathematician John Conway. It is a zero-player game where the evolution of a grid of cells is determined by a set of simple rules:

- Any live cell with fewer than two live neighbors dies (underpopulation).
- Any live cell with two or three live neighbors lives on to the next generation.
- Any live cell with more than three live neighbors dies (overpopulation).
- Any dead cell with exactly three live neighbors becomes a live cell (reproduction).

This project implements the **mechanics** of the game without focusing on rendering a visual representation of the grid.

---

## Features

- Implementation of Conway's Game of Life mechanics.
- Fully tested solution using TDD practices.
- Clean, and maintainable code designed with simplicity and clarity.

## Code Highlights

Key aspects of the implementation:

- The core logic for evolving the grid is encapsulated in the `Game` class.
- Each iteration of the game computes the next state of the grid based on Conway's rules.
- The solution is designed to be extendable and reusable for integration with a UI or visualization layer in the future.

---

## Lessons Learned

- Writing small, incremental tests first helps clarify intent and keeps code focused.
- Refactoring is easier and safer when tests are in place.
- Focusing on simplicity and avoiding over-engineering leads to cleaner designs.
- Pair programming fosters better collaboration, encourages knowledge sharing, and results in higher-quality code.
- Working closely with others during the retreat helped me learn alternative approaches, improve my communication skills, and value the feedback loop created by constant collaboration.
