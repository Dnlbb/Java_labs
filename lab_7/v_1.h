#ifndef DECLARATION_H
#define DECLARATION_H

class EquationSystem {
private:
    int* equations;
    int capacity;
    int size;

public:
    EquationSystem();
    EquationSystem(const EquationSystem& other);
    ~EquationSystem();
    EquationSystem& operator=(const EquationSystem& other);

    int& operator[](int index);
    void addEquation(int a, int b);
    bool hasSolution() const;
};

#endif
