#include <vector>
#include <cmath>
#include <limits>


template<typename T, int M>
class Path {
private:
    std::vector<std::vector<T>> points;

public:
    void addPoint(const std::vector<T>& point) {
        points.push_back(point);
    }

    double length(){
        double total_length = 0.0;
        for (size_t i = 1; i < points.size(); ++i) {
            double dist = 0.0;
            for (int j = 0; j < M; ++j) {
                dist += (points[i][j] - points[i-1][j]) * (points[i][j] - points[i-1][j]);
            }
            total_length += std::sqrt(dist);
        }
        return total_length;
    }
};

template<typename T>
class Path<T, 1> {
private:
    std::vector<T> points;

public:
    void addPoint(const T& point) {
        points.push_back(point);
    }

    double length(){
        double total_length = 0.0;
        for (size_t i = 1; i < points.size(); ++i) {
            total_length += std::abs(points[i] - points[i-1]);
        }
        return total_length;
    }

    T minCoordinate() {
        T min_val = std::numeric_limits<T>::max();
        for (auto& p : points) {
            if (p < min_val) min_val = p;
        }
        return min_val;
    }

    T maxCoordinate() {
        T max_val = std::numeric_limits<T>::lowest();
        for (auto& p : points) {
            if (p > max_val) max_val = p;
        }
        return max_val;
    }
};
