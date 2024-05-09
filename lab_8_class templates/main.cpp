#include "Path.h"
#include <iostream>

int main() {
    Path<double, 3> path3D;
    path3D.addPoint({1.0, 2.0, 3.0});
    path3D.addPoint({4.0, 6.0, 8.0});
    std::cout << path3D.length() << std::endl;

    Path<double, 1> path1D;
    path1D.addPoint({1.0});
    path1D.addPoint({3.0});
    std::cout << path1D.length() << std::endl;
    std::cout << path1D.minCoordinate() << std::endl;
    std::cout << path1D.maxCoordinate() << std::endl;

    return 0;
}
