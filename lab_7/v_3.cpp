#include "declaration.h"
#include <iostream>

int main() {
    EquationSystem system;

    system.addEquation('a', 5);
    system.addEquation('a', 6);
    system.addEquation(2, 7);

    bool hasSolution = system.hasSolution();

    if (hasSolution) {
        std::cout << "Система имеет решение.\n";
    } else {
        std::cout << "Система не имеет решения.\n";
    }

    return 0;
}
