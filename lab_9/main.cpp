#include "Path.h"
#include <iostream>

int main() {
    Change<int> change1;
    Change<int> change2;
    change1(0) = 5;  
    change1(1) = 3;  
    change1(8) = 2;  
    change2(0) = 2;  
    change2(1) = 4;  
    change2(8) = 1;  

    Change<int> resultUnion = change1 + change2;
    Change<int> resultIntersection = change1 - change2;

    std::cout << "Кол-во 5000 купюр: " << resultUnion(8) << std::endl;
    std::cout << "Пересечение рублевых : " << resultIntersection(0) << std::endl;
    return 0;
}
