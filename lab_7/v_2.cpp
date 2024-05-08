#include "declaration.h"
#include <unordered_map>

EquationSystem::EquationSystem() : capacity(10), size(0) {
    equations = new int[capacity * 2];
}

EquationSystem::EquationSystem(const EquationSystem& other) : capacity(other.capacity), size(other.size) {
    equations = new int[capacity * 2];
    for (int i = 0; i < size * 2; i++) {
        equations[i] = other.equations[i];
    }
}

EquationSystem::~EquationSystem() {
    delete[] equations;
}

EquationSystem& EquationSystem::operator=(const EquationSystem& other) {
    if (this != &other) {
        delete[] equations;
        capacity = other.capacity;
        size = other.size;
        equations = new int[capacity * 2];
        for (int i = 0; i < size * 2; i++) {
            equations[i] = other.equations[i];
        }
    }
    return *this;
}

void EquationSystem::addEquation(int a, int b) {
    if (size == capacity) {
        int* temp = new int[capacity * 4];
        for (int i = 0; i < size * 2; i++) {
            temp[i] = equations[i];
        }
        delete[] equations;
        equations = temp;
    }
    equations[size * 2] = a;
    equations[size * 2 + 1] = b;
    size++;
}

bool EquationSystem::hasSolution() const {
    std::unordered_map<int, int> variables; 

    for (int i = 0; i < size; ++i) {
        int a = equations[i * 2];
        int b = equations[i * 2 + 1];

        if (a == b) {
            continue;
        } else { 
          return false;
        }

        if (variables.find(a) == variables.end()) {
            variables[a] = b;
        } else {
            if (variables[a] != b) {
                return false; 
            }
        }
    }
    return true; 
}
